/**
	A class to set up the sub class Book.
	@author Alice Zhang
**/
public class Book extends Publication {

	//property
	private boolean cover;

	//Book constructor
	public Book(String title, int numOfPages, boolean cover) {
		super(title, numOfPages);

		this.cover = cover;
	}

	//getter
	public boolean getCover() {
		return this.cover;
	}

	//toString method
	public String toString() {
		String returnValue = "Title: " + title + " Number of Pages: " + numOfPages + " Cover: ";
		if (this.cover) {
			returnValue = returnValue + "soft";
		} else {
			returnValue = returnValue + "hard";
		}
		return returnValue;
	}
}
