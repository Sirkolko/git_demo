package Program.Mathes;

/**
 * Class for main calculation short circe current  for four points;
 * Has five methods.
 * @version 1.0 25 Feb 2022
 * @author Sergiy Okhota
 */

public class MathCalculation {
    private final double coefficient = 1.5;
    private double fullSystemResMax = 0;
    private double fullSystemResMin = 0;
    private double fullGridRes = 0;
    private double transformerResMin = 0;
    private double transformerResMax = 0;
    private double minResK1 = 0;
    private double maxResK1 = 0;


    /**
     * This method get object of System and calculate resistance basic on parameters.
     * Method fills resistance parameters fields for next methods.
     * <p>
     *     Fills five fields of parameters.
     *     This fields are used for shortCircleCurrentK methods.
     * </p>
     * @param obj get object of System with filled parameters fields.
     * @return this method doesn't return anything.
     * @exception NullPointerException when obj of System is null.
     * @see NullPointerException
     */
    public void calculateResistance(SystemParameters obj) {
        double fullGridRes = obj.getPowerGridLength() * obj.getPowerGridResist();
        System.out.println("fullGridRes " + fullGridRes);
        this.fullGridRes = fullGridRes;

        double fullSystemResMax = (obj.getSystemVoltage() * obj.getSystemVoltage()) / 2900;
        System.out.println("fullSystemResMax " + fullSystemResMax);
        this.fullSystemResMax = fullSystemResMax;

        double fullSystemResMin = coefficient * this.fullSystemResMax;
        System.out.println("fullSystemResMin " + fullSystemResMin);
        this.fullSystemResMin = fullSystemResMin;


        double transformerResMin = obj.getShortCircCurrentHight() * (96.6 * 96.6) / (obj.getTransformerPower() * 100.0);
        System.out.println("transformerResMin " + transformerResMin);
        this.transformerResMin = transformerResMin;

        double transformerResMax = obj.getShortCircCurrentLow() * (126 * 126) / (obj.getTransformerPower() * 100.0);
        System.out.println("transformerResMax " + transformerResMax);
        this.transformerResMax = transformerResMax;
    }
    /**
     * This method calculates value of current basic on filled fields.
     * Returns double maximum value of short-circle current in K1 point.
     * @param obj get object of System with filled parameters fields.
     * @return double value of current in K1 point.
     * @exception NullPointerException when obj of System is null.
     * @see NullPointerException
     */
    public double shortCircleCurrentK1MaxCalc(SystemParameters obj) {
        double minResK1 = this.fullSystemResMin + this.fullGridRes;
        this.minResK1 = minResK1;
        System.out.println("minResK1 " + minResK1);
        return (obj.getSystemVoltage() / (Math.sqrt(3.0) * minResK1))*1000;
    }
    /**
     * This method calculates value of current basic on filled fields.
     * Returns double minimum value of short-circle current in K1 point.
     * @param obj get object of System with filled parameters fields.
     * @return double value of current in K1 point.
     * @exception NullPointerException when obj of System is null.
     * @see NullPointerException
     */
    public double shortCircleCurrentK1MinCalc(SystemParameters obj) {
        double maxResK1 = this.fullSystemResMax + this.fullGridRes;
        this.maxResK1 = maxResK1;
        System.out.println("maxResK1 " + maxResK1);
        return (126 / (Math.sqrt(3.0) * maxResK1))*1000;
    }
    /**
     * This method calculates value of current basic on filled fields.
     * Returns double maximum value of short-circle current in K2 point.
     * @param obj get object of System with filled parameters fields.
     * @return double value of current in K2 point.
     * @exception NullPointerException when obj of System is null.
     * @see NullPointerException
     */
    public double shortCircleCurrentK2MaxCalc(SystemParameters obj) {
        double minResK2 = this.minResK1 + this.transformerResMin;
        System.out.println("minResK2 " + minResK2);
        return (obj.getSystemVoltage() / (Math.sqrt(3.0) * minResK2))*1000;
    }
    /**
     * This method calculates value of current basic on filled fields.
     * Returns double minimum value of short-circle current in K2 point.
     * @param obj get object of System with filled parameters fields.
     * @return double value of current in K2 point.
     * @exception NullPointerException when obj of System is null.
     * @see NullPointerException
     */
    public double shortCircleCurrentK2MinCalc(SystemParameters obj) {
        double maxResK2 = this.maxResK1 + this.transformerResMax;
        System.out.println("maxResK2 " + maxResK2);
        return (126 / (Math.sqrt(3.0) * maxResK2))*1000;
    }
}
