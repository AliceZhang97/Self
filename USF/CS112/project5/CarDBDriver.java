/**
	A Driver class that takes input file and calls methods on the generated linked list.
	@author Alice Zhang
**/

public class CarDBDriver {
	public static void main(String[] args) {
		CarlistBuilder builder = new CarlistBuilder();
		if (args.length != 1) {
			System.out.println("Error.");
			System.exit(0);
		}

		String filename = args[0];
		//build the list
		CarLinkedList list = builder.buildCarLinkedList(filename);

		//print all cars by calling toString method
		System.out.println("All Cars:");
		System.out.println(list.toString());

		//print all Green Cars
		System.out.println("Green Cars - Fuel Type:");
		System.out.println(list.toStringGreenCars());

		//print average MPG among all
		double resultDouble = list.avgMPG();
		String resultString = String.format("%.2f", resultDouble);
		System.out.println("Average MPG All: " + resultString);

		//print average MPG of Subaru
		double resultDoubleSUBARU = list.avgMpgByPartialModel("SUBARU");
		String resultStringSUBARU = String.format("%.2f", resultDoubleSUBARU);
		System.out.println("Average MPG Subaru: " + resultStringSUBARU);

		//print average MPG of Toyota
		double resultDoubleTOYOTA = list.avgMpgByPartialModel("TOYOTA");
		String resultStringTOYOTA = String.format("%.2f", resultDoubleTOYOTA);
		System.out.println("Average MPG TOYOTA: " + resultStringTOYOTA);

		//print average MPG of Ferrari
		double resultDoubleFERRARI = list.avgMpgByPartialModel("FERRARI");
		String resultStringFERRARI = String.format("%.2f", resultDoubleFERRARI);
		System.out.println("Average MPG FERRARI: " + resultStringFERRARI);

		//print classes with 4 cylinders
		System.out.println("Vehicle Classes with 4-Cylinder Cars:");
		for (String s : list.findClassesByCylinders(4)) {
			System.out.println("	" + s);
		}

		//print classes with 6 cylinders
		System.out.println("Vehicle Classes with 6-Cylinder Cars:");
		for (String s : list.findClassesByCylinders(6)) {
			System.out.println("	" + s);
		}

		//print Small SUVs with MPG > 22
		System.out.println("Small SUVs with MPG > 22:");
		for (String s : list.findModelsByClassAndMpg("small SUV", 22)) {
			System.out.println("	" + s);
		}

		//print Small Cars with MPG > 35
		System.out.println("Small Cars with MPG > 35:");
		for (String s : list.findModelsByClassAndMpg("small car", 35)) {
			System.out.println("	" + s);
		}
	}
}
