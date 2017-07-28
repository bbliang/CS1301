import java.util.Random;

public class Engine {

	private int numDigits = 0;
	private int[] secretNumber = new int[numDigits];
	private Random randomNumberGenerator = new Random();
	
	public int[] convertNumToDigitArray(String s) {
		int[] digitArray = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			digitArray[i] = Character.getNumericValue(s.charAt(i));
		}
		return digitArray;
	}
	
	public int getNumDigits() {
		
		return numDigits;
	}
	
	public int[] getSecretNumber() {
		
		return secretNumber;
	}
	
	public void generateNewSecret() {
		int lower = (int) Math.pow(10, numDigits - 1); //lower bound
		int upper = (int) Math.pow(10, numDigits) - 1; //upper bound
		
		int num = randomNumberGenerator.nextInt(upper-lower) + lower;
		String s = Integer.toString(num);
		
		secretNumber = convertNumToDigitArray(s);
	}
	
	public void setNumDigits(int numDigits) {
		
		this.numDigits = numDigits;
	}
	
	public void setSecretNumber(int[] secretNumber) {
		
		this.secretNumber = new int[secretNumber.length];
		
		for (int i = 0; i < secretNumber.length; i++) {
			this.secretNumber[i] = secretNumber[i];
		}
	}
}
