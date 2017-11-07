package assignment3;


import java.io.IOException;

class MagicSquareReaderWriterTest {


    void setUp() {
    }


    void tearDown() {
    }


    void readMultiDimArray() throws Exception {


        MagicSquareReaderWriter instance = new MagicSquareReaderWriter();

        int[][] expected = new int[][] {{1,2,3},{5,6,7},{9,10,1}};

        int[][] magicSquare = instance.readMultiDimArray("input.txt");
        for (int i = 0; i < magicSquare.length; i++) {
            for (int ii = 0; ii < magicSquare[i].length; ii++) {
                if((magicSquare[i][ii]) != expected[i][ii]) {
                    throw new Exception();
                }
            }
        }

    }

}