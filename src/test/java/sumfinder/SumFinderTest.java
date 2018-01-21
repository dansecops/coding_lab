package sumfinder;

import org.junit.*;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SumFinderTest {
    @Test
    public void testStringSumFinder() {
        String[] StringArray1 = { "tes", "te", "st", "t", "t", "tes"};
        String[] StringArray2 = { "ma", "ma", "am", "MA", "AM", "bled"};

        StringSumFinder ssf = new StringSumFinder();

        assertEquals(ssf.find_sums("test", StringArray1), 2);
        assertEquals(ssf.find_sums("mama", StringArray2), 1);
        assertEquals(ssf.find_sums("mama", StringArray1), 0);

    }

    @Test
    public void testNumberSumFinder() {
        Integer[] intArray = { 1, 6, 5, 3, 7,5, 5, 4,5 };
        Double[] doubleArray = {0.0, 2.0, 4.6, 4.4 };
        Byte[] byteArray = {60, 100, 20};
        Short[] shortArray = {1, 2, 3};


        NumberSumFinder nsf = new NumberSumFinder();

        Byte byteResult = 120;
        Short shortResult = 120;

        assertEquals(nsf.find_sums(10, intArray), 5);
        assertEquals(nsf.find_sums(8.8, doubleArray), 1);

        assertEquals(nsf.find_sums(120, byteArray), 3);
        assertEquals(nsf.find_sums(50, shortArray), 0);


    }

    @Test
    public void testNumberSumFinde2r() {
        System.out.println('A'+0);
    }

}