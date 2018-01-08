package sumfinder;

public class Main {

    /**
     "Problem: Find matching pairs of objects in an array that add up to a certain value!
     The problem is to find in an array A of integral values (long, int, short, byte) the number of all pairs of
     indices (i,j) so that A[i] + A[j] == K.
     For example, let A = {1, 5, 9} with K = 10 we get the pairs (0, 2), (2,0), and (1,1) and the result of the
     algorithm should be 3.
     Please implement a solution in java that works for Long-, Integer-, Short-, and Byte–arrays! Try to find
     an efficient solution! Test your implemented algorithm in an appropriate way!
     Extend your solution to also work on Strings, e.g. K="test", A ={"te", "st"} gives the pair (0, 1).”
     * @param args
     */

    //Note: use iterator
//    public static void main(String[] args) {
//        Integer[] arr = {1, 40, 20, 50, 80, 50, 50, 75};
//        int a = 100;
//        int result = nsf.find_sums(a, arr);
//        System.out.println(result);
//    }

        // generic method printArray
        public static < E extends Comparable<E>> void printArray( E[] inputArray ) {
            // Display array elements
            for(E element : inputArray) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }

        public static void main(String args[]) {
            // Create arrays of Integer, Double and Character
            Integer[] intArray = { 1, 6, 5, 3, 7,5, 5, 4,5 };
            Double[] doubleArray = {0.0, 2.0, 4.6, 4.4 };
            Byte[] byteArray = {60, 100, 20};
            Short[] shortArray = {1, 2, 3};
            Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
            String[] StringArray = { "tes", "ma", "te", "st", "t", "t", "tes"};


            NumberSumFinder nsf = new NumberSumFinder();
            StringSumFinder ssf = new StringSumFinder();

            System.out.println("Array integerArray contains:");
            printArray(intArray);   // pass an Integer array
            System.out.println("\nResult: " + nsf.find_sums(10, intArray));

            System.out.println("\nArray doubleArray contains:");
            printArray(doubleArray);   // pass a Double array
            System.out.println("\nResult: " + nsf.find_sums(8.8, doubleArray));

            System.out.println("\nArray byteArray contains:");
            printArray(byteArray);   // pass a Double array
            System.out.println("\nResult: " + nsf.find_sums(120, byteArray));

            System.out.println("\nArray shortArray contains:");
            printArray(shortArray);   // pass a Double array
            System.out.println("\nResult: " + nsf.find_sums(50, shortArray));

            System.out.println("\nArray StringArray contains:");
            printArray(StringArray);   // pass a Double array
            System.out.println("\nResult: " + ssf.find_sums("test", StringArray));
        }
}