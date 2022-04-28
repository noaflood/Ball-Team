import java.text.DecimalFormat;

/**
 * Super class for all BallPlayer classes. 
 *
 * Project 9
 * @author Noah Flood - Comp 1210 - Section 001
 * @version 4/10/22
 *
 */
public abstract class BallPlayer implements Comparable<BallPlayer> {

   // fields
   protected String number;
   protected String name;
   protected String position;
   protected double baseSalary;
   protected double bonusAdjustmentFactor;
   protected double battingAverage;
   /** Represents the number of BallPlayer objects that have been instantiated
    *  so far. */
   protected static int ballPlayerObjectcount;

   // constructor
   /**
    * Constructor for all BallPlayer objects.
    * Subclasses call super(parameters).
    * @param inNumber number of the player
    * @param inName name of the player
    * @param inPosition player position
    * @param inBaseSalary player position,
    * @param inBonus bonus to be considered when calculating salary
    * @param inBattingAvg batting everage
    */
   public BallPlayer(String inNumber, String inName, String inPosition, 
      double inBaseSalary, double inBonus, double inBattingAvg) {
      number = inNumber;
      name = inName;
      position = inPosition;
      baseSalary = inBaseSalary;
      bonusAdjustmentFactor = inBonus;
      battingAverage = inBattingAvg;

      // increment the amount of objects instantiated so far
      ballPlayerObjectcount++;
   }

   // methods
   /**
    * Returns player numnber.
    * @return int rep. player number.
    */
   public String getNumber() {
      return number;
   }

   /**
    * Set player number.
    * @param inNumber new player number.
    */
   public void setNumber(String inNumber) {
      number = inNumber;
   }

   /**
    * Get the player name.
    * @return String rep. the player name.
    */
   public String getName() {
      return name;
   }

   /**
    * Set a new player name.
    * @param inName new player name.
    */
   public void setName(String inName) {
      name = inName;
   }

   /**
    * Get the player position.
    * @return the player position as a string.
    */
   public String getPosition() {
      return position;
   }

   /** 
    * Set a new player positinon.
    * @param inPosition the new position String
    */
   public void setPosition(String inPosition) {
      position = inPosition;
   }

   /**
    * Return the base salary of the player.
    * @return double base salary.
    */
   public double getBaseSalary() {
      return baseSalary;

   }

   /**
    * Set the player's base salary.
    * @param inSalary new salary rate.
    */
   public void setBaseSalary(double inSalary) {
      baseSalary = inSalary;
   }

   /**
    * Get the bonus adjusstment factor PIV.
    * @return the bonus adjustment factor as a double.
    */
   public double getBonusAdjustmentFactor() {
      return bonusAdjustmentFactor;
   }

   /**
    * Set a new bonus adjustment factor.
    * @param inBonus new bonus amount.
    */
   public void setBonusAdjustmentFactor(double inBonus) {
      bonusAdjustmentFactor = inBonus;
   }

   /**
    * Get the player batting average.
    * @return a double representing the batting average.
    */
   public double getBattingAvg() {
      return battingAverage;
   }

   /**
    * Set the player batting average.
    * @param inBattingAvg double representing the batting average.
    */
   public void setBattingAvg(double inBattingAvg) {
      battingAverage = inBattingAvg;
   }

   /**
    * Get the amount of BallPlayer Objects instantiated so far.
    * @return int count of above.
    */
   public static int getCount() {
      return ballPlayerObjectcount;
   }

   /**
    * Reset the count of objects instantiated so far.
    */
   public static void resetCount() {
      ballPlayerObjectcount = 0;
   }

   /**
    * returns a String representing the batting average 
    * using ".000" as the pattern for a DecmialFormat object.
    * @return a String of formatted stats about the player.
    */
   public String stats() {
      String statsString = "";
      DecimalFormat fmt1 = new DecimalFormat(".000");
      statsString += fmt1.format(battingAverage);

      return statsString;
   }

   /**
    * Let's us format info about all the objects.
    * Subclasses all inhereit this toString unless overriden.
    * Usually, subclasses call susper.toString(), then add 
    * extraneous information
    * @return a formatted String of information about the object.
    */
   public String toString() {
      String output = "";
      DecimalFormat fmt2 = new DecimalFormat("###,###.00");
      DecimalFormat fmt3 = new DecimalFormat("###,###.##");
      
      //concatenate info onto a string
      output += number + " " + name + " (" + position + ")" + " " + stats()
         + "\n";
      output += "Base Salary: $" + fmt2.format(baseSalary) 
         + " Bonus Adjustment Factor: " + fmt3.format(bonusAdjustmentFactor)
         + "\n";
      output += "Total Earnings: $" + fmt2.format(totalEarnings());
      output += " (" + this.getClass() + ")";

      return output;
   }

   /**
    * An abstract class that is subclass-spefic.
    * Used to represet the function of getting earnings for
    * a player.
    * @return a double representing the earnings of a player.
    */
   public abstract double totalEarnings();

   /**
    * Compare ball players based on their number.
    * @param param the player we are comparing to this one.
    * @return an int indidicating the compared numbers result.
    */
   public int compareTo(BallPlayer param) {

      if (this.number == param.getNumber()) {
         return 0;
      }
      else if (Integer.parseInt(this.number) 
         < Integer.parseInt(param.getNumber()))
      {
         return -1; //in this case, the param number is greater than this one's
      }
      else
      {
         return 1; //in this case, the param number is less than this one's
      }

   }

}