package edu.uga.cs1302.vehicles;

public abstract class Vehicle implements Transporter{
	private int maxPassengers = 0; //variables are private to maintain encapsulation
	private int topSpeed = 0;
	private String name = "";
	private String manufacturer = "";
	private int modelYear = 0; //vehicle's year of manufacture
	protected static int instanceCount = 0; //static to be class-wide, protected for access thru sub-classes
	
	public Vehicle() { //default constructor
		maxPassengers = 0;
		topSpeed = 0;
		name = "";
		manufacturer = "";
		modelYear = 0;
		instanceCount++; //increment # of instances
	}
	
	public Vehicle(int maxPassengers, int topSpeed, String name, String manufacturer, int modelYear) {
		this.maxPassengers = maxPassengers;
		this.topSpeed = topSpeed;
		
		this.name = name;
		this.manufacturer = manufacturer;
		this.modelYear = modelYear;
		instanceCount++; //increment # of instances
	}
	
	public int getMaxPassengers() { //accessor for maxPassengers
		return maxPassengers;
	}
	
	public void setMaxPassengers(int maxPassengers) { //mutator for maxPassengers
		this.maxPassengers = maxPassengers;
	}
	
	public int getTopSpeed() { //accessor for topSpeed
		return topSpeed;
	}
	
	public void setTopSpeed(int topSpeed) { //mutator for topSpeed
		this.topSpeed = topSpeed;
	}
	
	public String getName() { //accessor for name
		return name;
	}
	public void setName(String name) { //mutator for name
		this.name = name;
	}
	
	public String getManufacturer() { //accessor for manufacturer
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) { //mutator for manufacturer
		this.manufacturer = manufacturer;
	}
	
	public int getModelYear() { //accessor for modelYear
		return modelYear;
	}
	public void setmodelYear(int modelYear) { //mutator for modelYear
		this.modelYear = modelYear;
	}
	
	public static int getInstanceCount() { //accessor for instanceCount
		return instanceCount;
	}
	
	public String typeToString() {
		if (this instanceof Automobile)
			return "Automobile";
		else if (this instanceof Airplane)
			return "Airplane";
		else if (this instanceof Ship)
			return "Ship";
		else if (this instanceof FlyingBoat)
			return "FlyingBoat";
		else if (this instanceof Rocket)
			return "Rocket";
		else 
			return "";
	}
	
	
}
