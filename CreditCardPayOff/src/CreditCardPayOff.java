import java.util.Scanner;



public class CreditCardPayOff {
	
	public static void main(String[] args) {
		//Declare objects
		Scanner input = new Scanner(System.in);
		
		//Declare input variables
		double principal;
		double annualInterestRate;
		double monthlyPayment;
		
		//Declare calculated variables
		double monthsNeeded;
		int roundedMonths;
		double totalAmount;
		double totalInterest;
		double overpayment;
		
		//Retrieve input and assign variables
		System.out.print("Principal: \t\t\t");
		principal = input.nextDouble();
		
		System.out.print("Annual Interest Rate (%): \t");
		annualInterestRate = input.nextDouble();
		
		System.out.print("Monthly Payment: \t\t");
		monthlyPayment = input.nextDouble();
		
		//Compute number of months required
		monthsNeeded = (Math.log(monthlyPayment)-Math.log(monthlyPayment-(annualInterestRate/1200.0)*principal))
				/(Math.log(annualInterestRate/1200.0 + 1.0));
		
		//Round up monthsNeeded
		roundedMonths = (int) Math.ceil(monthsNeeded);
		
		//Calculate totalAmount, totalInterest, and overpayment
		totalAmount = roundedMonths * monthlyPayment;
		totalInterest = totalAmount - principal;
		overpayment = totalAmount - (monthsNeeded * monthlyPayment);
		
		//Display output
		System.out.printf("\nMonths Needed To Pay Off: \t%d\n" , roundedMonths);
		System.out.printf("Total Amount Paid: \t\t$%1.2f\n" , totalAmount);
		System.out.printf("Total Interest Paid: \t\t$%1.2f\n" , totalInterest);
		System.out.printf("Overpayment: \t\t\t$%1.2f\n" , overpayment);
	}

}