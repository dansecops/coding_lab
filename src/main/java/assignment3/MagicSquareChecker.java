/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 * @author Skjallar
 */

;

public class MagicSquareChecker {


    public boolean checkMagicSquqare(int[][] square) {

        for (int i = 0; i < square.length; i++) { //line
            int result = 0;
            for (int j = 0; j < square.length; j++) { //number
                result = result + square[i][j];
            }
            if(result != 15) {
                return false;
            }

        }

        for (int i = 0; i < square.length; i++) { //column
            int result = 0;
            for (int j = 0; j < square.length; j++) { //number
                result = result + square[j][i];
            }
            if(result != 15) {
                return false;
            }

        }

        int diagonalResultOne = 0;

        for (int i = 0; i < square.length; i++) {
            diagonalResultOne = diagonalResultOne + square[i][i];

        }
        if(diagonalResultOne != 15) {
            return false;
        }

        int diagonalResultTwo = 0;

        for (int i = 0; i < square.length; i++) {
            diagonalResultTwo = diagonalResultTwo + square[(square.length)-(i+1)][i];
        }
        if(diagonalResultTwo != 15) {
            return false;
        }

        return true;
    }


    //calculate wh
}
