/**
	A class to set up comparable Car
	@author Alice Zhang
**/

public abstract class Car implements Comparable<Car> {

	//properties
	protected String model;
	protected String vehicleClass;
	protected int pollutionScore;

	//constructor
	public Car(String model, String vehicleClass, int pollutionScore) {
		this.model = model;
		this.vehicleClass = vehicleClass;
		this.pollutionScore = pollutionScore;
	}

	//getters
	public String getModel() {
		return this.model;
	}
	public String getVehicleClass() {
		return this.vehicleClass;
	}
	public int getPollutionScore() {
		return this.pollutionScore;
	}

	//compareTo method
	int c;
	public int compareTo(Car other) {
		if (this.pollutionScore == other.getPollutionScore()) {
			c = this.model.compareTo(other.getModel());
		}
		else {
			if (this.pollutionScore < other.pollutionScore) {
				c = -1;
			} else if (this.pollutionScore > other.pollutionScore) {
				c = 1;
			}
		}

		return c;
	}

}
