package array.sort;

public class Main {

    public static void main(String[] args) {

        int inputArray[] = new int[]{1, 6 , 2, 7, 12, 9, 8, 14, 5, 3};
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i]+", ");
        }
        int k = 16;

        System.out.println();

        //iterate through array
        //check if array[n] and [n+1] is k
        //check if array[n] and [n+2= ] is k


        boolean repeat = false;
        do {
            repeat = false;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if(inputArray[i] >= inputArray[i+1]) {
                    int tmp = 0;
                    repeat = true;
                    tmp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = tmp;
                }
            }
        } while(repeat);

        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i]+", ");
        }

/*
1, 6 , 2, 7, 12, 9, 8, 14, 5, 3

i=0
1 >= 6
i = 1
6 >= 2
tmp = 0
tmp = 6

inputarray[1] = inputarray[1+1]
1, 2, 2, 7, 12, 9, 8, 14, 5, 3
inputarray[1+1] = 6
1, 2, 6, 7 12, 9, 8, 14, 5, 9

i = 2
6 >= 7

i = 3
7 >= 12
i = 4
12 >= 9
tmp = 0
tmp = 12
inputarray[4] = inputarray[5]
1, 2, 6, 7, 9, 9, 8, 14
inputarray[5] = 12
1, 2, 6, 7, 9, 12, 8, 14, 5, 9

i = 5
12 >= 8
tmp = 0
tmp = 12
inputArray[5] = inputarray[6]
1, 2, 6, 7, 9, 8, 8, 14
inputarray[6] = 12
1, 2, 6, 7, 9, 8, 12, 14

i = 6
12 >= 14
i = 7
14 >= oout of bnd

1, 2, 2, 7, 12, 9, 8, 14, 5, 1
1, 2, 6, 7, 9, 8, 12, 5, 1, 14

                /**

         1,2,6, 7,8,9,12, 14

        16

        7 9
        9 7
        8 8
        2 14
        14 2


        5
                 **/

    }
}
