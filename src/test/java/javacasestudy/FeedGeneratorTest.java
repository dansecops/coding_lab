package javacasestudy;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class FeedGeneratorTest {

    static String[] certificateValues;

    Logger LOGGER = Logger.getLogger(FeedGeneratorTest.class.getName());
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
    public void name() {
    }

    @Test
    public void testMain() throws Exception {
        FeedGenerator fg = new FeedGenerator();
        String call = fg.call();
        LOGGER.info(call);
    }




}