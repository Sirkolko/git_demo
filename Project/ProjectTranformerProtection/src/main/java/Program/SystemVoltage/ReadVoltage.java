package Program.SystemVoltage;

/**
 * Class for main calculation ;
 * Has one method.
 * @version 1.0 25 Feb 2022
 * @author Sergiy Okhota
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**This method need to read length of power grid and return power grid length, after this value
 * will be needed in calculating.
 * @return this method return integer system voltage.
 * @throws NumberFormatException if entered value in console not number.
 */

public class ReadVoltage {
    public int SystemVoltage() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sysVoltage = 0;
        try {
            System.out.println("\nEnter system voltage");
            sysVoltage = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return sysVoltage;
    }
}
