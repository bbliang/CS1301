package edu.uga.cs1302.vehicles;

public class Rocket extends Vehicle implements Flyable{
	private int maxAltitude = 0;
	private int maxRange = 0;
	private String fuelType = "";
	
	public Rocket() { //default constructor
		super();
		maxAltitude = 0;
		maxRange = 0;
		fuelType = "";
	}
	
	public Rocket(int maxPassengers, int topSpeed, String name, String manufacturer, int modelYear,
			int maxAltitude, int maxRange, String fuelType) {
		super(maxPassengers, topSpeed, name, manufacturer, modelYear);
		this.maxAltitude = maxAltitude;
		this.maxRange = maxRange;
		this.fuelType = fuelType;
	}
	
	
	public int getMaxAltitude() { //accessor for maxAltitude
		return maxAltitude;
	}
	
	public void setMaxAltitude(int maxAltitude) { //mutator for maxAltitude
		this.maxAltitude = maxAltitude;
	}
	
	public int getMaxRange() { //accessor for maxRange
		return maxRange;
	}
	
	public void setMaxRange(int maxRange) { //mutator for maxRange
		this.maxRange = maxRange;
	}
	
	public String getFuelType() { //accessor for fuelType
		return fuelType;
	}
	
	public void setFuelType(String fuelType) { //mutator for fuelType
		this.fuelType = fuelType;
	}
	
	@Override
	public String toString() {
		return "Type: " + typeToString() + "\n"
				+ "Name: " + getName() + "\n"
				+ "Manufacturer: " + getManufacturer() + "\n"
				+ "Manufacture year: " + getModelYear() + "\n"
				+ "Max passengers: " + getMaxPassengers() + "\n"
				+ "Top speed: " + getTopSpeed() + " mph\n"
				+ "Max altitude: " + getMaxAltitude() + " ft\n"
				+ "Max range: " + getMaxRange() + " mi\n"
				+ "Fuel type: " + getFuelType();
	}
	
}