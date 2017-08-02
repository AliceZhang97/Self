//A class to set up Carlist
//@author Alice Zhang

import java.lang.*;

public class Carlist {

	//data member
	private Car[] carlist;
	private int count;

	//constructor
	public Carlist() {
		carlist = new Car[100];
		count = 0;
	}

	//resize method
	private void resize() {

		Car[] newCarList = new Car[carlist.length*2];

		for(int a = 0; a < carlist.length; a++) {
			newCarList[a] = carlist[a];
		}
		carlist = newCarList;
	}

	//insert Car into sorted order
	public void addCar(Car c) {

		if(count >= carlist.length) {
			resize();
		}

		int i = count;
		while (i > 0) {
			if (c.compareTo(carlist[i - 1]) > 0) {
				break;
			} else {
				carlist[i] = carlist[i - 1];
			}
			i--;
		}
		carlist[i] = c;
		count++;
	}

	//toString method for entile database
	public String toString() {
		String returnValue = "";
		for (int i = 0; i < count; i++) {
			returnValue = returnValue + (carlist[i].toString()) + "\n";
		}
		return returnValue;
	}

	//toStringGreenCars for Green Cars
	public String toStringGreenCars() {
		String returnValue = "";
		for (Car c : carlist) {
			if (c instanceof GreenCar) {
				returnValue += "Model: " + ((GreenCar)c).getModel() + " Fuel Type: " + ((GreenCar)c).getFuelType() + "\n";
			}
		}
		return returnValue;
	}

	//avgMPG method for Gas Cars
	public double avgMPG() {
		double totalMPG = 0;
		int counter = 0;
		for (int i = 0; i < count; i++) {
			if (carlist[i] instanceof GasCar) {
				totalMPG = totalMPG + ((GasCar)carlist[i]).getMPG();
				counter++;
			}
		}
		double averageMPG = totalMPG / counter;
		return averageMPG;
	}

	//average MPG by partial model
	public double avgMpgByPartialModel(String inputString) {

		double totalMPG = 0;
		int counter = 0;

		for (int i = 0; i < count; i++) {
			if (carlist[i] instanceof GasCar) {
				if (carlist[i].model.contains(inputString)) {
					totalMPG = totalMPG + ((GasCar)carlist[i]).getMPG();
					counter++;
				}
			}
		}
		double averageMPG = totalMPG / counter;
		return averageMPG;
	}

	public boolean ifDuplicated(String other, String[] temporary) {
		for (String s : temporary) {
			if (s != null && s.equals(other)) {
				return true;
			}
		}
		return false;
	}

	//find vehicle classes by given cylinders
	public String[] findClassesByCylinders(int inputCylinders) {
		String[] list = new String[carlist.length];
		int count = 0;

		for (Car c : carlist) {
			if (c instanceof GasCar) {
				if ( ((GasCar)c).getNumberCylinders() == inputCylinders) {
					String match = ((GasCar)c).getVehicleClass();
					if (!ifDuplicated(match, list)) {
						list[count] = match;
						count++;
					}
				}
			}
		}
		
		//copy everything to a new list 
		String[] newlist = new String[count];
		for (int i = 0; i < count; i++) {
			newlist[i] = list[i];
		}
		return newlist;
	}

	//find models by given classes and MPG
	public String[] findModelsByClassAndMpg(String inputVehicleClass, int inputMPG) {
		String[] list = new String[carlist.length];
		int count = 0;

		for (Car c : carlist) {
			if (c instanceof GasCar) {
				if ((((GasCar)c).getVehicleClass().equals(inputVehicleClass)) && (((GasCar)c).getMPG() > inputMPG)) {
					String match = c.getModel();
					list[count] = match;
					count++;
				}
			}
		}

		String[] newlist = new String[count];
		for (int i = 0; i < count; i++) {
			newlist[i] = list[i];
		}
		return newlist;
	}
}
