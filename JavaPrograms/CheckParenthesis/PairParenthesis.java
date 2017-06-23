import java.util.Scanner;

public class PairParenthesis {
	public static void main(String[] args) {
		//Ask for input
		String tests[] = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of tests (<=5) :");
		int num = scan.nextInt();
		if (num < 1 || num > 5) {
			System.out.println("Wrong input.");
			return;
		} else {
			tests = new String[num];
			for (int i = 0; i < num; i++) {
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Enter a test, only use [ , ] , ( , ) : ");
				tests[i] = scan2.next();
			}
		}
		CheckParenthesis check = new CheckParenthesis();
		for (String s : tests) {
			boolean b = check.checker(s);
			if (b == true) {
				System.out.println("Yes.");
			} else {
				System.out.println("No.");
			}
		}
	}
}
