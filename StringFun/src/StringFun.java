import java.util.Scanner;

public class StringFun {
	
	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		
		//Receive original string
		System.out.println("Enter the string to be manipulated");
		String original = input.nextLine();
		
		//Manipulation loop
		boolean status = true;
		while (status) {
			//Receive command from user
			System.out.println("Enter your command (quit, print reverse, replace all, replace single, remove)");
			String command = input.nextLine();
			
			//Quit command
			if (command.equalsIgnoreCase("quit")) {
				status = false;
			}
			
			//Print reverse command
			else if (command.equalsIgnoreCase("print reverse")) {
				String reverse = "";
				for (int i = original.length() - 1; i >= 0; i--) {
					reverse += original.charAt(i);
				}
				
				System.out.println(reverse);
			}
			
			//Replace all command
			else if (command.equalsIgnoreCase("replace all")) {
				//Prompt user for character to replace
				System.out.println("Enter the character to replace");
				char oldChar = input.nextLine().charAt(0);
				
				//Prompt user for new character
				System.out.println("Enter the new character");
				char newChar = input.nextLine().charAt(0);
				
				//Replace all instances of oldChar
				String temp = "";
				boolean notFound = true;
				for (int i = 0; i < original.length(); i++) {
					if (original.charAt(i) == oldChar) { //Check if oldChar
						temp += newChar;
						notFound = false;
					}
					else {
						temp += original.charAt(i);
					}
				}
				
				//Check if letter user wants to replace exists
				if (notFound == true) {
					System.out.println("Error: the letter you are trying to replace does not exist");
				}
				//Update and display original
				else {
					original = temp;
					System.out.println("The new string is: " + original);
				}
			}
			
			//Replace single command
			else if (command.equalsIgnoreCase("replace single")) {
				//Prompt user for character to replace
				System.out.println("Enter the character to replace");
				char oldChar = input.nextLine().charAt(0);
				
				//Prompt user for new character
				System.out.println("Enter the new character");
				char newChar = input.nextLine().charAt(0);
				
				//Prompt user for specific instance to replace
				System.out.println("Which " + oldChar + " would you like to replace?");
				
				//Valid input
				char rawInput = input.nextLine().charAt(0);
				int instance = 0;
				if (Character.isDigit(rawInput)) {
					instance = Character.getNumericValue(rawInput);
				}
				else {
					System.out.println("Error: invalid integer");
					continue;
				}
				
				//Replace specific instance of oldChar
				String temp = "";
				int charNo = 1;
				boolean notFound = true;
				for (int i = 0; i < original.length(); i++) {
					if (original.charAt(i) == oldChar) { //Check if char at i == oldChar
						if (instance == charNo) { //Check if correct instance to replace
							temp += newChar;
							notFound = false;
						}
						else {
						temp += original.charAt(i);
						charNo ++;
						}
					}
					else {
						temp += original.charAt(i);
					}
				}
				//Check if letter user wants to replace exists
				if (notFound == true) {
					System.out.println("Error: the letter you are trying to replace does not exist");
				}
				//Update and display original
				else {
					original = temp;
					System.out.println("The new string is: " + original);
				}
			}
			
			//Remove command
			else if (command.equalsIgnoreCase("remove")) {
				//Receive the character to remove
				System.out.println("Enter the character to remove");
				char removeChar = input.nextLine().charAt(0);
				
				//Remove all instances of removeChar
				String temp = "";
				for (int i = 0; i < original.length(); i++) {
					//Check if oldChar
					if (original.charAt(i) == removeChar) {
						continue;
					}
					else {
						temp += original.charAt(i);
					}
							
				}	
				//Check if letter user wants to replace exists
				if (original.equals(temp)) {
					System.out.println("Error: the letter you are trying to remove does not exist");
				}
				//Update and display original
				else {
					original = temp;
					System.out.println("The new string is: " + original);
				
				}
			}
			
		}
	}
	
}
