/* 
	A class to play Rock Paper Scissors.
	@author Alice Zhang
*/

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {

		int userChoice;

		do {
		//generate random computer choice
		Random r = new Random();
		int computerChoice = r.nextInt(3)+1;

		String returnComputer = "";
		if (computerChoice == 1) {
			returnComputer = returnComputer + "Rock";
		}
		if (computerChoice == 2) {
			returnComputer = returnComputer + "Paper";
		}
		if (computerChoice == 3) {
			returnComputer = returnComputer + "Scissors";
		}

		// ask for user's choice
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter 1 (Rock), 2 (Paper), or 3 (Scissors) - Enter 0 to exit");
		userChoice = scan.nextInt();

		String returnUser = "";
		if (userChoice == 1) {
			returnUser = returnUser + "Rock";
		}
		else if (userChoice == 2) {
			returnUser = returnUser + "Paper";
		}
		else if (userChoice == 3) {
			returnUser = returnUser + "Scissors";
		}
		else if (userChoice == 0) {
			System.out.println("Game over.");
		}
		else {
			System.out.println("Invalid input.");
		}

		// play the game
		if (computerChoice == userChoice) {
			System.out.println("Computer chooses " + returnComputer + ". Player chooses " + returnUser + ".");
			System.out.println("It's a tie!");
		}
		if (computerChoice == 1 && userChoice == 2) {
			System.out.println("Computer chooses " + returnComputer + ". Player chooses " + returnUser + ".");
			System.out.println("Player wins!");
		}
		if (computerChoice == 1 && userChoice == 3) {
			System.out.println("Computer chooses " + returnComputer + ". Player chooses " + returnUser + ".");
			System.out.println("Computer wins!");
		}
		if (computerChoice == 2 && userChoice == 1) {
			System.out.println("Computer chooses " + returnComputer + ". Player chooses " + returnUser + ".");
			System.out.println("Compuer wins!");
		}
		if (computerChoice == 2 && userChoice == 3) {
			System.out.println("Computer chooses " + returnComputer + ". Player chooses " + returnUser+ ".");
			System.out.println("Player wins!");
		}
		if (computerChoice == 3 && userChoice == 1) {
			System.out.println("Computer chooses " + returnComputer + ". Player chooses " + returnUser + ".");
			System.out.println("Player wins!");
		}
		if (computerChoice == 3 && userChoice == 2) {
			System.out.println("Computer chooses " + returnComputer + ". Player chooses " + returnUser + ".");
			System.out.println("Computer wins!");
		}

		} while (userChoice != 0);
	
	}
}
