/**
	A class to check if the input string is palindrome or not
	@author Alice Zhang
**/
public class PalindromeTester {
	public static boolean isPalindrome(String word) {
		if (word.length() == 0 || word.length() == 1) {
			return true;
		}
		if (word.charAt(0) == word.charAt(word.length() - 1)) {
			return isPalindrome(word.substring(1, word.length() - 1));
		}
		return false;
	}

	//the main method
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Error.");
			System.exit(0);
		}
		String s = args[0];
		System.out.println(isPalindrome(s));
	}
}
