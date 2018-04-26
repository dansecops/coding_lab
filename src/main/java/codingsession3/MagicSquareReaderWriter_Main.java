/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingsession3;

/**
 * @author Skjallar
 */

import java.util.*;
import java.io.*;

public class MagicSquareReaderWriter_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MagicSquareReaderWriter msrw = new MagicSquareReaderWriter();
        int[][] magicSquare = msrw.readMultiDimArray("input.txt");
        for (int i = 0; i < magicSquare.length ; i++) {
            for (int ii = 0; ii < magicSquare[i].length; ii++) {
                System.out.print(magicSquare[i][ii]+" ");
            }
            System.out.println("");
        }
    }

    public static int[][] readFileElements(String fileLoc) {
        try {
            File inputFile = new File(fileLoc);
            Scanner input = new Scanner(inputFile);

        } catch (FileNotFoundException e) {

        }

        return null;

    }



}
