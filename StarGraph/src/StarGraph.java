import java.util.Scanner;

public class StarGraph {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Input
		System.out.print("Please enter the number of x values to process: ");
		int size = input.nextInt();
		input.nextLine();
		if (size <= 0) {
			System.out.println("The number of x values must be an integer greater than 0.");
			System.exit(0);
		}
		
		System.out.print("Enter a minimum value for x: ");
		double min = input.nextDouble();
		input.nextLine();
		
		System.out.print("Enter the amount to increment x: ");
		double increment = input.nextDouble();
		input.nextLine();
		if (increment <= 0.0) {
			System.out.println("The increment must be a decimal number greater than 0.");
			System.exit(0);
		}
		System.out.println();
		
		//Array declaration and initialization
		double[] x = new double[size];	//x array
		x[0] = min;
		for (int i = 1; i < size; i++) {
			x[i] = x[i-1] + increment;
		}
		
		double[] y = new double[size];	//y array
		for (int i = 0; i < size; i++) {
			y[i] = 20.0 * Math.abs(Math.sin(x[i]));
		}
		
		//Output
		System.out.println("Values");	//Print values
		for (int i = 0; i < size; i++) {
			System.out.printf("x: %1.3f, y: %1.3f\n", x[i], y[i]);
		}
		System.out.println();
		
		System.out.println("Graph");	//Print graph
		for (int i = 0; i < size; i++) {
			System.out.print(":");
			for (int j = 0; j < (int)y[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
