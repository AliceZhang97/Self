/**
	A driver class to create lists, 
	call all the methods of counting,
	and print the format.
	@author Alice Zhang
**/

import java.util.ArrayList;
import java.io.File;

public class JavaClassAnalyzer {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Error.");
			System.exit(0);
		}

		//gives me an Arraylist of all java files
		JavaListBuilder builder = new JavaListBuilder();
		String directory = args[0];
		builder.buildJavaList(directory);
		ArrayList<File> javaFileList = builder.returnMethod();

		//gives me the valid list & invalid list
		ListGenerator generator = new ListGenerator();
		ArrayList<File> validJavalist = generator.validJavaList(javaFileList);
		ArrayList<File> invalidJavalist = generator.invalidJavaList(javaFileList);

		//if the valid list is not empty
		if (validJavalist.size() != 0) {
			//print the counts of valid classes
			System.out.println("Valid Classes: - Total: " + validJavalist.size());

			//gives me the sorted valid list
			ArrayList<JavaFile> validListSorted = generator.validListSorted(validJavalist);

			int totalSLOC = 0;
			int totalSLOCWithoutComment = 0;
			for (JavaFile jf : validListSorted) {

				//get the total SLOC & total SLOC(excluding comments)
				totalSLOC = totalSLOC + jf.getSLOC();
				totalSLOCWithoutComment = totalSLOCWithoutComment + jf.getSlocWithoutComments();
				
				//call toString method in JavaFile class
				System.out.println(jf);
			}

			//print the total counts
			System.out.println("Total SLOC: " + totalSLOC);
			System.out.println("Total SLOC (excluding comments): " + totalSLOCWithoutComment);
		} 
		//if the valid list is empty
		else {
			System.out.println("There is no valid classes.");
		}

		//if the invalid list is not empty
		if (invalidJavalist.size() != 0) {
			System.out.println("Invalid Classes:");
			for (File f : invalidJavalist) {
				String absolutePath = f.getAbsolutePath();
				System.out.println(absolutePath);
			}
		}
		//if the invalid list is empty 
		else {
			System.out.println("There is no invalid classes.");
		}

	}
}
