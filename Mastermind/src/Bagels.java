import java.util.Scanner;

public class Bagels {
	
	public static void main(String[] args) {
	
		//Initialize objects
		Scanner keyboard = new Scanner(System.in);
		Player p = new Player();
		Engine e = new Engine();
		Validator v = new Validator();
		
		//Prompt
		System.out.println("Welcome!");
		
		//Program loop
		boolean status = true;
		while (status) {
			
			System.out.print("Enter the number of digits to use: ");
			e.setNumDigits(keyboard.nextInt());	//set numDigits
			keyboard.nextLine();
			System.out.print("Enter the player's name: ");
			p.setName(keyboard.nextLine()); //set name
			
			//Game loop
			boolean game = true;
			while (game) {
				System.out.println("\nStarting game #" + (p.getGamesCompleted() + 1) + ".");
				e.generateNewSecret();
				
				//Game round loop
				boolean gameRounds = true;
				int counter = 0;
				while (gameRounds) {
					counter++;
					String s = p.askForGuess();
					int[] guess = e.convertNumToDigitArray(s);
					
					//Evaluation
					if (v.validateGuess(e.getSecretNumber(), guess, e.getNumDigits())) {
						gameRounds = false;
					}
				}
				
				//Post-game stats
				System.out.println("Congratulations! You won in " + counter + " moves.\n");
				p.updateStats(counter);
				System.out.println("Statistics for " + p.getName() + ":");
				System.out.println("Games completed: " + p.getGamesCompleted());
				System.out.println("Fastest win: " + p.getFastestWin());
				
				//Menu
				System.out.println("p - Play again \n r - Reset game \n q - Quit \n");
				System.out.println("What would you like to do? ");
				String menu = keyboard.nextLine();
				
				if (menu.equals("r"))
					game = false;
				else if (menu.equals("p"))
					continue;
				else
					System.out.println("\nGoodbye!");
					System.exit(0);
			}
			
		}
		
		
	}
}
