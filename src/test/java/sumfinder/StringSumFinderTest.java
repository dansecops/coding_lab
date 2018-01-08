package sumfinder;

import org.junit.Test;

import static sumfinder.Main.printArray;


public class StringSumFinderTest {
    @Test

    public void testNumberSumFinder() {
        String[] StringArray = { "tes", "ma", "te", "st", "t", "t", "tes"};
        StringSumFinder ssf = new StringSumFinder();

        int expectedResult = 5;

        System.out.println("\nArray StringArray contains:");
        printArray(StringArray);   // pass a Double array
        System.out.println("\nResult: " + ssf.find_sums("test", StringArray));







    }
}