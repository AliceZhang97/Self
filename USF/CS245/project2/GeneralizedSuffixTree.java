/** A class that stores a generalizes suffix tree for a given list of strings and a given  list of terminal markers. */

import java.util.ArrayList;
public class GeneralizedSuffixTree {
	private final static int ASCII = 97;
	private Node root; // the root of the generalized suffix tree
	private ArrayList<String> markers = null; // a list of markers to use after each string
	private ArrayList<String> strings = null; // a list of strings for this generalized suffix tree  - you do not have to use it
	private String concatString = null; // The string that is "all strings concatenated into one"

	public GeneralizedSuffixTree() {
		root = new Node("", -1, 2);
	}

	//helper method to get the markers array
	private ArrayList<String> getMarkers(ArrayList<String> inputMarkers) {
		markers = inputMarkers;
		return markers;
	}

	//helper method to get the strings array
	private ArrayList<String> getStrings(ArrayList<String> inputStrings) {
		strings = inputStrings;
		return strings;
	}

	/** Create a GeneralizedSuffixTree for a given list of strings, with the given terminal markers.
	 *  Size of the markers array should be the same as the strings array */
	public GeneralizedSuffixTree(ArrayList<String> strings, ArrayList<String> markers) {
		// FILL IN CODE
		// Concatenate all strings into one, separated by markers given in the array
		// Iterate backwards over the suffixes of the concatString and call insert on each suffix
		getMarkers(markers);
		getStrings(strings);

		String concatString = "";
		for (int i = 0; i < strings.size(); i++) {
			concatString = concatString + strings.get(i) + markers.get(i);		
		}

		root = new Node("", -1, markers.size());

		for (int k = concatString.length() - 1; k >= 0; k--) {
			insert(concatString.substring(k), k);
		}

	}

	// ------------------ A node of the GeneralizedSuffixTree ------------------------
	private class Node {
		private String string;
		private Node[] children;
		private int index;
		private int numMarkers;
		// private int depth = 0; // you are not required to use it, but might find useful
		
		public Node(String string, int index, int numMarkers) {
			children = new Node[numMarkers + 26]; // 26 letters + however many markers we have
			this.string = string;
			this.index = index;
		}

	} // -----------------------------------------------------------------------

	/** Insert a given suffix into the tree (the suffix starts at index = ind in the concatString */
	public void insert(String word, int ind) {
		root = insert(word.toLowerCase(), ind, root);
	}
		
	/**
	 * Insert a new suffix that starts at index = ind, into the suffix tree with the given root
	 */
	private Node insert(String word, int ind, Node tree) {
		System.out.println("Inserting suffix " + word);
		if (tree == null) {
			Node temp = new Node(word, ind, markers.size());
			return temp;
		}
		// FILL IN CODE

		String inCommon = commonPrefix(tree.string, word);
		if (inCommon != null) {
			if (tree.index != -1) {
				String splitString = tree.string.substring(inCommon.length());
				Node split = new Node(splitString, tree.index, markers.size());
				Node remain = new Node(inCommon, -1, markers.size());
				tree = remain;

				tree.children[getChildIndex(splitString)] = split;
				String newWord = word.substring(inCommon.length());
				tree.children[getChildIndex(newWord)] = insert(newWord, ind, tree.children[getChildIndex(newWord)]);
			} else {
				String newWord = word.substring(inCommon.length());
				tree.children[getChildIndex(newWord)] = insert(newWord, ind, tree.children[getChildIndex(newWord)]);
			}

		} else {
			int childInd = getChildIndex(word);
			tree.children[childInd] = insert(word, ind, tree.children[childInd]);
		}

		
		return tree; // don't forget to change
	}

	/** A helper method: returns the longest common prefix of word1 and word2.
	 *  Example: if word1 = "banana" and word2 = "band", the  longest common prefix is "ban". */
	private String commonPrefix(String word1, String word2) {
		// FILL IN CODE
		if (word1 == "" || word2 == "") {
			return null;
		}

		if (word1.charAt(0) != word2.charAt(0)) {
			return null;
		}

		String shorterWord = "";
		if (word1.length() >= word2.length()) {
			shorterWord = word2;
		} 
		if (word1.length() < word2.length()) {
			shorterWord = word1;
		}
		int i;
		for (i = 0; i < shorterWord.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				break;
			}
		}
		String returnString = shorterWord.substring(0,i);
		
		return returnString; // don't forget to change it
	}

	
	/** Return a suffix tree as a string in human readable form (using preorder traversal and indentations) */
	public String toString() {
		return toString(root, 0);
	}

	/**
	 * A private recursive method that returns the string representation of the suffix tree with the given root
	 * with i indentations.
	 */
	private String toString(Node tree, int i) {
		StringBuilder blr = new StringBuilder();

		// FILL IN CODE
		if (i == 0) {
			blr.append("Root" + "\n");
		} 

		//base case: when the node's index is not -1 (leaf)
		if (tree.index >= 0) {
			String indentation = "";
			for (int k = 0; k < i; k++) {
				indentation = indentation + " ";
			}
			String s = indentation + tree.string + ": " + tree.index + "\n";
			blr.append(s);
		}	

		//recursion:
		int j = 0;
		while (j < (26 + markers.size()) ) {
			if (tree.children[j] != null) {
				if (tree.children[j].index == -1) {
					String spaces = "";
					for (int s = 0; s < i + 1; s++) {
						spaces = spaces + " ";
					}
					String needToAppend = spaces + tree.children[j].string + "\n";
					blr.append(needToAppend + toString(tree.children[j], i+1));
				} else {
					blr.append(toString(tree.children[j], i+1));
				}
			} 
			j++;
		}
		
		return blr.toString();
	}
	
	
	/** Return the index in the children array that corresponds to the first letter of the given word. If 
	 * the first letter is 'a', the method returns 0; if the first letter is 'b', the method returns 1 etc.
	 * Markers are handled separately: the index of the first marker child is 26 (the last one in the array),
	 * the index of the second marker child is 27, etc..
	 * @param word
	 * @return
	 */
	public int getChildIndex(String word) {
		int childIndex = word.charAt(0) - ASCII;
		String s = Character.toString(word.charAt(0));
		int i = markers.indexOf(s);
		if (i != -1 ) // one of the markers
			childIndex = 26 + i;
		return childIndex;
	}
	
	//a helper method to find the deepest nodes
	private ArrayList<Node> findDeepestNodes(Node tree) {
		ArrayList<Node> list = new ArrayList<Node>();
		int i = 0;
		int count = 0;
		while ( i < (26 + markers.size()) ) {
			if (tree.children[i] != null) {
				if (tree.children[i].index == -1) {
					count++;
				}
			}
			i++;
		}
		if (count == 0) {
			list.add(tree);
		}

		int j = 0;
		while (j < (26 + markers.size()) ) {
			if (tree.children[j] != null) {
				if (tree.children[j].index == -1) {
					list.addAll(findDeepestNodes(tree.children[j]));
				}
			}
			j++;
		}
		return list;
	}

	//a helper boolean method that test whether a node contains children strings from all strings
	private boolean includeAll(Node tree) {
		ArrayList<Node> tmp = new ArrayList<Node>();
		int numOfStrings = strings.size();
		int i = 0;
		int count = 0;
		while (i < ( 26 + markers.size() )) {
			if (tree.children[i] != null) {
				tmp.add(tree.children[i]);
				count++;
			}
			i++;
		}
		if (count != numOfStrings) {
			return false;
		}
		else {
			for (int j = 0; j < count; j++) {
				if (j == 0) {
					if (  !( tmp.get(j).index <= strings.get(j).length() ) ) {
						return false;
					}
				}
				else {
					int totalLength = 0;
					for (int k = 0; k < j; k++) {
						totalLength = totalLength + strings.get(j-1).length() + 1;
					}
					if (  !( tmp.get(j).index >= totalLength ) ) {
						return false;
					}
				}
			}
		}
		return true;
	}
	

	/** Return an ArrayList of common longest substrings of the strings in the generalized suffix tree */
	public ArrayList<String> findLCS() {
		ArrayList<String> lcsStrings = new ArrayList<String>();
		// FILL IN CODE
		/*
		ArrayList<Node> deepest = findDeepestNodes(root);

		for (int i = 0; i < deepest.size(); i++) {
			Node current = deepest.get(i);
			if (includeAll(current) == true) {
				//get its path string and add to the list
			} 
		}
		*/
		
		// Note: you will likely write a couple of helper methods for this method
		return lcsStrings;
	}
}