package edu.uga.cs1302.vehicles;
import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) {
		Vehicle[] v = new Vehicle[15];
		Scanner keyboard = new Scanner(System.in);
		
		//Automobiles
		v[0] = new Automobile(5, 120, "Honda Accord", "Honda", 2001, 100);
		v[1] = new Automobile(5, 140, "Toyota Camry", "Toyota", 2002, 200);
		v[2] = new Automobile(4, 180, "Nissan Leaf", "Nissan", 2003, 300);
		
		//Airplanes
		v[3] = new Airplane(300, 600, "Boeing 747", "Boeing", 2004, 43000, 8500, 2);
		v[4] = new Airplane(150, 560, "Airbus A320", "Airbus", 1987, 42000, 1860, 2);
		v[5] = new Airplane(300, 700, "Boeing 787", "Boeing", 2006, 50000, 2000, 2);
		
		//Ships
		v[6] = new Ship(2000, 20, "RMS Titanic", "Harland and Wolff", 1911, 46000, "White Star Line");
		v[7] = new Ship(3780, 26, "Costa Concordia", "Fincantieri", 2006, 130000, "Costa Crociere");
		v[8] = new Ship(100, 15, "RRS Sir David Attenborough", "Cammell Laird", 2016, 15000, "NERC");
		
		//FlyingBoats
		v[9] = new FlyingBoat(20, 400, "Kawanishi H8K", "Kawanishi", 1941, 36000, 1500, 5000, 4);
		v[10] = new FlyingBoat(4, 250, "PBY Catalina", "Consolidated Aircraft", 1935, 32000, 1000, 1000, 2);
		v[11] = new FlyingBoat(40, 500, "H-4 Hercules", "Hughes Aircraft", 1947, 34000, 2500, 5000, 8);
		
		//Rockets
		v[12] = new Rocket(2, 6164, "Saturn V", "Boeing", 1967, 327360, 327360, "RP-1");
		v[13] = new Rocket(300, 600, "Falcon Heavy", "SpaceX", 2017, 327360, 327360, "Hydrogen");
		v[14] = new Rocket(300, 600, "Space Shuttle", "United Space Alliance", 1981, 327360, 327360, "Oxygen");
		
		//menu
		boolean status = true;
		System.out.println("Welcome to the Vehicle Information System!");
		while (status) {
			System.out.println("Press 1 to see how many vehicles are in the system.");
			System.out.println("Press 2 to see the name and kind of each vehicle.");
			System.out.println("Press 3 to see which vehicles can fly.");
			System.out.println("Press 4 to see which vehicles can float.");
			System.out.println("Press 5 to see which vehicles can float AND fly.");
			System.out.println("Press 6 to see a description of each vehicle.");
			System.out.println("Press h to see a brief help information for your system.");
			System.out.println("Press q to terminate the program.");
			String input = keyboard.nextLine();
			
			if (input.equals("1")) { //Option 1: display number of vehicles in system
				System.out.println("There are " + Vehicle.getInstanceCount() + " vehicles in the system.");
			}
			else if (input.equals("2")) { //Option 2: display name and kind of each vehicle
				for (int i = 0; i < v.length; i++) {
					System.out.println(v[i].getName() + " is a(n) " + v[i].typeToString() + ".");
				}
			}
			else if (input.equals("3")) { //Option 3: display which vehicles can fly
				System.out.println("The following vehicles can fly: ");
				System.out.printf("%-20s%s%n", "TYPE", "NAME"); //aligned columns
				for (int i = 0; i < v.length; i++) {
					if (v[i] instanceof Flyable)
						System.out.printf("%-20s%s%n", v[i].typeToString(), v[i].getName());
				}
			}
			else if (input.equals("4")) { //Option 4: display which vehicles can float
				System.out.println("The following vehicles can float: ");
				System.out.printf("%-20s%s%n", "TYPE", "NAME");
				for (int i = 0; i < v.length; i++) {
					if (v[i] instanceof Floatable)
						System.out.printf("%-20s%s%n", v[i].typeToString(), v[i].getName());
				}
			}
			else if (input.equals("5")) { //Option 5: display which vehicles can fly and float
				System.out.println("The following vehicles can float and fly: ");
				System.out.printf("%-20s%s%n", "TYPE", "NAME");
				for (int i = 0; i < v.length; i++) {
					if (v[i] instanceof Flyable && v[i] instanceof Floatable)
						System.out.printf("%-20s%s%n", v[i].typeToString(), v[i].getName());
				}
			}
			else if (input.equals("6")) { //Option 6: display a descripton of each vehicle
				for (int i = 0; i < v.length; i++) {
					System.out.println(v[i].toString());
					System.out.println();
				}
			}
			else if (input.equals("h")) { //Option h: display brief help information
				System.out.println("Please enter one of the valid commands below. Other inputs will be disregarded.");
			}
			else if (input.equals("q")) { //Option q: Terminate the program
				System.out.println("Terminating...");
				System.exit(0);
			}
			else //Invalid input
				System.out.println("Invalid input. Please try again.");
			System.out.println("--------------------------------------------------");	
		}
			
	}
		
		
}
