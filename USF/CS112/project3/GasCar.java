//A class to set up Gas Car
//@author Alice Zhang
public class GasCar extends Car {

	//property
	private int numberCylinders;
	private int mpg;

	//GasCar constructor 
	public GasCar(String model, String vehicleClass, int pollutionScore, int numberCylinders, int mpg) {
		super(model, vehicleClass, pollutionScore);

		this.numberCylinders = numberCylinders;
		this.mpg = mpg;
	}

	//getters
	public int getNumberCylinders() {
		return this.numberCylinders;
	}
	public int getMPG() {
		return this.mpg;
	}

	//toString method
	public String toString() {
		return "Model: " + model + " Class: " + vehicleClass + " Pollution Score: " + pollutionScore + " MPG: " + mpg + " Cylinders: " + numberCylinders;
	}

}
