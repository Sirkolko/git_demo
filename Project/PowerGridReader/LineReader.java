package Program.PowerGridReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class LineReader {
    public double lineReader() {
        System.out.println("\nEnter power grid class (35,110,150,220,330,500)");
        Scanner sc = new Scanner(System.in);
        BufferedReader br;
        int count = 0;
        double resistant = 0;
        String[][] arrOfGrids = new String[0][0];
        String[][] arrOfGrids1 = new String[0][0];
        try {
            int chooseGridClass = sc.nextInt();


            //read information about power grids and write info into array and print info to select power grid section
            if (chooseGridClass == 35 || chooseGridClass == 110 || chooseGridClass == 150) {

                //count file rows
                br = new BufferedReader(new FileReader("src/Program/PowerGridInfo/Grids220-500kV.txt"));
                while (br.readLine() != null) {
                    count++;
                }

                sc = new Scanner(new FileReader("src/Program/PowerGridInfo/Grids35-150kV.txt"));
                arrOfGrids = new String[count][4];
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < 4; j++) {
                        arrOfGrids[i][j] = sc.next();
                    }
                }

                arrOfGrids1 = new String[count][arrOfGrids.length];

            } else if (chooseGridClass == 220 || chooseGridClass == 330 || chooseGridClass == 500) {

                //count file rows
                br = new BufferedReader(new FileReader("src/Program/PowerGridInfo/Grids220-500kV.txt"));
                while (br.readLine() != null) {
                    count++;
                }

                sc = new Scanner(new FileReader("src/Program/PowerGridInfo/Grids220-500kV.txt"));
                arrOfGrids = new String[count][4];
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < 4; j++) {
                        arrOfGrids[i][j] = sc.next();
                    }
                }

            } else {
                System.out.println("Cant find power grid this class");
                System.exit(3);
            }
            arrOfGrids1 = new String[count][arrOfGrids.length];
            switch (chooseGridClass) {
                case 35, 220:
                    for (int i = 0; i < count; i++) {
                        for (int j = 0, l = 0; j < 2; j++, l++) {
                            arrOfGrids1[i][l] = arrOfGrids[i][j];
                        }
                    }
                    break;
                case 110, 330:
                    for (int i = 0; i < count; i++) {
                        for (int j = 0, l = 0; j < 2; j += 2, l++) {
                            arrOfGrids1[i][l] = arrOfGrids[i][j];
                        }
                    }
                    break;
                case 150, 500:
                    for (int i = 0; i < count; i++) {
                        for (int j = 0, l = 0; j < 2; j += 3, l++) {
                            arrOfGrids1[i][l] = arrOfGrids[i][j];
                        }
                    }
                    break;
            }

            String[] section = new String[count];
            for (int i = 0; i < count; i++) {
                section[i] = arrOfGrids[i][0];
            }

            //choose power grids

            System.out.println("\nEnter power grid section " + Arrays.toString(section));
            Scanner sc1 = new Scanner(System.in);
            String sectionOfGrid = sc1.nextLine();
            for (int i = 0; i < count; i++) {
                if (arrOfGrids1[i][0].contains(sectionOfGrid)) {
                    resistant = Double.parseDouble(arrOfGrids[i][1]);
                    break;
                }
            }
            System.out.println("\nResistant of selected power grid is " + resistant + " Ohm ");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return resistant;
    }

    public double powerGridLength() {
        double powerGridLength = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter power grid length in km");
            powerGridLength = Double.parseDouble(br.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return powerGridLength;
    }
}

