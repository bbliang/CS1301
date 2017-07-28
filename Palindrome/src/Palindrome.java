import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	//Receive number and make a copy
	System.out.print("Please enter an integer > 0: ");
	int number = input.nextInt();
	int temp = number;
	int reverse = 0;
	
	//Check if number is positive
	if (number <= 0) {
		System.out.println("Sorry, you must enter an integer greater than zero.");
		System.exit(0);
	}
	
	//Find reverse of number
	while (temp > 0) {
		int remainder = temp % 10;
		reverse = reverse * 10 + remainder;
		temp /= 10;
	}
	
	//Check if number and reverse are equivalent
	if (number == reverse) {
		
		//Calculate the summation of 1 to number
		int i = number;
		int sum = 0;
		while (i > 0) { 
			sum += i;
			i--;
		}
		
		//Print that number is palindrome &  its summation
		System.out.println("The integer " + number + " is a palindrome.");
		System.out.println("The sum of the numbers from 1 to " + number + " is " + sum);
	}
	else {
		System.out.println("The integer " + number + " is not a palindrome.");
		
	}
	
	}
}
