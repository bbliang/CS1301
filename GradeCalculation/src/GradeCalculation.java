import java.util.Scanner;

public class GradeCalculation {

	public static void main(String[] args) {
		//Declare objects
		Scanner input = new Scanner(System.in);

		//Declare variables
		String desiredGrade;
		String scoreStatus;
		String currentLetterGrade; 
		int weight1 = 0;
		int weight2 = 0;
		int weight3 = 0;
		int weight4 = 0;
		int weight5 = 0; 
		int weight6 = 0;
		int weight7 = 0;
		int totalWeight = 0;
		int score1 = 0;
		int score2 = 0;
		int score3 = 0;
		int score4 = 0;
		int score5 = 0;
		int score6 = 0;
		int score7 = 0;
		double currentScore = 0.0;
		double weightTimesScore = 0.0;
		double totalKnownGradeWeight = 0.0;
		double avgToFinalLetterGrade = 0.0;
		double finalOverallScore = 0.0;
		
		//Print grading scale
		System.out.println("Grading Scale: ");
		System.out.println("A \t 90 - 100");
		System.out.println("B \t 80 - 89");
		System.out.println("C \t 70 - 79");
		System.out.println("D \t 60 - 69");
		System.out.println("F \t below 	60");
		
		//Prompt user for the grade they want
		System.out.print("What letter grade do you want to achieve for the course? ");
		desiredGrade = input.nextLine().toUpperCase();
		
		//Check if user entered invalid grade
		if (!desiredGrade.equals("A") && !desiredGrade.equals("B") && !desiredGrade.equals("C")
				&& !desiredGrade.equals("D") && !desiredGrade.equals("D")) {
			System.out.println("Input Error");
			System.exit(0);
		}
		
		//Prompt user to enter in percentage weights
		System.out.println("Enter Percentage Weights:");
		System.out.print("Exam 1: \t");
		weight1 = input.nextInt();
		System.out.print("Exam 2: \t");
		weight2 = input.nextInt();
		System.out.print("Final Exam: \t");
		weight3 = input.nextInt();
		System.out.print("Labs: \t\t");
		weight4 = input.nextInt();
		System.out.print("Projects: \t");
		weight5 = input.nextInt();
		System.out.print("Attendance: \t");
		weight6 = input.nextInt();
		System.out.print("Quizzes: \t");
		weight7 = input.nextInt();
		
		//Check if the weights add up to 100
		totalWeight = weight1 + weight2 + weight3 + weight4 + weight5 + weight6 + weight7;
		if (totalWeight != 100) {
			System.out.println("Weights don't add up to 100, program exiting...");
			System.exit(0);
		}
		
		//Prompt user to enter in scores out of a 100
		System.out.println("Enter your scores out of a 100:");
		
		//Prompt for exam 1 score
		System.out.print("Do you know your Exam 1 score? ");
		scoreStatus = input.next().toUpperCase();
		if ("Y".equals(scoreStatus) || "YES".equals(scoreStatus)) {
			System.out.print("Score received on exam 1: ");
			score1 = input.nextInt();
			
			//Prompt for exam 2 score
			System.out.print("Do you know your Exam 2 score? ");
			scoreStatus = input.next().toUpperCase();
			if ("Y".equals(scoreStatus) || "YES".equals(scoreStatus)) {
				System.out.print("Score received on exam 2: ");
				score2 = input.nextInt();
			
				//Prompt for final exam score
				System.out.print("Do you know your Final Exam score?");
				scoreStatus = input.next().toUpperCase();
				if ("Y".equals(scoreStatus) || "YES".equals(scoreStatus)) {
					System.out.print("Score received on final exam: ");
					score3 = input.nextInt();
				}
				else {
					weight3 = 0;
				}
			}
			else {
				weight2 = 0;
				weight3 = 0;
			}
		}
		else {
			weight1 = 0;
			weight2 = 0;
			weight3 = 0;
		}
		//Prompt for lab average
		System.out.print("Do you know your lab average? ");
		scoreStatus = input.next().toUpperCase();
		if ("Y".equals(scoreStatus) || "YES".equals(scoreStatus)) {
			System.out.print("Average Lab Grade: ");
			score4 = input.nextInt();
		}
		else {
			weight4 = 0;
		}
		
		//Prompt for project average
		System.out.print("Do you know your project average? ");
		scoreStatus = input.next().toUpperCase();
		if ("Y".equals(scoreStatus) || "YES".equals(scoreStatus)) {
			System.out.print("Average Project Grade: ");
			score5 = input.nextInt();
		}
		else {
			weight5 = 0;
		}
		
		//Prompt for quiz average
		System.out.print("Do you know your quiz average? ");
		scoreStatus = input.next().toUpperCase();
		if ("Y".equals(scoreStatus) || "YES".equals(scoreStatus)) {
			System.out.print("Average Quiz Grade: ");
			score7 = input.nextInt();
		}
		else {
			weight7 = 0;
		}
		
		//Prompt for attendance average
		System.out.print("Do you know your attendance average? ");
		scoreStatus = input.next().toUpperCase();
		if ("Y".equals(scoreStatus) || "YES".equals(scoreStatus)) {
			System.out.print("Average Attendance Grade: ");
			score6 = input.nextInt();
		}
		else {
			weight6 = 0;
		}
		
		//Calculate current score & determine current letter grade
		weightTimesScore = weight1 * score1 + weight2 * score2 + weight3 * score3 + weight4 * score4 
				+ weight5 * score5 + weight6 * score6 + weight7 * score7; 
		totalKnownGradeWeight = weight1 + weight2 + weight3 + weight4 + weight5 + weight6 + weight7;
		currentScore = weightTimesScore / totalKnownGradeWeight;
		
		if (currentScore >= 90.0) {
			currentLetterGrade = "A";
		}
		else if (currentScore >= 80.0 && currentScore < 90.0) {
			currentLetterGrade = "B";
		}
		else if (currentScore >= 70.0 && currentScore < 80.0) {
			currentLetterGrade = "C";
		}
		else if (currentScore >= 60.0 && currentScore < 70.0) {
			currentLetterGrade = "D";
		}
		else {
			currentLetterGrade = "F";
		}
		
		//Display current score & letter grade
		System.out.printf("Current Grade Score: %1.2f\n" , currentScore);
		System.out.println("Your current letter grade is a " + currentLetterGrade);
		
		//Determine final overall score
		if (desiredGrade.equals("A")) {
			finalOverallScore = 90.0;
		}
		else if (desiredGrade.equals("B")) {
			finalOverallScore = 80.0;
		}
		else if (desiredGrade.equals("C")) {
			finalOverallScore = 70.0;
		}
		else if (desiredGrade.equals("D")) {
			finalOverallScore = 60.0;
		}
		else if (desiredGrade.equals("F")) {
			finalOverallScore = 0.0;
		}
		
		//Check if user already has desired letter grade
		if (currentScore >= finalOverallScore) {
			System.out.println("Congratulations! You received the " + desiredGrade + " that you wanted!");
			System.exit(0);
		}
		
		//Calculate average to final letter grade
		avgToFinalLetterGrade = (100 * finalOverallScore - weightTimesScore) / (100 - totalKnownGradeWeight);
		
		//Display average to final letter grade if achievable
		if (avgToFinalLetterGrade <= 100) {
			System.out.printf("You have to score an average greater than or equal to %1.2f in the remaining grade "
					+ "items to receive an " + desiredGrade + " in the course", avgToFinalLetterGrade);
		}
		else {
			System.out.println("Sorry, you cannot receive an " + desiredGrade + " in the course");
		}
	}

}
