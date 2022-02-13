package Program.PowerGridReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class lineReader {
    public static String[] lineReader() throws IOException {
        System.out.println("\nEnter power grid class (35,110,150,220,330,500)");
        Scanner sc = new Scanner(System.in);
        BufferedReader br ;
        int chooseGridClass = sc.nextInt();
        int count = 0;
        String[][] arrOfGrids = new String[0][0];

        //read information about power grids and write info into array and print info to select power grid section
        if(chooseGridClass == 35 || chooseGridClass == 110 ||chooseGridClass == 150) {

            //count file rows
            br = new BufferedReader(new FileReader("src/Program/PowerGridInfo/Grids35-150kV.txt"));
            while(br.readLine()!=null) {
                count++;
            }

            sc  = new Scanner(new FileReader("src/Program/PowerGridInfo/Grids35-150kV.txt"));

            if(chooseGridClass == 35) {
                arrOfGrids = new String[count][2];
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < 2; j++) {
                        arrOfGrids[i][j] = sc.next();
                    }
                }
            }else if (chooseGridClass == 110){
                arrOfGrids = new String[count][2];
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < 2; j++) {
                        arrOfGrids[i][j] = sc.next();
                    }
                }
            }

        }else if (chooseGridClass == 220 || chooseGridClass == 330 ||chooseGridClass == 500){

            //count file rows
            br = new BufferedReader(new FileReader("src/Program/PowerGridInfo/Grids220-500kV.txt"));
            while(br.readLine()!=null) {
                count++;
            }

            sc  = new Scanner(new FileReader("src/Program/PowerGridInfo/Grids220-500kV.txt"));
            arrOfGrids = new String[count][4];
            for (int i = 0 ; i < count ; i++){
                for (int j = 0 ; j < 4 ; j++) {
                    arrOfGrids[i][j] = sc.next();
                }
            }
        }else{
            System.out.println("Cant find power grid this class");
            System.exit(3);
        }

        String[] section = new String[count];
        for (int i = 0 ; i < count ; i ++){
         section[i] = arrOfGrids[i][0];
        }

        //choose power grids
        System.out.println("\nEnter power grid section " + Arrays.toString(section));




       String [] arr = new String[0];
        System.out.println(Arrays.toString(arr));
     return arr;
    }
}

