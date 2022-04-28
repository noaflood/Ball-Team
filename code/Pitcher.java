import java.text.DecimalFormat;

/**
* Pitcher object subclass to superclasss BallPlayer.
*
* Project 9
* @author Noah Flood - Comp 1210 - Section 001
* @version 4/10/22
*
*/
public class Pitcher extends BallPlayer {
   
   // fields
   protected int wins;
   protected int losses;
   protected double era;

   // constrcutor
   /**
    * Constructor for Pitcher objects.
    * @param inNumber number of the player.
    * @param inName name of the player.
    * @param inPosition player position.
    * @param inBaseSalary player base salary.
    * @param inBonus bonus to be considered when calculating salary
    * @param inBattingAvg batting everage.
    * @param inWins # of wins for the team.
    * @param inLosses # of losses for the team.
    * @param inEra earned run average for this player.
    */
   public Pitcher(String inNumber, String inName, String inPosition, 
      double inBaseSalary, double inBonus, double inBattingAvg, int inWins,
      int inLosses, double inEra) {
      super(inNumber, inName, inPosition, inBaseSalary, inBonus, inBattingAvg);

      wins = inWins;
      losses = inLosses;
      era = inEra;
   }

   /**
    * Get the # of wins for this player.
    * @return # of wins as an int.
    */
   public int getWins() {
      return wins;
   }

   /**
    * Set a new # of wins to the player.
    * @param inWins new # of wins.
    */
   public void setWins(int inWins) {
      wins = inWins;
   }

   /**
    * Get the # of losses for this player.
    * @return # of losses as an int.
    */
   public int getLosses() {
      return losses;
   }

   /**
    * Set the # of losses for this player.
    * @param inLosses new number of losses to set.
    */
   public void setLosses(int inLosses) {
      losses = inLosses;
   }  

   /**
    * Get this player's era.
    * @return an era, double
    */
   public double getEra() {
      return era;
   }

   /**
    * Set the ERA for this player.
    * @param inEra new era.
    */
   public void setEra(double inEra) {
      era = inEra;
   }

   /**
    * Calculate the total earningss of this player.
    * Calculation is specific to this type of BallPlayer.
    * @return a double of calculated total earnings.
    */
   public double totalEarnings() {
      double earnings = 0;
      earnings = ((baseSalary * bonusAdjustmentFactor * (1 / (1 + era)) 
         * (wins - losses)) / 25) + baseSalary;
      return earnings;
   }

   /**
    * Get a formatted string showing the stats for this player.
    * (Overriden from BallPlayer class.)
    * @return a formatted string of stats. 
    */
   public String stats() {
      String statsString = "";
      DecimalFormat fmt1 = new DecimalFormat(".00");

      statsString += wins + " wins, " + losses + " losses, ";
      statsString += fmt1.format(era) + " ERA";

      return statsString;
   }


}
      
