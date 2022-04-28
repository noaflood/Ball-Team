import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Organize info about BallPlayers using a "roster" array. 
 *
 * Project 10
 * @author Noah Flood - Comp 1210 - Section 001
 * @version 4/18/22
 *
 */
public class BallTeam {
   
   // fields
   private String teamName;
   private BallPlayer[] roster;
   private int playerCount = 0;
   private String[] excludedRecords;
   private int excludedCount = 0;
   
   /** Constant for the max # of players in a roster. */
   public static final int MAX_PLAYERS = 24;
   
   /** Constant for the max # of players that can be exlcuded from a dataset. */
   public static final int MAX_EXCLUDED = 30;

   /**
    * Constructor for BallTeam objects.
    */
   public BallTeam() {
      teamName = "empty";
      roster = new BallPlayer[MAX_PLAYERS];
      playerCount = 0;
      excludedRecords = new String[30];
      excludedCount = 0;
   }

   /**
    * Get the team name.
    * @return string of the team name.
    */
   public String getTeamName() {
      return teamName;
   }

   /**
    * Set the team name.
    * @param inName new name.
    */
   public void setTeamName(String inName) {
      teamName = inName;
   }

   /**
    * Get the roster array.
    * @return the array of the roster.
    */
   public BallPlayer[] getRoster() {
      return roster;
   }

   /**
    * New roster to set.
    * @param inRoster new roster
    */
   public void setRoster(BallPlayer[] inRoster) {
      roster = inRoster;      
   }

   /**
    * Get the amount of players in the rostser.
    * @return in rep. the # of players in the roster.
    */
   public int getPlayerCount() {
      return playerCount;
   }
   
   /**
    * Set the # of players in the roster.
    * @param inCount new # of players
    */
   public void setPlayerCount(int inCount) {
      playerCount = inCount;
   }

   /**
    * Get the excluded players as a String array.
    * @return the string array of excluded players.
    */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }

   /**
    * Set the excluded records array.
    * @param inArray new array for excluded records.
    */
   public void setExcludedRecords(String[] inArray) {
      excludedRecords = inArray;
   }

   /**
    * Get the number of excluded records.
    * @return int represeting the # of excluded records.
    */
   public int getExcludedCount() {
      return excludedCount;
   }

   /**
    * Set teh # of excluded records.
    * @param inCount # of excluded records, an int.
    */
   public void setExcludedCount(int inCount) {
      excludedCount = inCount;
   }
   // big method --------------------------------------------------------------
   /**
    * Read in the file to get the players for the roster.
    * In addition to the specifications in Part 2, the existing 
    * readBallPlayerFile method must be modified to recognize invalid input
    * data and catch:
    * InvalidCategoryException -- happens when the cateogry of player invalid.
    * NumberFormatException -- when an invalid type is tried to be parsed. 
    * NoSuchElementException. 
    *
    * @param fileName name of the file of players
    * @throws FileNotFoundException handles an exception allowing
    * us to read files in.
    */
   public void readBallPlayerFile(String fileName)
      throws FileNotFoundException {

      // scanner for the file
      Scanner inFile = new Scanner(new File(fileName));

      // vars to instantiate a new BallPlayer object
      String playerName;
      String number;
      String position;
      double baseSalary;
      double bonusAdjustmentFactor;
      double battingAverage;
      // for outfielders
      double outfielderFieldingAverage;
      // for infielders
      double infielderFieldingAverage;
      // for pithers
      int wins;
      int losses;
      double era;
      // for relief pitchers
      int saves;

      // just sets the name of the team object equal to
      // the first line of the file
      setTeamName(inFile.nextLine());

      // THIS ALLOWS FOR CATCH STATEMENTS TO SEE SCOPE OF TEH DATA LINE
      String playerLine = null;

      // loop through the file so long as it has another line.
      // technically we don't need this since we can catch 
      // a NoSuchElement error.
      while (inFile.hasNextLine()) 
      {
         try {
            // store the next player data line
            playerLine = inFile.nextLine();

            // create a scanner for the next line
            Scanner inLine = new Scanner(playerLine).useDelimiter(",");

            // get the first item in the line which indicates the type of player
            char playerType = inLine.next().charAt(0);

            // reference a generic BallPlayer for later use
            BallPlayer newPlayer;

            // use a switch statement to determine which type
            switch (playerType)
            {
               case 'O':
                  // make the necessary variable assignments
                  number = inLine.next();
                  playerName = inLine.next();
                  position = inLine.next();
                  baseSalary = Double.parseDouble(inLine.next());
                  bonusAdjustmentFactor = Double.parseDouble(inLine.next());
                  battingAverage = Double.parseDouble(inLine.next());
                  outfielderFieldingAverage 
                     = Double.parseDouble(inLine.next());

                  // assign the new player object
                  newPlayer = new Outfielder(number, playerName,
                     position, baseSalary, bonusAdjustmentFactor, 
                     battingAverage, outfielderFieldingAverage);

                  break;
               case 'I':
                  // make the necessary assignments
                  number = inLine.next();
                  playerName = inLine.next();
                  position = inLine.next();
                  baseSalary = Double.parseDouble(inLine.next());
                  bonusAdjustmentFactor = Double.parseDouble(inLine.next());
                  battingAverage = Double.parseDouble(inLine.next());
                  infielderFieldingAverage = Double.parseDouble(inLine.next());

                  // assign the new player object
                  newPlayer = new Infielder(number, playerName,
                     position, baseSalary, bonusAdjustmentFactor, 
                     battingAverage, infielderFieldingAverage);

                  break;
               case 'P':
                  // make the necessary assignments
                  number = inLine.next();
                  playerName = inLine.next();
                  position = inLine.next();
                  baseSalary = Double.parseDouble(inLine.next());
                  bonusAdjustmentFactor = Double.parseDouble(inLine.next());
                  battingAverage = Double.parseDouble(inLine.next());
                  wins = Integer.parseInt(inLine.next());
                  losses = Integer.parseInt(inLine.next());
                  era = Double.parseDouble(inLine.next());

                  // assign the new player object
                  newPlayer = new Pitcher(number, playerName,
                     position, baseSalary, bonusAdjustmentFactor, 
                     battingAverage, wins, losses, era);

                  break;
               case 'R':
                  // make the necessary assignments
                  number = inLine.next();
                  playerName = inLine.next();
                  position = inLine.next();
                  baseSalary = Double.parseDouble(inLine.next());
                  bonusAdjustmentFactor = Double.parseDouble(inLine.next());
                  battingAverage = Double.parseDouble(inLine.next());
                  wins = Integer.parseInt(inLine.next());
                  losses = Integer.parseInt(inLine.next());
                  era = Double.parseDouble(inLine.next());
                  saves = Integer.parseInt(inLine.next());

                  // assign the new player object
                  newPlayer 
                     = new ReliefPitcher(number, playerName,
                     position, baseSalary, bonusAdjustmentFactor,
                     battingAverage, wins, losses, era, saves);

                  break;
               default:
                  // since none of the categories fit, throw the exception
                  // for an incorrext category
                  throw 
                     new InvalidCategoryException(String.valueOf(playerType));

            } // end of switch

            // If we make it here, we can add the read-in data where it goes
            if (playerCount == MAX_PLAYERS) // but if there are too many players
                                            // already on the roster
            {  
               // so long as the excluded ist isn't full
               if (excludedCount < MAX_EXCLUDED)
               {  
                  // add the player to the excluded array as a string
                  // and increment the count
                  excludedRecords[excludedCount] = playerLine;
                  excludedCount++;
               }
               // otherwise, if the excluded count is full, just skip it.
            }
            else // if there IS room in the player roster
            {
               // add the new player to the roster 
               // and increment the player count
               roster[playerCount] = newPlayer;
               playerCount++;
            }

         } // end of try. 
           // now we list catches where 1 of 
           // three specific exceptions might occur. 

         // CATCHES -----------------------------------------------------------
         catch (InvalidCategoryException e)
         {
            String error1 = e + " in: " + playerLine;
            if (excludedCount < MAX_EXCLUDED) {
               excludedRecords[excludedCount] = error1;
               excludedCount++;
            }
         }
         catch (NoSuchElementException e)
         {
            String error2 = e + "in: " + playerLine;
            if (excludedCount < MAX_EXCLUDED) {
               excludedRecords[excludedCount] = error2;
               excludedCount++;
            }
         }
         catch (NumberFormatException e)
         {
            String error3 = e + " in: " + playerLine;
            if (excludedCount < MAX_EXCLUDED) {
               excludedRecords[excludedCount] = error3;
               excludedCount++;
            }
         }

      } // end of while loop, goes back to top if there is more data left.

   } // end of method

   /**
    * Output a generic report for the team.
    * @return a format string
    */
   public String generateReport() {
      String output = "";
      output += "---------------------------------------\n";
      output += "Team report for " + teamName + "\n";
      output += "---------------------------------------\n";

      for (Object player : roster) {
         if (player instanceof BallPlayer) {
            output += "\n";
            output += player.toString();
            output += "\n";
         }
      }

      return output;
   }

   /**
    * Let's us sort the array "naturally" by number.
    * @return a string report
    */
   public String generateReportByNumber() {

      BallPlayer[] numberSortedRoster = Arrays.copyOf(roster, playerCount);
      Arrays.sort(numberSortedRoster);

      String output = "";
      output += "---------------------------------------\n";
      output += "Team report for " + teamName + " (by Number)\n";
      output += "---------------------------------------\n";

      for (BallPlayer player : numberSortedRoster) {
         if (player instanceof BallPlayer) {
            output += player.getNumber() + " " + player.getName() + " ";
            output += player.getPosition() + " " + player.stats();
            output += "\n";
         }
      }

      return output;
   }

   /**
    * Generate report unnaturally by name.
    * @return a String report
    */
   public String generateReportByName() {
      BallPlayer[] nameSortedRoster = Arrays.copyOf(roster, playerCount);
      Arrays.sort(nameSortedRoster, new NameComparator());

      String output = "";
      output += "---------------------------------------\n";
      output += "Team report for " + teamName + " (by Name)\n";
      output += "---------------------------------------\n";

      for (BallPlayer player : nameSortedRoster) {
         if (player instanceof BallPlayer) {
            output += player.getNumber() + " " + player.getName() + " ";
            output += player.getPosition() + " " + player.stats();
            output += "\n";
         }
      }

      return output;
   }

   /**
    * Generate a report by Earnings, unnaturally.
    * @return a sorted report string
    */
   public String generateReportByEarnings() {
      BallPlayer[] earningsSortedArray = Arrays.copyOf(roster, playerCount);
      Arrays.sort(earningsSortedArray, new EarningsComparator());

      DecimalFormat formatter = new DecimalFormat("##,##0.00");

      String output = "";
      output += "---------------------------------------\n";
      output += "Team report for " + teamName + " (by Earnings)\n";
      output += "---------------------------------------\n";

      for (BallPlayer player : earningsSortedArray) {
         if (player instanceof BallPlayer) {
            output += "$" + formatter.format(player.totalEarnings()) + " ";
            output += player.getNumber() + " " + player.getName() + " ";
            output += player.getPosition() + " " + player.stats();
            output += "\n";
         }
      }

      return output;
   }

   /**
    * Return a record of all excluded records.
    * @return a string report
    */
   public String generateExcludedRecordsReport() {
      String output = "";
      output += "---------------------------------------\n";
      output += "Excluded Records Report\n";
      output += "---------------------------------------\n";

      for (Object record : excludedRecords) {
         if (record instanceof String)
         {
            output += record.toString();
            output += "\n";
         } 
      }

      return output;
   }
   
}
