/**
 * For making some exceptions...
 * Useful for when user file has an invalid item type
 * ball player.
 *
 * Project 11
 * @author Noah Flood - Comp 1210 - Section 001
 * @version 4/22/22
 *
 */
public class InvalidCategoryException extends Exception {

   /**
    * Exceotions for an invalid file type.
    * @param category attempted category
    */
   public InvalidCategoryException(String category) {
      super("For category: " + "\"" + category + "\"");
   }
   
}
