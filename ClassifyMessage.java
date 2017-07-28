import java.util.Scanner;



public class ClassifyMessage {
	enum MessageCategory {NEED, OFFER, ALERT, INFO, UNKNOWN}
	
	public static void main(String[] args) {
		//Declare objects and variables
		Scanner keyboard = new Scanner(System.in);
		String catString, payload;
		double latitude, longitude;
		boolean isInRange;
		double south = 39.882343;
		double north = 40.231315;
		double west = -105.743511;
		double east = -104.907864;
		MessageCategory category;
		
		//Prompt for formatted message
		System.out.print("Please enter a formatted message: ");
		catString = keyboard.next().trim().toLowerCase();
		latitude = keyboard.nextDouble();
		longitude = keyboard.nextDouble();
		payload = keyboard.nextLine().trim();
		
		//Determine message category
		if (catString.equals("fire") || catString.equals("smoke")) {
			category = MessageCategory.ALERT;
		}
		else if (catString.equals("need")) {
			category = MessageCategory.NEED;
		}
		else if (catString.equals("offer")) {
			category = MessageCategory.OFFER;
		}
		else if (catString.equals("structure") || catString.equals("road") 
				|| catString.equals("photo") || catString.equals("evac")) {
			category = MessageCategory.INFO;
		}
		else {
			category = MessageCategory.UNKNOWN;
		}
		
		//Determine whether latitude and longitude are within geographic bounds
		if (latitude >= south && latitude <= north
				&& longitude >= west && longitude <= east) {
			isInRange = true;
		}
		else {
			isInRange = false;
		}
		
		//Print category, raw cat, message, latitude, longitude, and in range
		System.out.println("Category: \t" + category);
		System.out.println("Raw Cat: \t" + catString);
		System.out.println("Message: \t" + payload);
		System.out.println("Latitude: \t" + latitude);
		System.out.println("Longitude: \t" + longitude);
		System.out.println("In Range: \t" + isInRange);
	}
	
}
