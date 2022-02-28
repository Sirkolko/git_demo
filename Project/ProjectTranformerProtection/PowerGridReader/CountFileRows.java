package Program.PowerGridReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class need for method that read file into array ;
 * @version 1.0 26 Feb 2022
 * @author Shcherbei Anton
 */

public class CountFileRows {

    /**
     * This method need to count rows in file " Grids35-150kV.txt ", in future this int will be needed to create array of grids;
     * @return this method return integer rows.
     * @throws java.io.FileNotFoundException if Buffered reader cat`n find file
     */

    public int countFile1Rows() {
        int rows = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/Program/PowerGridInfo/Grids35-150kV.txt"));
            while (br.readLine() != null) {
                rows++;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return rows;
    }

    /**
     * This method need to count rows in file " Grids35-150kV.txt ", in future this int will be needed to create array of grids;
     * @return this method return integer rows.
     * @throws java.io.FileNotFoundException if Buffered reader cat`n find file
     */

    public int countFile2Rows() {
        int rows = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/Program/PowerGridInfo/Grids220-500kV.txt"));
            while (br.readLine() != null) {
                rows++;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return rows;
    }
}
