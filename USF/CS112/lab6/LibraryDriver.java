/**
	Class of LibraryDriver.
	@author Alice Zhang
**/

import java.util.ArrayList;
import java.util.Collections;

public class LibraryDriver {
	public static void main(String[] args) {

		//new ArrayList of Publication (pubs)
		ArrayList<Publication> pubs = new ArrayList<Publication>();

		//adding some Book
		pubs.add(new Book("The Kite Runner", 372, true));
		pubs.add(new Book("Room", 336, false));
		pubs.add(new Book("Gone Girl", 432, false));
		//adding some Magazine
		pubs.add(new Magazine("Vogue", 355, 30000));
		pubs.add(new Magazine("National Geographic", 502, 50000));

		//sort pubs
		Collections.sort(pubs);

		//print
		for (Publication p : pubs) {
			System.out.println(p);
		}
	}
}
