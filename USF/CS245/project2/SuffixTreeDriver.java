/** The driver class for SuffixTree */
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.io.PrintWriter;

public class SuffixTreeDriver {
	public static void main(String[] args) {
		processStrings("inputStringsSimple");

	}

	/** Process strings from the given file. See comments inside the method */
	public static void processStrings(String filename) {
		// FILL IN CODE 
		// Read each string from the file, construct a suffix tree

		File inputFile = new File(filename);

		try(Scanner input = new Scanner(inputFile)) {
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (!line.contains(",")) {
					//the line contains the string
					SuffixTree st = new SuffixTree(line);
					
					try{
						PrintWriter outFile = new PrintWriter(new File(line + "Results.txt"));
						//print the string
						outFile.println(st.toString());

						//print an empty line
						outFile.println();

						//for valid suffix
						String line_2 = input.nextLine();
						String[] line_2_split = line_2.split(", ");
						String printedValid = "";
						for (String valid : line_2_split) {
							printedValid = printedValid + st.containsSuffix(valid) + " ";
						}
						outFile.println(printedValid);

						//for invalid suffix
						String line_3 = input.nextLine();
						String[] line_3_split = line_3.split(", ");
						String printedInvalid = "";
						for (String invalid : line_3_split) {
							printedInvalid = printedInvalid + st.containsSuffix(invalid) + " ";
						}
						outFile.println(printedInvalid);

						//for valid substring
						String line_4 = input.nextLine();
						String[] line_4_split = line_4.split(", ");
						for (String validSub : line_4_split) {
							outFile.print(st.getSubstringIndices(validSub) + " ");
						}
						outFile.print("\n");

						//for invalid substring
						String line_5 = input.nextLine();
						String[] line_5_split = line_5.split(", ");
						for (String invalidSub : line_5_split) {
							outFile.print(st.getSubstringIndices(invalidSub) + " ");
						}
						outFile.print("\n");

						outFile.flush();
						outFile.close();
					} catch (FileNotFoundException fnf) {
						System.out.println(fnf.getMessage());
						return;
					}
					if (input.hasNextLine()) {
						input.nextLine(); //skip empty line
					}
				}
			}

		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return;
		}

	}

}
