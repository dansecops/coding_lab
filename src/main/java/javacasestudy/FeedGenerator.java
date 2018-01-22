package javacasestudy;

import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FeedGenerator implements Callable<String> {

    Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private static final Random random = new Random();


    /*
    A certificate update
    has the following properties:

    Timestamp (number of milliseconds since January 1, 1970, 00:00:00 GMT)
    ISIN (string, 2 random uppercase alphabets + 9 random alphanumeric characters + 1 check digit)
    Bid Price (random number, 2 decimal places, range between 100.00 and 200.00 inclusive)
    Bid Size (random number, 0 decimal place, range between 1,000 and 5,000 inclusive)
    Ask Price (random number, 2 decimal places, range between 100.00 and 200.00 inclusive)
    Ask Size (random number, 0 decimal place, range between 1,000 and 10,000 inclusive)
    ISIN check digit calculation:
     */

    @Override
    public String call() throws Exception {

        String timestamp = String.valueOf(System.currentTimeMillis());
        String isin = generateIsin();
        String bidPrice = getRandomDouble(100.00, 200.00);
        String bidSize = getRandomInt(1000, 5000);
        String askPrice = getRandomDouble(100.00, 200.00);
        String askSize = getRandomInt(1000, 10000);

        String result = Stream.of(timestamp, isin, bidPrice, bidSize, askPrice, askSize)
                .collect(Collectors.joining(","));
        //LOGGER.log(Level.INFO,result);
        return result;
    }

    //Question to Igor: How to make this using generics (type independent)
    private String getRandomInt(int lower, int upper) {
       return String.valueOf(random.nextInt((upper - lower) + 1) + lower);
    }

    private String getRandomDouble(double lower, double upper) {
        return String.valueOf(lower + (upper - lower) * random.nextDouble());
    }

    private String generateIsin() {
        String randomChars = createRandomChar() + createRandomChar();
        StringBuilder alphaNumeric = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            alphaNumeric.append(randomAlphaNumeric());
        }
        String isinNoCheckDigit = randomChars+alphaNumeric.toString();
        return isinNoCheckDigit+checkDigit(isinNoCheckDigit);

    }

    private String createRandomChar() {
        return String.valueOf((char) (random.nextInt(26) + 'A'));
    }

    private String randomAlphaNumeric() {
        int indexRandom = random.nextInt(36);
        if(indexRandom < 10) {
            return String.valueOf(indexRandom);
        } else {
            return String.valueOf((char) (55 + indexRandom));
        }
    }

    protected String checkDigit(String isin) {

        String isinNumbers = convertIsintoDigits(isin);
        char[] isinDigits = isinNumbers.toCharArray();

        int sum = 0;
        for (int i = 0; i < isinDigits.length; i++) {
            Integer currentNumber = Integer.parseInt(String.valueOf(isinDigits[i]));

            if(i % 2 == 0) {
                int multipliedNumber = currentNumber*2;
                if (multipliedNumber >= 10) {
                    int firstPart = multipliedNumber / 10;
                    int secondPart = multipliedNumber % 10;
                    sum += firstPart + secondPart;
                } else {
                    sum += multipliedNumber;
                }
            } else {
                sum += currentNumber;
            }

        }
        int countOfTens = sum / 10;
        if(countOfTens == 0){
            return String.valueOf(0);
        } else {
            return String.valueOf(((countOfTens + 1) * 10) - sum);
        }
    }

    private String convertIsintoDigits(String isin) {
        char[] isinChars = isin.toCharArray();
        for (int i = 0; i < isinChars.length; i++) {
            if(isinChars[i] >= 'A') {
                isinChars[i] = (char) (isinChars[i] - 55);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < isinChars.length; i++) {
            builder.append((int)isinChars[i]);
        }
        return builder.toString();
    }




}
