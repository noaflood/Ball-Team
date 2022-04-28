import java.util.Comparator;

/**
 * Let's us compare BallTeam players by their name.
 *
 * Project 10
 * @author Noah Flood - Comp 1210 - Section 001
 * @version 4/18/22
 *
 */
public class EarningsComparator implements Comparator<BallPlayer> {
   
   /**
    * Let us compare ballplayers by their earnings.
    * @param a first player
    * @param b second player
    * @return an int represeting the comparison
    */
   public int compare(BallPlayer a, BallPlayer b) {

      if ((a.totalEarnings() - b.totalEarnings()) < 0.0001)
      {
         return 0; // total earnings are equal
      }
      else if (a.totalEarnings() > b.totalEarnings())
      {
         return -1; // total earnings of A are greater than B
      }
      else
      {
         return 1; // total earnings of B are greater than A
      }
   }
   
}
