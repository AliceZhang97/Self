/**
	A class to print a triangle pattern of numbers
	@author Alice Zhang
**/
public class NumberPrinter {

	//print single row of numbers starting from 0 to n
	private static void printRows(int n) {
		printRows(n, 0);
	}
	//the helper method
	private static void printRows(int n, int count) {

		if(count == n) {
			System.out.println(n);
			return;
		}

		System.out.print(count + "");
		printRows(n, count+1);
	}

	//print numbers by traingle structure
	public static void printTriangle(int n) {
		printTriangle(n, 0);
	}
	//the helper method
	private static void printTriangle(int n, int count) {
		if (count == n) {
			printRows(n);
			return;
		}
		printRows(count);
		printTriangle(n, count + 1);
		printRows(count);
	}

	//the main method
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Error.");
			System.exit(0);
		}
		int n = Integer.parseInt(args[0]);
		printTriangle(n);
	}
}
