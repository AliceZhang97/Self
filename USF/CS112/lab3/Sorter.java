/* 
	A class to read and sort the input text.
	@author Alice Zhang
*/

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Collections;
import java.util.Scanner;

public class Sorter {
	public static void main (String[] args) {

		ArrayList<String> words = new ArrayList<String>();

		File inputFile = new File("words.txt");

		//uses a try-with-resources 
		try (Scanner input = new Scanner(inputFile)) {

			//read in file
			while(input.hasNext()) {

				String line = input.nextLine();	
				words.add(line);	
			}

		} catch(FileNotFoundException fnf) {
			System.out.println("File not found.");
			System.out.println(fnf.getMessage());
			System.exit(1);
		}

		// sort the words
		Collections.sort(words);

		System.out.println("Alphabetical A-Z:");
		for(int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			System.out.println(word);
		}

		System.out.println(); //print a blank line

		System.out.println("Alphabetical Z-A:");
		for(int i = words.size() - 1; i > -1; i--) {
			String word = words.get(i);
			System.out.println(word);
		}

	}
}
