/**
	A class providing ArrayList-like functionality for a list of String objects.
	@author Alice Zhang
**/
public class StringList {

	//declare data members to hold an array of strings and an
	//int to keep track of the number of items in the list
	private String[] strings;
	private int count;

	/**
		A constructor that takes no input and instantiates a new
		String[] of size 10.
	**/
	public StringList() {
		strings = new String[10];
		count = 0;
	}

	/**
		A constructor that takes a size and instantiates a new
		String[] of size size.
	**/
	public StringList(int size) {
		strings = new String[size];
		count = 0;
	}

	/**
		Adds the new item s to the end of the array 
		and returns true. In case the array is full, 
		it will be resized by creating new array of 
		twice the size and copying all elements to 
		the new array.
	**/

	//method to resize the array
	private void resize() {

		String[] newArray = new String[strings.length * 2];
		
		for (int i = 0; i < strings.length; i++) {
			newArray[i] = strings[i];
		}

		strings = newArray;
	}

	//method to add new item to the end of the array
	public boolean add(String s)  {

		if(count >= strings.length) {
			resize();
		}

		strings[count] = s;
		count++;
		return true;
	}
	/**
		Adds the new item to the array at the location 
		specified by index, in case the array is full, 
		it will be resized by creating new array of 
		twice the size and copying all elements to the
		new array.
		Will throw an IndexOutOfBoundsException if the 
		index is out of range.
	**/
	public void add(int index, String s) {

		if(count >= strings.length) {
			resize();
		}

		if (index < count+1 && index >= 0) {
			for (int i = count; i > index; i--) {
				strings[i] = strings[i-1];
			}
			strings[index] = s;
			count++;

		} else {
			try {
				throw new IndexOutOfBoundsException("Error message - index too large");
			} catch (IndexOutOfBoundsException exp) {
				System.out.println(exp.getMessage());
			}
		}
	}

	/**
		Returns true if the array contains the string s
		and false otherwise.
	**/
	public boolean contains(String s) {

		int coantainCount = 0;

		for (int i = 0; i < count; i++) {
			if (strings[i] == s) {
				coantainCount += 1;
			}
		}

		if (coantainCount > 0) {
			return true;
		}

		else {
			return false;
		}
	}

	/**
		Returns true if there are no elements in the array
		and false otherwise.
	**/
	public boolean isEmpty() {

		if (count < 1) {
			return true;
		}

		else {
			return false;
		}
	}

	/**
		Returns the number of elements in the array. Note this
		is not the total number of spaces in the array, but 
		the total number of valid elements.
	**/
	public int size() {

		if (count > 0) {
			return count;
		}

		else {
			return 0;
		}
	}

	/**
		Returns the first index of the given String,
		or -1 if not found.
	**/
	public int indexOf(String s) {

		int getIndex = 0;

		for (int i = 0; i < count; i++) {
			if (strings[i] == s) {
				getIndex = i;
				break;
			}
			else {
				getIndex = -1;
			}
		}
		return getIndex;
	}

	/**
		Returns the last index of the given String, 
		or -1 if not found.
	**/
	public int lastIndexOf(String s) {

		int getIndex = 0;

		for (int i = count; i >= 0; i--) {
			if (strings[i] == s) {
				getIndex = i;
				break; 
			}

			else {
				getIndex = -1;
			}
		}
		return getIndex;
	}

	/**
		Returns the String at the given index, 
		may throw IndexOutOfBounds exception.
	**/
	public String get(int index) {

		String returnValue = "";

		if (index < count && index >= 0) {

			returnValue = returnValue = strings[index];

		} else {
			try {
				throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
			} catch (IndexOutOfBoundsException exp) {
				System.out.println(exp.getMessage());
			}
		}
		return returnValue;

	}

	/**
		Replaces the element at index with the given string. 
		May throw IndexOutOfBounds exception.
		Returns the item replaced.
	**/	
	public String set(int index, String s) {

		String returnValue = "";

		if (index < count && index >= 0) {

			returnValue = strings[index];
			strings[index] = s;

		} else {
			try {
				throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
			} catch (IndexOutOfBoundsException exp) {
				System.out.println(exp.getMessage());
			}
		}
		return returnValue;
	}

	/**
		Removes the item at the given index and returns it.
		May throw IndexOutOfBounds exception.
	**/
	public String remove(int index) {

		String returnValue = "";

		if (index >= 0 && index < count) {

			returnValue = returnValue + strings[index];

			for (int i = index; i < count; i++) {
				strings[i] = strings[i+1];
			}

			count--;

		} else {
			try {
				throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
			} catch (IndexOutOfBoundsException exp) {
				System.out.println(exp.getMessage());
			}
		}
		return returnValue;
	}

	/**
		Removes the given item, returns true if successful
		and false otherwise.
	**/
	public boolean remove(String s) {

		String valueRemove = "";
		int indexRemove = -1;

		for (int i = 0; i < count; i++) {

			if (strings[i] == s) {
				indexRemove = i;
				strings[i] = valueRemove;
			}
		}

		if (indexRemove != -1) {
			return true;
		}

		else {
			return false;
		}
	}

	/**
		Returns a string representation of the array.
		Following is an example of the expected format:
		{A, B, C, D, E}
	**/
	public String toString() {
		String returnValue = "";
		if (count > 0) {

			for (int i = 0; i < count-1; i++) {
				returnValue = returnValue + strings[i] + ", ";
			}

			returnValue = "{" + returnValue + strings[count - 1] + "}";
		}

		else {
			returnValue = returnValue + "{}";
		}
		return returnValue;
	}

}
