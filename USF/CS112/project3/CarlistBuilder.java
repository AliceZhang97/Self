//A class to read the file and creat Carlist
//@author Alice Zhang

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import java.lang.*;

public class CarlistBuilder {

	public Carlist buildCarlist(String filename) {

		Carlist carlist = new Carlist();

		File inputFile = new File(filename);

		try(Scanner input = new Scanner(inputFile)) {
			
			//skip the first line
			input.nextLine();

			while (input.hasNextLine()) {

				String line = input.nextLine();
				String[] var = line.split(",");
				Car c;

				if (var[5].equals("Gasoline") || var[5].equals("Gasoline/Electricity") || var[5].equals("Ethanol/Gas") || var[5].equals("Diesel") || var[5].equals("Ethanol")) { //it's a Gas Car
					String model = var[0];
					String vehicleClass = var[10];
					int pollutionScore = Integer.parseInt(var[11]);
					int numberCylinders = Integer.parseInt(var[2]);
					String mpgString = var[14];
					int mpg = 0;
					if (mpgString.contains("/")) {
						String[] parts = mpgString.split("/");
						String left = parts[0];
					} else {
						mpg = Integer.parseInt(mpgString);
					}
					c = new GasCar(model, vehicleClass, pollutionScore, numberCylinders, mpg);
				} else { //it's a Green Car
					String model = var[0];
					String vehicleClass = var[10];
					int pollutionScore = Integer.parseInt(var[11]);
					String fuelType = var[5];
					c = new GreenCar(model, vehicleClass, pollutionScore, fuelType);
				}

				carlist.addCar(c);
			}

		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return null;
		}

		return carlist;
	}
}
