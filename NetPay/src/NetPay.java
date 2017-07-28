import java.util.Scanner;

public class NetPay {
	//Declare named constants
	public static final double FEDERAL_TAX_PERCENT = 10.00;
	public static final double STATE_TAX_PERCENT = 4.5;
	public static final double SS_PERCENT = 6.2;
	public static final double MEDICARE_PERCENT = 1.45;
	public static final double PAY_PER_HOUR = 7.25;
	
	public static void main(String[] args) {
		//Declare objects
		Scanner input = new Scanner(System.in);
		
		//Declare variables
		int hoursPerWeek;
		double grossPay;
		double netPay;
		double federal;
		double state;
		double ss;
		double medicare;
		double totalDeduction;
		
		//Prompt user for hours per week
		System.out.print("Hours per Week: \t");
		hoursPerWeek = input.nextInt();
		
		//Calculate gross pay
		grossPay = hoursPerWeek * PAY_PER_HOUR;
		
		//Calculate deductions
		federal = grossPay * FEDERAL_TAX_PERCENT / 100; //calculate federal tax deduction
		state = grossPay * STATE_TAX_PERCENT / 100; //calculate state tax deduction
		ss = grossPay * SS_PERCENT / 100; //calculate SS deduction
		medicare = grossPay * MEDICARE_PERCENT / 100; //calculate medicare deduction
		totalDeduction = federal + state + ss + medicare; //calculate total deduction
		
		//Calculate netPay
		netPay = grossPay - totalDeduction;
		
		//Display gross pay & net pay
		System.out.println("Gross Pay: \t\t" + grossPay); //display gross pay
		System.out.println("Net Pay: \t\t" + netPay + "\n"); //display net pay
		
		//Display deductions
		System.out.println("Deductions"); //display the string Deductions
		System.out.println("Federal: \t\t" + federal); //display federal deduction
		System.out.println("State: \t\t\t" + state); //display state tax deduction
		System.out.println("Social Security: \t" + ss); //display SS deduction
		System.out.println("Medicare: \t\t" + medicare); //display medicare deduction
		
	}
}
