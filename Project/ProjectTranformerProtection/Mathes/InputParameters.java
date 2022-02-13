package Program.Mathes;

import Program.MainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputParameters {

   public int parameters(String[][] transformerInfo) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int PowerGridLength;
       int systemVoltage;
       int transformerPower = Integer.parseInt(transformerInfo[3][1]) ;
       int transformerVoltageH = Integer.parseInt(transformerInfo[1][1].replaceAll("[a-z]",""));
       int transformerVoltageL = Integer.parseInt(transformerInfo[2][1].replaceAll("[a-z]",""));
       return transformerPower;
   }
}
