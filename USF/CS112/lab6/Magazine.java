/**
	A class to set up the sub class Magazine.
	@author Alice Zhang
**/

public class Magazine extends Publication {

	//property
	private int numOfSubs;

	//Magazine constructor
	public Magazine(String title, int numOfPages, int numOfSubs) {
		super(title, numOfPages);

		this.numOfSubs = numOfSubs;
	}

	//getter
	public int getNumOfSubs() {
		return this.numOfSubs;
	}

	//toString method
	public String toString() {
		return "Title: " + title + " Number of Pages: " + numOfPages + " Number of Subscribers: " + numOfSubs;
	}
}
