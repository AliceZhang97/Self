/*
	A class to count the occurrences of words.
	@ author Alice Zhang
*/

public class Word {

	// data member
	private String theWord;


	// constructor
	public Word(String theWord) {
		this.theWord = theWord.toLowerCase();
	}

	// method countChars
	public Integer countChars(char inputChar) {
		int count = 0;
		for (int i = 0; i < theWord.length(); i++) { 
			if (inputChar == theWord.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	// method matchingChars
	public Integer matchingChars(String inputMatch) {
		int count = 0;

		for (int i = 0; i<theWord.length() && i<inputMatch.length(); i++) {
			if (theWord.charAt(i) == inputMatch.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
}
