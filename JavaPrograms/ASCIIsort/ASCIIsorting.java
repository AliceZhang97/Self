import java.util.Arrays;
import java.util.Scanner;

public class ASCIIsorting {

	public static void main(String[] args) {
		String result = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of tests:");
		int num = scan.nextInt();
		
		for (int i = 0; i < num; i++) {
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter a 3-characters test:");
			String test = scan1.next();
			
			char[] list = test.toCharArray();
			Arrays.sort(list);
			for (char c : list) {
				result = result + c + " ";
			}
			result = result + "\n";
		}
		System.out.println(result);

	}

}
