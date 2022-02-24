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
            int count1 = 0;
            int ver = 0;
            double resistant = 0;
            try {
                int chooseGridClass = sc.nextInt();
                String[][] arrOfGrids = new String[0][0];
                String[][] arrOfGrids1 = new String[0][0];

                //read information about power grids and write info into array and print info to select power grid section
                if (chooseGridClass == 35 || chooseGridClass == 110 || chooseGridClass == 150) {

                    //count file rows
                    br = new BufferedReader(new FileReader("src/main/java/Program/PowerGridInfo/Grids35-150kV.txt"));
                    while (br.readLine() != null) {
                        count++;
                    }

                    count1 = count;

                    sc = new Scanner(new FileReader("src/main/java/Program/PowerGridInfo/Grids35-150kV.txt"));
                    arrOfGrids = new String[count][4];
                    for (int i = 0; i < count; i++) {
                        for (int j = 0; j < 4; j++) {
                            arrOfGrids[i][j] = sc.next();
                        }
                    }
                    arrOfGrids1 = new String[count][2];

                } else if (chooseGridClass == 220 || chooseGridClass == 330 || chooseGridClass == 500) {

                    //count file rows
                    br = new BufferedReader(new FileReader("src/main/java/Program/PowerGridInfo/Grids220-500kV.txt"));
                    while (br.readLine() != null) {
                        count++;
                    }
                    count1 = count;

                    sc = new Scanner(new FileReader("src/main/java/Program/PowerGridInfo/Grids220-500kV.txt"));
                    arrOfGrids = new String[count][4];
                    for (int i = 0; i < count; i++) {
                        for (int j = 0; j < 4; j++) {
                            arrOfGrids[i][j] = sc.next();
                        }
                    }
                    arrOfGrids1 = new String[count][2];
                } else {
                    System.out.println("Cant find power grid this class");
                    System.exit(3);
                }

                switch (chooseGridClass) {
                    case 35, 220:
                        ver = 1;
                        for (int i = 0; i <count;i++){
                            if (Double.parseDouble(arrOfGrids[i][ver])==0){
                                count1 -=1;
                            }
                        }
                        for (int i = 0; i < count; i++) {
                            for (int j = 0, l = 0; l < 2; j++, l++) {
                                arrOfGrids1[i][l] = arrOfGrids[i][j];
                            }
                        }
                        break;
                    case 110, 330:
                        ver = 2;
                        for (int i = 0; i <count;i++){
                            if (Double.parseDouble(arrOfGrids[i][ver])==0){
                                count1 -=1;
                            }
                        }
                        for (int i = 0; i < count; i++){
                            for (int j = 0, l = 0; l < 2; j += 2, l++) {
                                arrOfGrids1[i][l] = arrOfGrids[i][j];
                            }
                        }
                        break;
                    case 150, 500:
                        ver = 3;
                        for (int i = 0; i <count;i++){
                            if (Double.parseDouble(arrOfGrids[i][ver])==0){
                                count1 -=1;
                            }
                        }
                        for (int i = 0; i < count; i++) {
                            for (int j = 0, l = 0; l < 2; j += 3, l++) {
                                arrOfGrids1[i][l] = arrOfGrids[i][j];
                            }
                        }
                        break;
                }


                String[] section = new String[count1];
                for (int i = 0 , j = 0; i < count1  ; i++ , j++) {
                    if (Double.parseDouble(arrOfGrids[j][ver]) == 0) {
                        i = i - 1 ;
                    }else {
                        section[i] = arrOfGrids[j][0];
                    }
                }

                //choose power grids

                System.out.println("\nEnter power grid section " + Arrays.toString(section));
                Scanner sc1 = new Scanner(System.in);
                String sectionOfGrid = sc1.nextLine();
                for (int i = 0; i < count1; i++) {
                    if (Double.parseDouble(arrOfGrids1[i][1])==0){
                        count1++;
                    }else if (arrOfGrids1[i][0].contains(sectionOfGrid)) {
                        resistant = Double.parseDouble(arrOfGrids1[i][1]);
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

