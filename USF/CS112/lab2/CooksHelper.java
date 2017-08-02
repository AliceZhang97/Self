/*
	A class to convert tablespoons to cups.
	@author Alice Zhang
*/

import java.util.Scanner;

public class CooksHelper {
	public static void main (String[] args) {

		double tablespoon;
		double cup;

		Scanner scan = new Scanner (System.in);

		System.out.println("Enter the number of tablespoons.");
		tablespoon = scan.nextDouble();

		cup = tablespoon / 16;

		System.out.println(tablespoon + " tablespoons is equal to " + cup + " cups.");


	}
}
