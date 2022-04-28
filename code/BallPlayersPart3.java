import java.io.FileNotFoundException;

 /**
 * Main method holder for all reports. 
 *
 * Project 10
 * @author Noah Flood - Comp 1210 - Section 001
 * @version 4/22/22
 *
 */
public class BallPlayersPart3 {
   
   /**
   * Main method.
   * @param args used for file name
   * @throws FileNotFoundException because we use files
   *
   */
   public static void main(String[] args) {

      try 
      {
         if (args.length == 0) 
         {  
            // in the case that there is not a command line arugment
            System.out.println("File name expected as command line argument.");
            System.out.println("Program ending.");
         }
         else
         {  
            // make a team, print data about them
            BallTeam yankees = new BallTeam();

            // get the file name from command line arguments
            yankees.readBallPlayerFile(args[0]);

            System.out.println(yankees.generateReport());
            System.out.println(yankees.generateReportByNumber());
            System.out.println(yankees.generateReportByName());
            System.out.println(yankees.generateReportByEarnings());
            System.out.println(yankees.generateExcludedRecordsReport());
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("*** Attempted to read file: " + e);
      }

   } // end of try
   
} // end of main
