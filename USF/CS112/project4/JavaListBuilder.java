/**
	A class to create an arraylist of all java files
	@author Alice Zhang
**/

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class JavaListBuilder {
	ArrayList<File> javaFileList = new ArrayList<File>();

	public void buildJavaList(String directory) {

		File inputFile = new File(directory);

		if (inputFile.isFile()) {
			String filename = inputFile.getName();
			String check = ".";
			if (filename.contains(check)) {
				String extension = filename.substring(filename.lastIndexOf('.'), filename.length());
				//check if the file is a java file
				if (extension.equals(".java")) {
					javaFileList.add(inputFile);
				}
			}
		} else if (inputFile.isDirectory()) {
			File[] children = inputFile.listFiles();
			for (File f : children) {
				buildJavaList(f.getAbsolutePath());
			}
		}
	}

	//method to return the list
	public ArrayList<File> returnMethod() {
		return javaFileList;
	}
}
