package edu.uga.cs1302.vehicles;

public class Automobile extends Vehicle{
	private int horsepower = 0;
	
	public Automobile() { //default constructor
		super();
		horsepower = 0;
	}
	
	public Automobile(int maxPassengers, int topSpeed, String name, String manufacturer, int modelYear,
			int horsepower) {
		super(maxPassengers, topSpeed, name, manufacturer, modelYear);
		this.horsepower = horsepower;
	}
	
	public int getHorsepower() { //accessor for horsepower
		return horsepower;
	}
	
	public void setHorsepower(int horsepower) { //mutator for horsepower
		this.horsepower = horsepower;
	}
	
	@Override
	public String toString() {
		return "Type: " + typeToString() + "\n"
				+ "Name: " + getName() + "\n"
				+ "Manufacturer: " + getManufacturer() + "\n"
				+ "Manufacture year: " + getModelYear() + "\n"
				+ "Max passengers: " + getMaxPassengers() + "\n"
				+ "Top speed: " + getTopSpeed() + " mph\n"
				+ "Horsepower: " + getHorsepower() + " hp";
	}
}