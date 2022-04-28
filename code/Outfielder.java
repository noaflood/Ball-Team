/**
* Outfieler object subclass to superclasss BallPlayer.
* Overrides a couple methods, inheritss many.
*
* Project 9
* @author Noah Flood - Comp 1210 - Section 001
* @version 4/10/22
*
*/
public class Outfielder extends BallPlayer {
   
   // fields
   private double outfielderFieldingAverage;

   //constructor 
   /**
    * Constructor for Outfielder objects.
    * @param inNumber number of the player.
    * @param inName name of the player.
    * @param inPosition player position.
    * @param inBaseSalary player base salary.
    * @param inBonus bonus to be considered when calculating salary.
    * @param inBattingAvg batting everage.
    * @param inOFAverage outfielder fielding average.
    */
   public Outfielder(String inNumber, String inName, String inPosition, 
      double inBaseSalary, double inBonus, double inBattingAvg,
      double inOFAverage) {
      super(inNumber, inName, inPosition, inBaseSalary, inBonus, inBattingAvg);
      
      outfielderFieldingAverage = inOFAverage;
   }

   /**
    * Returns the number for the outfielder fielding average.
    * @return double variable for outfielder fielding average.
    */
   public double getOutfielderFieldingAvg() {
      return outfielderFieldingAverage;
   }

   /**
    * Set a new outfielderFieldingAverage.
    * @param inOFAverage ne outfielder fielding average amount
    */
   public void setOutfielderFieldingAvg(double inOFAverage) {
      outfielderFieldingAverage = inOFAverage;

   }

   /**
    * This get's called by the inhereited toString method.
    * We calcualte the earnigs, which is a function specific to 
    * players of Outfielder type.
    * @return double rep. the total reanings.
    */
   public double totalEarnings() {
      double earnings = 0;
      earnings = (baseSalary * bonusAdjustmentFactor * battingAverage 
         * outfielderFieldingAverage) + baseSalary;
         
      return earnings;
   }


}
