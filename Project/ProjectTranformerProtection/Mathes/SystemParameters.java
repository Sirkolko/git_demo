package Program.Mathes;

public class SystemParameters {
   private double  powerGridLength;
   private double  powerGridResist;
   private double  systemVoltage;
   private int transformerPower;
   private double transformerVoltageH;
   private double transformerVoltageL;
   private double shortCircCurrentLow;
   private double shortCircCurrentHight;


   public SystemParameters(){}

   public String toString() {
      return " powerGridLength: " + powerGridLength + "\n powerGridResist : " + powerGridResist + "\n systemVoltage : " + systemVoltage + "\n transformerPower : " + transformerPower + "\n transformerVoltageH: " + transformerVoltageH + "\n transformerVoltageL "  +  transformerVoltageL+ "\n shortCircCurrentLow "  +  shortCircCurrentLow+"\n shortCircCurrentHight "  +  shortCircCurrentHight;
   }

   public static SystemBuilder getSystemParameters(){
      return new SystemBuilder();}

   public static class SystemBuilder{
      private SystemParameters newSystemParameters;

      public SystemBuilder(){
         newSystemParameters = new SystemParameters();
      }

      public SystemBuilder addPowerGridLength(double powerGridLength){
         newSystemParameters.powerGridLength = powerGridLength;
         return this;
      }

      public SystemBuilder addPowerGridResist(double powerGridResist){
         newSystemParameters.powerGridResist = powerGridResist;
         return this;
      }

      public SystemBuilder addSystemVoltage (double systemVoltage){
         newSystemParameters.systemVoltage = systemVoltage;
         return  this;
      }
      public SystemBuilder addTransformerPower (int transformerPower){
         newSystemParameters.transformerPower = transformerPower;
         return this;
      }
      public SystemBuilder addTransformerVoltageH (double transformerVoltageH){
         newSystemParameters.transformerVoltageH = transformerVoltageH;
         return this;
      }
      public SystemBuilder addTransformerVoltageL (double transformerVoltageL){
         newSystemParameters.transformerVoltageL = transformerVoltageL;
         return this;
      }
      public SystemBuilder addShortCircCurrentLow (double shortCircCurrentLow){
         newSystemParameters.shortCircCurrentLow = shortCircCurrentLow;
         return this;
      }
      public SystemBuilder addShortCircCurrentHight (double shortCircCurrentHight){
         newSystemParameters.shortCircCurrentHight = shortCircCurrentHight;
         return this;
      }
      public SystemParameters build(){return newSystemParameters;}
   }
}
