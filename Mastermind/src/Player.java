import java.util.Scanner;

public class Player {
	private String name = "";
	private int fastestWin = 0;
	private int gamesCompleted = 0;
	private Scanner keyboard = new Scanner(System.in);
	
	public String askForGuess() {	//read in guess from keyboard
		System.out.print("Enter a guess motherfucker: ");
		return keyboard.nextLine();
	}
	
	public String getName() {	//returns player's name
		
		return name;
	}
	
	public int getFastestWin() {	//returns fastest win
		
		return fastestWin;
	}
	
	public int getGamesCompleted() {	//returns the number of games completed
		
		return gamesCompleted;
	}
	
	public void setName(String name) {	//sets player's name
		this.name = name;
	}
	
	public void updateStats(int numberOfMovesTakenToWin) {	//updates gamesCompleted and fastestWin
		
		gamesCompleted ++;
		if (fastestWin == 0)
			fastestWin = numberOfMovesTakenToWin;
		else if (numberOfMovesTakenToWin < fastestWin)
			fastestWin = numberOfMovesTakenToWin;
	}
	
	
}
