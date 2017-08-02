/**
	A class with utility methods for manipulating one and two dimensional
	arrays of characters.
**/
public class ArrayUtilities {

	/**
		Reverses the characters in the array original in place.
		No new arrays may be created.
		Returns the reference to the array original with
		characters reversed.
		Example input: ['a', 'b', 'c', 'd']
		Example output: ['d', 'c', 'b', 'a']
	**/
	public static char[] reverse(char[] original) {

		//REPLACE WITH YOUR CODE
		for (int i = 0; i < original.length/2; i++) {

			char newChar = original[i];

			original[i] = original[original.length - 1 - i];

			original[original.length - 1 - i] = newChar;
		}

		return original;
	}


	/**
		Converts a two dimensional array of char to a one 
		dimensional array of char. This method may assume
		that all subarrays of the original are of the same
		length.
		Returns the one dimensional array.
		Example input: 
		[['a', 'b', 'c']
		 ['e', 'd', 'f']
		 ['i', 'h', 'g']]
		 Example output:
		 ['a', 'b', 'c', 'e', 'd', 'f', 'i', 'h', 'g']
	 **/
	public static char[] to1D(char[][] original) {

		//REPLACE WITH YOUR CODE
		char[] newArray = new char[original.length * original[0].length];

		int i = 0;

		for (int r = 0; r < original.length; r++) {
			for (int c = 0; c < original[r].length; c++) {
				newArray[i] = original[r][c];
				i++;
			}
		}

		return newArray;
	}

	/**
		Finds the char with the smallest value in each row
		of the original and returns an array containing the 
		values found. The result at position [0] will be the
		smallest valued char in row 0 of original.
		This method does NOT assume that all subarrays of the
		original are of the same length.
		Example input:
		[['e', 'c', 'f', 'g', 'c', 'e']
		 ['b', 'b', 'b', 'b']
		 ['a', 'd']
		 ['d', 'c', 'b']]
		Example output:
		['c', 'b', 'a', 'b']
	**/
	public static char[] smallestPerRow(char[][] original) {

		//REPLACE WITH YOUR CODE
		char[] newArray = new char[original.length];

		int i = 0;

		for (int r = 0; r < original.length; r++) {

			char smallest = original[r][0];

			for (int c = 0; c < original[r].length; c++) {

				if (original[r][c] < smallest) {
					smallest = original[r][c];
				}
			}
			newArray[i] = smallest;
			i++;
		}
		return newArray;

	}

}
