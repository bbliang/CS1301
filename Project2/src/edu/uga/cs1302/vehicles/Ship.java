package edu.uga.cs1302.vehicles;

public class Ship extends Vehicle implements Floatable{
	private int tonnage = 0;
	private String owner = ""; //shipping line owner
	
	public Ship() { //default constructor
		super();
		tonnage = 0;
		owner = "";
	}
	
	public Ship(int maxPassengers, int topSpeed, String name, String manufacturer, int modelYear,
			int tonnage, String owner) {
		super(maxPassengers, topSpeed, name, manufacturer, modelYear);
		this.tonnage = tonnage;
		this.owner = owner;
	}
	
	public int getTonnage() { //accessor for tonnage
		return tonnage;
	}
	
	public void setTonnage(int tonnage) { //mutator for tonnage
		this.tonnage = tonnage;
	}
	
	public String getOwner() { //accessor for tonnage
		return owner;
	}
	
	public void setOwner(String owner) { //mutator for tonnage
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "Type: " + typeToString() + "\n"
				+ "Name: " + getName() + "\n"
				+ "Manufacturer: " + getManufacturer() + "\n"
				+ "Manufacture year: " + getModelYear() + "\n"
				+ "Max passengers: " + getMaxPassengers() + "\n"
				+ "Top speed: " + getTopSpeed() + " mph\n"
				+ "Tonnage: " + getTonnage() + " t";
	}
}
