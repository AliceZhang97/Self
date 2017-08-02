/**
	A class to get extensions of files and get the count of them
	@author Alice Zhang
**/
import java.io.File;
import java.util.HashMap;

public class FileFinder {

	public static HashMap<String, Integer> findFiles(String directory) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		findFiles(new File(directory), result);
		return result;
	}

	//the helper method 
	private static void findFiles(File input, HashMap<String, Integer> result) {
		if (input.isFile()) {
			String filename = input.getName();
			String check = ".";
			if (filename.contains(check)) {
				String extension = filename.substring(filename.lastIndexOf('.'), filename.length());
				if (!result.containsKey(extension)) {
					result.put(extension, 1);
				} else {
					int count = result.get(extension);
					count++;
					result.put(extension, count);
				}
			}
		} else if (input.isDirectory()) {
			File[] children = input.listFiles();
			for (File f : children) {
				findFiles(f, result);
			}
		}
	}

	//print the result
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Error.");
			System.exit(0);
		}
		HashMap<String, Integer> result = findFiles(args[0]);
		for(String key : result.keySet()) {
    		System.out.println(key + ": " + result.get(key));
		}
	}
}
