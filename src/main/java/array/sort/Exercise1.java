package array.sort;

public class Exercise1 {

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

    public static < E extends Number> int find_sums(E sum, E arr[]) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                if (arr[i].longValue() + arr[j].longValue() == sum.longValue()) {
                    result++;

                    if (arr[i] != arr[j]) {
                        result++;
                    }
                }

            }

        }
        return result;
    }

//    public static void main(String[] args) {
//        Integer[] arr = {1, 40, 20, 50, 80, 10, 25, 75};
//        int a = 100;
//        int result = find_sums(a, arr);
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
            Integer[] intArray = { 1, 2, 3, 4, 5, 5 };
            Double[] doubleArray = {0.0, 2.0, 4.6, 4.4 };
            Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

            System.out.println("Array integerArray contains:");
            printArray(intArray);   // pass an Integer array
            System.out.println("\nResult: " + find_sums(10, intArray));

            System.out.println("\nArray doubleArray contains:");
            printArray(doubleArray);   // pass a Double array
            System.out.println("\nResult: " + find_sums(8.8, doubleArray));

            System.out.println("\nArray characterArray contains:");
            printArray(charArray);   // pass a Character array
        }

}