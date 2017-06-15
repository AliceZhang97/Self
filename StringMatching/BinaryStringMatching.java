import java.util.Scanner;

public class BinaryStringMatching {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Binary String Matching");
		System.out.println("Enter number of tests:");
		int num = scan.nextInt();
		
		String answer = "";
		
		for (int i = 0; i < num; i++) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter your first binary string:");
			String s1 = scan2.next();
			
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Enter your second binary string:");
			String s2 = scan3.next();
			
			CountSubString css = new CountSubString();
			answer = answer + css.countSubString(s1, s2) + "\n";
		}
		
		System.out.println(answer);
	}

}
