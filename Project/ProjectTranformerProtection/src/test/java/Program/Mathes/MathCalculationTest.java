package Program.Mathes;
/**
 * Test Class for main calculation short circe current  for four points;
 * @version 1.0 25 Feb 2022
 * @author Sergiy Okhota
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathCalculationTest {

    SystemParameters system = new SystemParameters.SystemBuilder()
            .addPowerGridResist(0.405)
            .addPowerGridLength(45)
            .addSystemVoltage(115)
            .addShortCircCurrentHight(9.8)
            .addShortCircCurrentLow(11.71)
            .addTransformerPower(16)
            .addTransformerVoltageH(115)
            .addTransformerVoltageL(6.6)
            .build();

    MathCalculation mathCalculation = new MathCalculation();

    @Test
    public void calculateResistance() {

    }

    @Test
    public void shortCircleCurrentK1MaxCalc() {
        mathCalculation.calculateResistance(system);
        assertEquals(2648.87,mathCalculation.shortCircleCurrentK1MaxCalc(system),0.1);
    }

    @Test
    public void shortCircleCurrentK1MinCalc() {
        mathCalculation.calculateResistance(system);
        assertEquals(3192.67,mathCalculation.shortCircleCurrentK1MinCalc(system),0.1);
    }

    @Test
    public void shortCircleCurrentK2MaxCalc() {
        mathCalculation.calculateResistance(system);
        assertEquals(807.51,mathCalculation.shortCircleCurrentK2MaxCalc(system),0.1);
    }

    @Test
    public void shortCircleCurrentK2MinCalc() {
        mathCalculation.calculateResistance(system);
        assertEquals(523.43,mathCalculation.shortCircleCurrentK2MinCalc(system),0.1);
    }
}