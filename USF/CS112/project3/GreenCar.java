//A class to set up Green Car
//@author Alice Zhang
public class GreenCar extends Car {

	//property
	private String fuelType;

	//GreenCar constructor
	public GreenCar(String model, String vehicleClass, int pollutionScore, String fuelType) {
		super(model, vehicleClass, pollutionScore);

		this.fuelType = fuelType;
	}

	//getter
	public String getFuelType() {
		return this.fuelType;
	}

	//toString method
	public String toString() {
		String returnValue = "Model: " + model + " Class: " + vehicleClass + " Pollution Score: " + pollutionScore + " Fuel Type: " + fuelType;
	
		return returnValue;
	}

}
