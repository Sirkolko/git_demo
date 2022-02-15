package Program;

import Program.Imagine.SchemeImagine;
import Program.Mathes.SystemParameters;
import Program.PowerGridReader.LineReader;
import Program.SystemVoltage.ReadVoltage;
import Program.TransformerReadr.TransformerReader;

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

        TransformerReader t1 = new TransformerReader();
        String[][] transformerInfo = t1.transformerReader();
        LineReader l1 = new LineReader();
        ReadVoltage s1 = new ReadVoltage();

        SystemParameters syst = new SystemParameters();
        syst = new SystemParameters.SystemBuilder()
                .addPowerGridResist(l1.lineReader())
                .addPowerGridLength(l1.powerGridLength())
                .addSystemVoltage(s1.SystemVoltage())
                .addShortCircCurrentHight(Double.parseDouble(transformerInfo[4][1].replaceAll("%", "")))
                .addShortCircCurrentLow(Double.parseDouble(transformerInfo[5][1].replaceAll("%", "")))
                .addTransformerPower(Integer.parseInt(transformerInfo[3][1].replaceAll("[a-zA-Z]", "")))
                .addTransformerVoltageH(Double.parseDouble(transformerInfo[1][1].replaceAll("[a-zA-Z]", "")))
                .addTransformerVoltageL(Double.parseDouble(transformerInfo[2][1].replaceAll("[a-zA-Z]", "")))
                .build();
        System.out.println("\n" + syst);
    }
}