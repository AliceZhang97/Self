import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.io.PrintWriter;

/** The driver class for GeneralizedSuffixTree */
public class GeneralizedSuffixTreeDriver {
	public static void main(String[] args) {
		testLongestPalindrome("banana");
		testLCS("inputStringsForGeneralizedSuffixTree", "lcsResults");

	}

	/**
	 * A method that uses a generalized suffix tree to find the longest common
	 * palindrome in a given string
	 */
	public static void testLongestPalindrome(String s) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(s);
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--)
			reverse += s.charAt(i);
		arr.add(reverse);

		ArrayList<String> markers = new ArrayList<String>();
		markers.add("#");
		markers.add("$");

		GeneralizedSuffixTree tree = new GeneralizedSuffixTree(arr, markers);
		ArrayList<String> lcs = tree.findLCS();
		System.out.println("Longest palindrome(s): " + lcs);
	}

	/**
	 * Read a list of strings and a list of markers from the file. Build a
	 * generalized suffix tree. Invoke findLCS method. Print output to the file.
	 * Repeat: Read another set of strings&markers, build a tree, call findLCS
	 * method etc.
	 */
	public static void testLCS(String intputFile, String outputFile) {
		// FILL IN CODE
		// Repeat until the end of file:
		File inputF = new File(intputFile);

		try(Scanner input = new Scanner(inputF)) {
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (line.contains(",")) {
					// Read a line with strings
					ArrayList<String> arr = new ArrayList<String>();
					String[] line_split = line.split(", ");
					for (String s : line_split) {
						arr.add(s);
					}

					// read a line with markers
					ArrayList<String> markers = new ArrayList<String>();
					String line_2 = input.nextLine();
					String[] line_2_split = line_2.split(", ");
					for (String m : line_2_split) {
						markers.add(m);
					}
					// Build a generalized suffix tree
					GeneralizedSuffixTree gst = new GeneralizedSuffixTree(arr, markers);

					// call findLCS
					gst.findLCS(); 

				}
			}
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return;
		}

	}

}
