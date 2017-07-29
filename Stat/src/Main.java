
public class Main {
	public static void main(String[] args) {
		Stat stat1 = new Stat();
		
		double[] newArray = {0,1,2,3,4};
		stat1.setData(newArray);
		System.out.println("mode: " + stat1.mode());
		
		
	}
}
