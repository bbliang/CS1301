package edu.uga.cs1302.vehicles;

public class FlyingBoat extends Vehicle implements Flyable, Floatable{
	private int maxAltitude = 0;
	private int maxRange = 0;
	private int tonnage = 0;
	private int numEngines = 0;
	
	public FlyingBoat() { //default constructor
		super();
		maxAltitude = 0;
		maxRange = 0;
		tonnage = 0;
		numEngines = 0;
	}
	
	public FlyingBoat(int maxPassengers, int topSpeed, String name, String manufacturer, int modelYear,
			int maxAltitude, int maxRange, int tonnage, int numEngines) {
		super(maxPassengers, topSpeed, name, manufacturer, modelYear);
		this.maxAltitude = maxAltitude;
		this.maxRange = maxRange;
		this.tonnage = tonnage;
		this.numEngines = numEngines;
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
	
	public int getTonnage() { //accessor for tonnage
		return tonnage;
	}
	
	public void setTonnage(int tonnage) { //mutator for tonnage
		this.tonnage = tonnage;
	}
	
	public int getNumEngines() { //accessor for numEngines
		return numEngines;
	}
	
	public void setNumEngines(int numEngines) { //mutator for numEngines
		this.numEngines = numEngines;
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
				+ "Tonnage: " + getTonnage() + " t\n"
				+ "Number of engines: " + getNumEngines();
	}
}
