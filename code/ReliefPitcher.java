import java.text.DecimalFormat;

/**
* ReliefPitcher class is
* a subclass of Pitcher which is
* a subclass of BallPlayer.
*
* Project 9
* @author Noah Flood - Comp 1210 - Section 001
* @version 4/10/22
*
*/
public class ReliefPitcher extends Pitcher {
   
   // fields
   private int saves;

   /**
    * 
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
    * @param inSaves times this relief pitcher has saved the pitcher.
    */
   // constructor
   public ReliefPitcher(String inNumber, String inName, String inPosition, 
      double inBaseSalary, double inBonus, double inBattingAvg, int inWins,
      int inLosses, double inEra, int inSaves) {
      
      super(inNumber, inName, inPosition, inBaseSalary, inBonus, inBattingAvg,
         inWins, inLosses, inEra);

      saves = inSaves;

   }

   /**
    * Get the number of saves this R.P. has.
    * @return # of saves as an int.
    */
   public int getSaves() {
      return saves;
   }

   /**
    * Set the number of saves for this R.F.
    * @param inSaves new # of saves.
    */
   public void setSaves(int inSaves) {
      saves = inSaves;
   }

   /**
    * Overriden totalEarnings() function from the Pitcher class.
    * @return the total earnings of this player, a double.
    */
   public double totalEarnings() {
      double earnings = 0;
      earnings = ((baseSalary 
         * bonusAdjustmentFactor 
         * (1 / (1 + era)) 
         * (wins - losses + saves)) 
         / 30) 
         + baseSalary;
      return earnings;
   }

   /**
    * Get a formatted string showing the stats for this player.
    * (Overriden from Pither class.)
    * @return a formatted string of stats. 
    */
   public String stats() {
      String statsString = "";
      DecimalFormat fmt1 = new DecimalFormat(".00");

      statsString += wins + " wins, " + losses + " losses, ";
      statsString += saves + " saves, ";
      statsString += fmt1.format(era) + " ERA";

      return statsString;
   }
   
   
}
