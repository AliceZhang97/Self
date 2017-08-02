/**
	A class to set up the super class Publication.
	@author Alice Zhang
**/

public abstract class Publication implements Comparable<Publication> {

	//properties
	protected String title;
	protected int numOfPages;

	//constructor
	public Publication(String title, int numOfPages) {
		this.title = title;
		this.numOfPages = numOfPages;
	}

	//getters
	public String getTitle() {
		return this.title;
	}
	public int getNumOfPages() {
		return this.numOfPages;
	}

	//compareTo mthod
	int c;
	public int compareTo(Publication other) {

		if(this.numOfPages < other.numOfPages) {
			c = -1;
		}
		else if (this.numOfPages > other.numOfPages) {
			c = 1;
		}
		return c;
	}

}
