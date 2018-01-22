package javacasestudy;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class FeedGeneratorTest {

    static String[] certificateValues;

    Logger LOGGER = Logger.getLogger(this.getClass().getName());
    //Validates
    //ISIN (string, 2 random uppercase alphabets + 9 random alphanumeric characters + 1 check digit)
    //Example isin: "APTY4YB3H83");
    @BeforeClass
    public static void call() throws Exception {
        FeedGenerator fg = new FeedGenerator();

        String call = fg.call();
        certificateValues = call.split(",");


    }

    @Test
    public void checkIsin() {
        //Ask Igor : test still fails sometimes, because of 13 digits?

        String isin = certificateValues[1];
        String pattern = "^([A-Z]){2}[A-Z0-9]{9}\\d$";

        assertTrue("Length should be 12, but was "+isin.length() ,isin.length() == 12);
        assertTrue("Isin should match pattern:"+pattern+", but was: "+isin, isin.matches(pattern));

    }

    @Test
    public void testCheckDigit() {
        String isin = certificateValues[1];
        StringBuilder sb = new StringBuilder();

        String digitString = (isin.substring(isin.length() - 1));
        char[] chars = digitString.toCharArray();

        LOGGER.info("Digit length: " + chars.length + "\nChar Value: " + chars[0]);

        assertTrue("Length should be 1, but was: ",chars.length == 1);
        assertTrue("Character isDigit should be true, but is: ", Character.isDigit(chars[0]));
        assertTrue("Value should be between 0 and 9, but its not! ",
                (Character.getNumericValue(chars[0]) >= 0) && (Character.getNumericValue(chars[0]) <= 10));
    }


    @Test
    public void checkBidAskPrice() {
        try {
            double bidPrice= Double.parseDouble(certificateValues[2]);
            double askPrice = Double.parseDouble(certificateValues[4]);
            boolean resultBidPrice = false;
            boolean resultAskPrice = false;
            LOGGER.info("Bid Price: " + bidPrice + "\nAsk Price: " + askPrice);

            resultBidPrice = bidPrice >= 100.00 && bidPrice <= 200.00;
            resultAskPrice = askPrice >= 100.00 && askPrice <= 200.00;

            assertTrue("Bid price should be between 100.00 and 200.00, but was: " + bidPrice, resultBidPrice);
            assertTrue("Ask price should be between 100.00 and 200.00, but was: " + askPrice, resultAskPrice);

        } catch (NumberFormatException nfe) {
            LOGGER.info("Bidprice and/or ask price don't seem to be of type double.");
        }

    }

    @Test
    public void checkBidAskSize() {
        try {
            int bidSize= Integer.parseInt(certificateValues[3]);
            int askSize = Integer.parseInt(certificateValues[5]);
            boolean resultBidSize = false;
            boolean resultAskSize = false;
            LOGGER.info("Bid Size: " + bidSize + "\tAsk Size: " + askSize);

            resultBidSize = bidSize >= 1000 && bidSize <= 5000;
            resultAskSize = askSize >= 1000 && askSize <= 10000;

            assertTrue("Bid size should be between 1000 and 5000, but was: " + bidSize, resultBidSize);
            assertTrue("Ask size should be between 1000 and 10000, but was: " + askSize, resultAskSize);

        } catch (NumberFormatException nfe) {
            LOGGER.info("Bid price and/or ask size don't seem to be of type integer.");
        }

    }

    @Test
    public void testMain() throws Exception {
        FeedGenerator fg = new FeedGenerator();
        String call = fg.call();
        LOGGER.info(call);
    }




}