/**
	A class containing two methods:
		1. count the total lines of code of a file
		2. count the total lines of comments of a file
	@author Alice Zhang
**/

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class CountMethod {

	//count the total lines of code
	public int totalLines(File f) {
		int totalLines = 0;

		try (Scanner input = new Scanner(f)) {
			
			while(input.hasNext()) {
				String line = input.nextLine();
				//increment totalLines
				totalLines++;
			}

		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}
		return totalLines;
	}

	//count the total liens of comments
	public int comments(File f) {
		int comments = 0;

		try (Scanner input = new Scanner(f)) {

			boolean inComment = false;

			while(input.hasNext()) {
				//read line and save it as a string
				String line = input.nextLine();
				//trim the line
				line = line.trim();

				//if line is a one-line comment
				if (line.startsWith("//")) {
					comments++;
				}
				//if line is in a multi-comment
				if (!inComment && line.startsWith("/*")) {
					comments++;
					inComment = true;
				} else if (inComment && !line.endsWith("*/")) {
					comments++;
				} else if (inComment && line.endsWith("*/")) {
					comments++;
					inComment = false;
				}
			}

		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}
		return comments;
	}

}
