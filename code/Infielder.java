/**
* Infielder object subclass to superclasss BallPlayer.
*
* Project 9
* @author Noah Flood - Comp 1210 - Section 001
* @version 4/10/22
*
*/
public class Infielder extends BallPlayer {
   
   // fields
   private double infielderFieldingAverage;

   // constructor
   /**
    * Constructor for Infielder objects.
    * @param inNumber number of the player.
    * @param inName name of the player.
    * @param inPosition player position.
    * @param inBaseSalary player base salary.
    * @param inBonus bonus to be considered when calculating salary.
    * @param inBattingAvg batting everage.
    * @param inIFAverage infielder fielding average.
    */
   public Infielder(String inNumber, String inName, String inPosition, 
      double inBaseSalary, double inBonus, double inBattingAvg, 
      double inIFAverage) {
      super(inNumber, inName, inPosition, inBaseSalary,
         inBonus, inBattingAvg);

      infielderFieldingAverage = inIFAverage;
   }

   //methods
   /**
    * Get the I.F. fielding average for this player.
    * @return the I.F. fielding average as a double
    */
   public double getInfielderFieldingAvg() {
      return infielderFieldingAverage;
       
   }

   /**
    * Set a new I.F. fielding average for this player.
    * @param newIn double new I.F. fielding average for this player
    */
   public void setInfielderFieldingAvg(double newIn) {
      infielderFieldingAverage = newIn;
   }

   /**
    * Overriden totalEarnings() method.
    * Calculation specific to that of Infielder players.
    * @return a double rep. the total earnings.
    */
   public double totalEarnings() {
      double earnings = 0;
      earnings = (baseSalary * bonusAdjustmentFactor * battingAverage
         * infielderFieldingAverage) + baseSalary;

      return earnings;
   }

   
}
