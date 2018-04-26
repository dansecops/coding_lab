/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingsession3;
import java.io.*;

/**
 *
 * @author Skjallar
 */
public class MagicSquareReaderWriter {

    public int[][] readMultiDimArray(String filename) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String line = buffer.readLine();
        String[] vals = splitString(line);
        int[][] square =  new int[vals.length][vals.length];
        int row = 0;
        fillArrayLine(row, line, square);
        while ((line = buffer.readLine()) != null) {
            row++;
            fillArrayLine(row, line, square);
        }
        return square;
    }

    private String[] fillArrayLine( int row, String line, int[][] square) {
        String[] vals = splitString(line);
        for (int column = 0; column < vals.length; column++) {
            vals = splitString(line);
            square[row][column] = Integer.parseInt(vals[column]);
        }
        return vals;
    }

    private String[] splitString(String line) {
        return line.trim().split(" ");
    }

    /**
     *
     * @param logMessage
     * Method that writes the result or error message to file "output.txt"
     */
    public static void LogResultsToFile(String logMessage) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/assignment3/output.txt", true));
        writer.flush();
        writer.write(logMessage);
        writer.close();
    }


}
