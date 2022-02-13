package Program;

import Program.Imagine.SchemeImagine;
import Program.PowerGridReader.lineReader;
import Program.TransformerReadr.transformerReader;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {

        System.out.println("Program calculation of short-circuit current for a two-winding transformer");

        Scanner scanner = new Scanner(System.in);

        System.out.println("To start please enter something in console");
        scanner.next();

        System.out.println("The program finds the short-circuit current  at points K1 and K2");
        System.out.println("In the future, these calculations will help to configure the protection devices");
        Thread s = new Thread(new SchemeImagine());
        s.start();

        String[][] transformerInfo = transformerReader.transformerReader();
        String[] lineInfo = lineReader.lineReader();





    }
}