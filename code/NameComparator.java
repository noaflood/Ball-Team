import java.util.Comparator;

/**
 * Let's us compare BallTeam players by their name.
 *
 * Project 10
 * @author Noah Flood - Comp 1210 - Section 001
 * @version 4/18/22
 *
 */
public class NameComparator implements Comparator<BallPlayer> {
   
   /**
    * Let;s us compare using name alphabetically.
    * @param nameA first player
    * @param nameB second player
    * @return an int determining which is greater.
    */
   public int compare(BallPlayer nameA, BallPlayer nameB) {

      // put name of player A in order of last to first for proper comaparison
      String[] nameArray = nameA.getName().split(" ");
      String a = "";
      a += nameArray[nameArray.length - 1];
      a += nameArray[0];

      // do the same for name of player B
      nameArray = nameB.getName().split(" ");
      String b = "";
      b += nameArray[nameArray.length - 1];
      b += nameArray[0];

      // make the comparison
      if (a.equalsIgnoreCase(b))
      {
         return 0; //they have the same name
      }
      else if (a.toLowerCase().compareTo(b.toLowerCase()) < 0) 
      {
         return -1; // item A is higher alphabetically than B
      }
      else
      {
         return 1; // item B is higher alphabetically than A
      }
   }
}