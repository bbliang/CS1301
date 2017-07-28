import java.util.Scanner;

public class ParseTheTweet {

	public static void main(String[] args) {
		//Declare objects
		Scanner input = new Scanner(System.in);
		
		//Declare variables
		String original, type, detail, location, longitude, latitude;
		int start, finish;
		
		//Retrieve original from user input
		original = input.nextLine();
		
		//Retrieve specific value from tweet and remove specific section from original
		start = original.indexOf("#typ");
		finish = original.indexOf(";");
		type = original.substring(start + 5, finish);
		original = original.substring(finish + 2, original.length());
		
		start = original.indexOf("#det");
		finish = original.indexOf(";");
		detail = original.substring(start + 5, finish);
		original = original.substring(finish + 2, original.length());
		
		start = original.indexOf("#loc");
		finish = original.indexOf(";");
		location = original.substring(start + 5, finish);
		original = original.substring(finish + 2, original.length());
		
		start = original.indexOf("#lat");
		finish = original.indexOf(";");
		latitude = original.substring(start + 5, finish);
		original = original.substring(finish + 2, original.length());
		
		start = original.indexOf("#long");
		finish = original.indexOf(";");
		longitude = original.substring(start + 6, finish);
		
		//Make type string upper case
		type = type.toUpperCase();
		
		//Replace commas with hyphens in detail and location
		detail = detail.replaceAll(",", "-");
		location = location.replaceAll(",", "-");
		
		//Print type, detail, location, longitude, and latitude
		System.out.println("Type: \t\t" + type.toUpperCase());
		System.out.println("Detail: \t" + detail);
		System.out.println("Location: \t" + location);
		System.out.println("Latitude: \t" + latitude);
		System.out.println("Longitude: \t" + longitude);

	}

}
