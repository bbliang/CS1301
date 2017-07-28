/*
* Hangman2.java
* Author: Bryan Liang
* Submission Date: March 4, 2017
*
* Purpose: Succ me so gud im lik got damn u dirty bich
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class HangMan2 {

	private static final boolean testingMode = true;
	public static void main(String[] args) {
		
		boolean gameStatus = true;
		Scanner input = new Scanner(System.in);
		
		//Game loop
		while (gameStatus) {
			int gameCounter = 0;
			gameCounter ++;
			//Difficulty selection
			boolean invalidDifficulty = true;
			int numGuesses = 0, numSpaces = 0;
			while (invalidDifficulty) {
				System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
				String rawInput = input.nextLine().toLowerCase().trim();
				if (rawInput.isEmpty()) {	//case: empty input
					System.out.println("Invalid	difficulty. Try Again...");
					continue;
				}
				char difficulty = rawInput.charAt(0);
				if (difficulty == 'e') {	//case: e
					numGuesses = 15;
					numSpaces = 4;
					invalidDifficulty = false;
				}
				else if (difficulty == 'i') {	//case: i
					numGuesses = 12;
					numSpaces = 3;
					invalidDifficulty = false;
				}
				else if (difficulty == 'h') {	//case: h
					numGuesses = 10;
					numSpaces = 2;
					invalidDifficulty = false;
				}
				else {	//case: invalid input
					System.out.println("Invalid	difficulty. \tTry Again...");
				}
			}
			//Import secret word and display guess word
			String secretWord = RandomWord.newWord(), guessWord = "", solveWord = "";
			secretWord = "aaaaaa";	//debug mode: comment this when submitting
			for (int i = 0; i < secretWord.length(); i++) {
				guessWord += '-';
			}
			if (testingMode == true) {
				System.out.println("The secret word is: " + secretWord);	
			}
			System.out.println("The word is: " + guessWord);
			
			//Game rounds
			boolean gameOver = false;
			while (!gameOver) {
				//Guess
				char guess = ' ';
				System.out.println("Please enter the letter you want to guess: ");
				String rawInput = input.nextLine().toLowerCase().trim();
				if (rawInput.isEmpty() || !Character.isLetter(rawInput.charAt(0))) {	//case: empty or invalid guess
					System.out.println("Your input is not valid. Try again.");
					System.out.println("Guesses Remaining: " + numGuesses);
					continue;
				}
				else if (rawInput.equalsIgnoreCase("solve")) {	//case: solve
					System.out.println("Please solve the answer: ");
					solveWord = input.nextLine().toLowerCase();
					if (solveWord.equals(secretWord)) {
						gameOver = true;
					}
					else {
						numGuesses--;
						System.out.println("That is not the secret word.");
						System.out.println("Guesses remaining: " + numGuesses);
					}
					continue;
				}
				else {
					guess = rawInput.charAt(0);
				}
				//Spaces
				String spacesInput = " ";
				System.out.println("Please enter the spaces you want to check (separated by spaces):");
				spacesInput = input.nextLine().trim();
				//Parse spaces input
				int space1 = 0, space2 = 0, space3 = -1, space4 = -1, numValues = 1;
				for (int i = 0; i < spacesInput.length(); i += 2) {
					if (Character.isDigit(spacesInput.charAt(i))) {
						switch (numValues) {
							case 1:
								space1 = Character.getNumericValue(spacesInput.charAt(i));
								break;
							case 2:
								space2 = Character.getNumericValue(spacesInput.charAt(i));
								break;
							case 3:
								space3 = Character.getNumericValue(spacesInput.charAt(i));
								break;
							case 4:
								space4 = Character.getNumericValue(spacesInput.charAt(i));
								break;
						}
						numValues++;
					}
				}
				//Spaces input validation
				boolean invalidValue = false, outOfBounds = false, invalidNumSpaces = false;
				int rawNumDelimiter = 0;
				for (int i = 0; i < spacesInput.length(); i++) {
			          if ((!Character.isDigit(spacesInput.charAt(i))) && (spacesInput.charAt(i) != ' ')) { 	//case: invalid values
			        	  invalidValue = true;
			          }
			          if (spacesInput.charAt(i) == ' ') {
							rawNumDelimiter++;
			          }
				}
				if (space1 > secretWord.length() - 1 || space2 > secretWord.length() - 1 || 	//case: out of bounds value
						space3 > secretWord.length() - 1 || space4 > secretWord.length() - 1) {
					outOfBounds = true;
				}
				if (rawNumDelimiter + 1 != numSpaces) {	//case: invalid number of spaces
					invalidNumSpaces = true;
				}
				if (spacesInput.isEmpty() == true || invalidValue == true || //invalid cases: empty, out of bounds, non-digit values, incorrect no. spaces
						invalidNumSpaces == true || outOfBounds == true) {	 
					System.out.println("Your input is not valid. Try again.");
					System.out.println("Guesses Remaining: " + numGuesses);
					continue;
				}
				//Game validation
				String temp = "";
				boolean correctGuess = false;
				for (int i = 0; i < secretWord.length(); i++) {
					if ((guess == secretWord.toLowerCase().charAt(i)) && (space1 == i || space2 == i || space3 == i || space4 == i )) {
						temp += secretWord.charAt(i);
						correctGuess = true;
					}
					else {
						temp += guessWord.charAt(i);	
					}
				}
				guessWord = temp;
				//Display status of guess, updated word, and guesses remaining
				if (correctGuess) {
					System.out.println("Your guess is in the word!");
				}
				else {
					numGuesses--;	//decrement no. guesses if wrong answer
					System.out.println("Your letter was not found in the spaces you provided.");
				}
				System.out.println("The updated word is: " + guessWord);
				System.out.println("Guesses Remaining: " + numGuesses);
				//Check game status
				if (numGuesses == 0 || guessWord.equals(secretWord)) {
					gameOver = true;
				}
			}
			
			//Display whether user won or lost
			if (guessWord.equals(secretWord) || solveWord.equals(secretWord)) {
				System.out.println("You have guessed the word. Congratulations!");
			}
			else {
				System.out.println("You have failed to guess the word... :(");
			}
			//Prompt user to play again
			System.out.println("Would you like to play again? Yes(y) or No(n)");
			char playAgain = input.nextLine().toLowerCase().charAt(0);
			if (playAgain != 'y' || gameCounter <= 20) {
				gameStatus = false;
			}
		}
	}
}
