package Program.TransformerReadr;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class that need fo main calculations;
 *
 * @author Shcherbei Anton
 * @version 1.0 22 Feb 2022
 */

public class TransformerReader {

    /**
     * This method ask in user about transformer class then read file with transformer which have chosen voltage class.
     * After this method form array information with parameters of transformer and also print information about chosen
     * transformer.
     *
     * @return this method return array data.
     * @throws NumberFormatException if entered voltage class not a number.
     * @throws java.io.FileNotFoundException if method can`t find file in source root.
     */

    public String[][] transformerReader() {
        System.out.println("\nEnter transformer class (35,110,220) to choose transformer ");
        String[][] information = new String[6][2];
        int transformerClass = 0;
        try {

            //Here method read voltage class and read needed file.

            Scanner sc = new Scanner(System.in);
            transformerClass = sc.nextInt();
            switch (transformerClass) {
                case 35:
                    sc = new Scanner(new File("src/main/java/Program/TransformerInfo/Transformer35kV.txt"));
                    break;
                case 110:
                    sc = new Scanner(new File("src/main//Program/TransformerInfo/Transformer110kV.txt"));
                    break;
                case 220:
                    sc = new Scanner(new File("src/main/java/Program/TransformerInfo/Transformer220kV.txt"));
                    break;
                default:
                    System.out.println("Cant find transformer this class");
                    System.exit(3);
            }

            //Here method form information which will be printed in console and also this information will be needed
            // in future calculating.

            String text = sc.useDelimiter("\\A").next();
            sc.close();
            String[] arr = text.split("\\s");
            information[0][0] = "Transformer";
            information[1][0] = "High Voltage";
            information[2][0] = "Lower Voltage";
            information[3][0] = "Power";
            information[4][0] = "U.s.c.max";
            information[5][0] = "U.s.c.min";
            information[0][1] = arr[0];
            information[1][1] = arr[1];
            information[2][1] = arr[2];
            information[3][1] = arr[3];
            information[4][1] = arr[4];
            information[5][1] = arr[5];
            for (int i = 0; i < information.length; i++) {
                System.out.println(Arrays.toString(information[i]));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return information;
    }
}
