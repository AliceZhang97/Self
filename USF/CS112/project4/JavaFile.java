/**
	A class to set up JavaFile.
	@author Alice Zhang
**/

public class JavaFile implements Comparable<JavaFile> {

	private String className;
	private String absolutePath;
	private int sloc; 
	private int slocWithoutComments;

	//constructor for valid java file
	public JavaFile(String className, String absolutePath, int sloc, int slocWithoutComments) {
		this.className = className;
		this.absolutePath = absolutePath;
		this.sloc = sloc;
		this.slocWithoutComments = slocWithoutComments;
	}

	//getters
	public int getSLOC() {
		return this.sloc;
	}
	public int getSlocWithoutComments() {
		return this.slocWithoutComments;
	}

	//compareTo method
	int c;
	public int compareTo(JavaFile other) {
		if (this.sloc < other.sloc) {
			c = -1;
		} else if (this.sloc > other.sloc) {
			c = 1;
		}
		return c;
	}

	//toString for valid file
	public String toString() {
		return "Class: " + this.className + " [" + this.absolutePath + "]\n" +
				"	SLOC: " + this.sloc + "\n" +
				"	SLOC (excluding comments): " + this.slocWithoutComments;
	}
}
