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
        this.fullGridRes = fullGridRes;

        double fullSystemResMax = (obj.getSystemVoltage() * obj.getSystemVoltage()) / 3200;
        System.out.println(fullSystemResMax);
        this.fullSystemResMax = fullSystemResMax;


        double fullSystemResMin = coefficient * this.fullSystemResMax;
        System.out.println(fullSystemResMin);


        double transformerResMin = (obj.getShortCircCurrentLow() * obj.getTransformerVoltageL()*obj.getTransformerVoltageL()) / (100 * (obj.getTransformerPower() / 1000));
        System.out.println(transformerResMin);
        this.transformerResMin = transformerResMin;

        double transformerResMax = (obj.getShortCircCurrentHight() * obj.getTransformerVoltageH()*obj.getTransformerVoltageH()) / (100 * (obj.getTransformerPower() / 1000));
        System.out.println(transformerResMax);
        this.transformerResMax = transformerResMax;
    }



    public double shortCircleCurrentK1MaxCalc(SystemParameters obj) {
        double minResK1 = this.fullSystemResMin + this.fullGridRes;
        this.minResK1 = minResK1;
        return obj.getSystemVoltage() / Math.sqrt(3) * minResK1;
    }

    public double shortCircleCurrentK1MinCalc(SystemParameters obj) {
        double maxResK1 = this.fullSystemResMax + this.fullGridRes;
        this.maxResK1 = maxResK1;
        return obj.getSystemVoltage() / Math.sqrt(3) * maxResK1;
    }

    public double shortCircleCurrentK2MaxCalc(SystemParameters obj) {
        double minResK2 = minResK1 + this.transformerResMin;
        return obj.getSystemVoltage() / Math.sqrt(3) * minResK2;
    }

    public double shortCircleCurrentK2MinCalc(SystemParameters obj) {
        double maxResK2 = maxResK1 + this.transformerResMax;
        return obj.getSystemVoltage() / Math.sqrt(3) * maxResK2;
    }
}
