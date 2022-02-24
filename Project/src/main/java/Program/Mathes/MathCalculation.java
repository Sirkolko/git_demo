package Program.Mathes;

public class MathCalculation {
    private final double coefficient = 1.5;
    private double fullSystemResMax = 0;
    private double fullSystemResMin = 0;
    private double fullGridRes = 0;
    private double transformerResMin = 0;
    private double transformerResMax = 0;
    private double minResK1 = 0;
    private double maxResK1 = 0;

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
    public double shortCircleCurrentK1MaxCalc(SystemParameters obj) {
        double minResK1 = this.fullSystemResMin + this.fullGridRes;
        this.minResK1 = minResK1;
        System.out.println("minResK1 " + minResK1);
        return (obj.getSystemVoltage() / (Math.sqrt(3.0) * minResK1))*1000;
    }
    public double shortCircleCurrentK1MinCalc(SystemParameters obj) {
        double maxResK1 = this.fullSystemResMax + this.fullGridRes;
        this.maxResK1 = maxResK1;
        System.out.println("maxResK1 " + maxResK1);
        return (126 / (Math.sqrt(3.0) * maxResK1))*1000;
    }
    public double shortCircleCurrentK2MaxCalc(SystemParameters obj) {
        double minResK2 = this.minResK1 + this.transformerResMin;
        System.out.println("minResK2 " + minResK2);
        return (obj.getSystemVoltage() / (Math.sqrt(3.0) * minResK2))*1000;
    }
    public double shortCircleCurrentK2MinCalc(SystemParameters obj) {
        double maxResK2 = this.maxResK1 + this.transformerResMax;
        System.out.println("maxResK2 " + maxResK2);
        return (126 / (Math.sqrt(3.0) * maxResK2))*1000;
    }
}
