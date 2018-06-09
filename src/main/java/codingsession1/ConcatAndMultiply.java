/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open tha template in the editor.
 */
package codingsession1;

/**
 *
 * @author Skjallar
 */
public class ConcatAndMultiply {

    public String concatenate(String one, String two) {
        return one + two;
    }

    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public int arrayCount9(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 9) {
                count++;
            }
        }
        return count;
    }

}
