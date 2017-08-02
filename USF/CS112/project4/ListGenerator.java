/**
	A class to return three ArrayList:
		1. arraylist containing all valid java files
			2. arraylist of JavaFile that sorts the first list
		3. arraylist containing all invalid java files
	@author Alice Zhang
**/

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import java.util.Scanner;

public class ListGenerator {

	//method to return valid list
	public ArrayList<File> validJavaList(ArrayList<File> list) {

		ArrayList<File> validList = new ArrayList<File>();

		for (File f : list) {

			String filename = f.getName();
			String definedClassName = filename.substring(0, filename.lastIndexOf('.'));

			try (Scanner input = new Scanner(f)) {

				while (input.hasNext()) {

					String line = input.nextLine();
					line = line.trim();

					//check if the class is valid
					String classHeader = "public class ";
					if (line.contains(classHeader)) {
						String[] var = line.split(" ");
						String className = var[2];

						if (definedClassName.equals(className)) {
							validList.add(f);
						} 
					}
				}
			} catch(FileNotFoundException fnf) {
				System.out.println(fnf.getMessage());
			}
		}
		return validList;
	}

	// method to return the sorted valid list
	CountMethod method = new CountMethod();

	public ArrayList<JavaFile> validListSorted(ArrayList<File> list) {

		ArrayList<JavaFile> validListSorted = new ArrayList<JavaFile>();

		for (File f : list) {
			String fileName = f.getName();
			String className = fileName.substring(0, fileName.lastIndexOf('.'));
			String  absolutePath = f.getAbsolutePath();
			int sloc = method.totalLines(f);
			int comments = method.comments(f);
			int slocWithoutComments = sloc - comments;

			JavaFile javafile = new JavaFile(className, absolutePath, sloc, slocWithoutComments);
			validListSorted.add(javafile);
			Collections.sort(validListSorted);
		}
		return validListSorted;
	}

	//method to return invalid list
	public ArrayList<File> invalidJavaList(ArrayList<File> list) {

		ArrayList<File> invalidList = new ArrayList<File>();

		for (File f : list) {

			String filename = f.getName();
			String definedClassName = filename.substring(0, filename.lastIndexOf('.'));

			try (Scanner input = new Scanner(f)) {

				while (input.hasNext()) {

					String line = input.nextLine();
					line = line.trim();

					//check if the class is invalid
					String classHeader = "public class ";
					if (line.contains(classHeader)) {
						String[] var = line.split(" ");
						String className = var[2];

						if (!definedClassName.equals(className)) {
							invalidList.add(f);
						}
					}
				}
			} catch(FileNotFoundException fnf) {
				System.out.println(fnf.getMessage());
			}
		}
		return invalidList;
	}
}
