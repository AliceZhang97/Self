/* 
	A class to implement some logics.
	@ author Alice Zhang
*/

import java.util.Scanner;

public class AppleOrange2 {

	public static void main (String[] args) {

		double inputNum;

		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter a number between 1 and 100.");
		inputNum = scan.nextDouble();

		if (inputNum%3==0 && inputNum%7!=0)
			System.out.println("apple");

		else if (inputNum%7==0 && inputNum%3!=0)
			System.out.println("orange");

		else if (inputNum%3==0 && inputNum%7==0)
			System.out.println("appleorange");

		else if (inputNum < 1 || inputNum > 100)
			System.out.println("banana");

		else
			System.out.println(inputNum);

	}
} 
