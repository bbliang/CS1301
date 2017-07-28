public class Validator {
  /*
   * Prints "Pico," "Fermi," or "Bagel" (or some combination) then returns
   * true for a correct guess or false for an incorrect guess.
   *
   * parameter  secret    the opponent's secret number as a int array of digits
   * parameter  guess     the player's guess as an int array of digits
   * parameter  numDigits the number of digits in the number (should be the same as guess.length and secret.length)
   * return			      a boolean indicating a win or a loss
   */
  public static boolean validateGuess(int[] secret, int[] guess, int numDigits) {
    if(secret.length != numDigits || guess.length != numDigits) {
      System.err.println("Error: int arrays must be numDigits in length.");
      return false;
    }

    // this array will refer to digits in secret that have been accounted for
    // initialized to all false by default
    boolean[] digitAccountedFor = new boolean[numDigits]; 
    String output = "";

    // Check for, and print out, all fermi results first.
    int fermiCount = 0;
    for(int i=0; i<numDigits; i++) {
      if(guess[i] == secret[i]) {
        fermiCount++;
        output += "Fermi ";
        digitAccountedFor[i] = true;
      }
    }

    // Check for, and print out, all pico results.
    for(int i=0; i<numDigits; i++) {
      // skip the fermi digits
      if (guess[i] == secret[i]) continue;

      // find the first occurrence of guess[i] in secret not already used
      int index = indexOf(guess[i], secret, digitAccountedFor);

      // if such an index is found, add a pico and mark the index as used
      if(index != -1) {
        output = "Pico " + output; // We want to print the picos before the fermis
        digitAccountedFor[index] = true; 
      }
    }

    if(output.length()==0) {
      output = "Bagel";
    } else {
      // cut off that last space, because I'm picky
      output = output.substring(0, output.length()-1);
    }

    System.out.println(output);

    return fermiCount==numDigits;
  }

  /*
   * Returns the index of the first occurrence of value in the int[] list that
   * is not already marked true in digitAccountedFor.
   *
   * parameter value             the value to search for
   * parameter list              the list to search through
   * parameter digitAccountedFor a boolean array, specifying whether that index can be used again
   * return		                 the index where value was found, or -1 if it wasn't found
   */
  private static int indexOf(int value, int[] list, boolean[] digitAccountedFor) {
    for(int i=0; i<list.length; i++) {
      if(!digitAccountedFor[i] && value == list[i]) {
        return i;
      }
    }
    return -1;
  }
}