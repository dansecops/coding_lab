package heap.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.max;

public class HeapSort {

   /*// The task is to complete heapify() and buildHeap() functions which are used to implement Heap Sort.

    Inut:
    First line of the input denotes number of test cases 'T'. First line of the test case is the size of array and
    second line consists of array elements.


    Output:
    Sorted array in ascending order.


            Constraints:
            1 <=T<= 50
            1 <=N<= 1000
            1 <=arr[i]<= 1000


    Example:

    Input:
            4
            5
            4 1 3 9 7
            10
            10 9 8 7 6 5 4 3 2 1
            2
            1 2
            6
            1 2 3 4 5 6 7 8

    Output:
            1 3 4 7 9
            1 2 3 4 5 6 7 8 9 10*/

    public static void main(String[] args) {

        List<String> input = Arrays.asList(
                "4 1 3 9 7",
                "10 9 8 7 6 5 4 3 2 1"
        );

        for (String inputStr : input){
            String[] split = inputStr.split(" ");
            int[] ints = Stream.of(split).mapToInt(s -> Integer.valueOf(s)).toArray();
            heapify(ints, 0 , ints.length);
            buildHeap(ints, ints.length);

            System.out.println(IntStream.of(ints).mapToObj(i-> String.valueOf(i)).collect(Collectors.joining(", ")));
        }


    }

    static void heapify(int arr[], int n, int j)  {
        int i = n-1;
        while(i>j) {
            if (i%2 == 0) {
                if (arr[(i-2)/2] < max(arr[i], arr[i-1])) {
                    if (arr[i] < arr[i-1]) swap(arr, (i-2)/2,i-1);
                    else swap(arr, (i-2)/2, i);
                }
                i -= 2;
            } else {
                if (arr[(i-1)/2] < arr[i]) swap(arr, (i-1)/2, i);
                i -= 1;
            }
        }
    }

    static private void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    static void buildHeap(int arr[], int n)  {
        int i = n-1;
        while(i>0) {
            if (i%2 == 0) {
                if (arr[(i-2)/2] < max(arr[i], arr[i-1])) {
                    if (arr[i] < arr[i-1]) swap(arr, (i-2)/2, i-1);
                    else swap(arr, (i-2)/2, i);
                }
                i -= 2;
            } else {
                if (arr[(i-1)/2] < arr[i]) swap(arr, (i-1)/2, i);
                i -= 1;
            }
        }
    }

}
