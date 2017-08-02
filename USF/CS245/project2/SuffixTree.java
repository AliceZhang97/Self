/** Class SuffixTree. Has methods to build a suffix tree for a given string and use it to find suffixes, substrings etc.  
 *  You may add additional helper methods (in fact, it is recommended), but may not change the signatures of the given methods. */
import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.Collections;

public class SuffixTree {
	private Node root; // the root of the suffix tree
	private final static int ASCII = 97; // offset of letter 'a' in the ASCII table

	/** Constructor of SuffixTree. The root contains an empty string and index = -1 */
	public SuffixTree() {
		root = new Node("", -1);
	}

	/** Create a SuffixTree for a given string s.
	 *  Iterate backwards, and call insert method to insert each suffix into the tree. */
	public SuffixTree(String s) {
		String newS = s + "$"; // add $ to the end
		// Iterate backwards and insert into the suffix tree
		// FILL IN CODE
		root = new Node("", -1);

		for (int i = s.length(); i >= 0; i--) {
			insert(newS.substring(i), i);
		}
	}

	// ------------------ Inner class: A node of the SuffixTree ------------------------
	private class Node {
		private String string; // a string stored at the node
		private Node[] children; // an array of children
		private int index; // an index in the original string where this suffix starts

		/** Constructor for Node */
		public Node(String string, int index) {
			children = new Node[27]; // 26 letters + "$"
			this.string = string;
			this.index = index;
		}
	}  // ------------------------------------------------------------------------------

	/** Insert a new suffix (that starts at index ind in the string) into the suffix tree */
	public void insert(String word, int ind) {

		root = insert(word.toLowerCase(), ind, root);
	}

	/**
	 * Insert a new suffix that starts at index = ind, into the suffix tree with
	 * the given root.
	 */
	
	private Node insert(String word, int ind, Node tree) {
		if (tree == null) {
			System.out.println("Created a new node with " + word);
			Node temp = new Node(word, ind);
			return temp;
		}
		// FILL IN CODE - you are required to use the algorithm we discussed in class
		String inCommon = commonPrefix(tree.string, word);
		if (inCommon != null) {
			if (tree.index != -1) {
				String splitString = tree.string.substring(inCommon.length());
				Node split = new Node(splitString, tree.index);
				Node remain = new Node(inCommon, -1);
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

		return tree;
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
	
	/** Return a suffix tree as a string in human readable form (using preorder traversal and indentations). For the root, 
	 * print "Root" instead of an empty string. See project description for details. */
	public String toString() {

		return toString(root, 0);
	}

	/**
	 * A private recursive method that returns the string representation of the suffix tree with the given root
	 * with i indentations. If i = 0, the value at the root should not be indented. 
	 * If i = 1, there should be one space printed before the value at the root.
	 * If i = 2, there should be two spaces etc..
	 * Hint: Use StringBuilder or StringBuffer (using "+" for concatenation is very slow).
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
		while (j < 27) {
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
	
	/** Return an index in the array of children that corresponds to the first letter of the given word. If 
	 * the first letter is 'a', the method returns 0; if the first letter is 'b', the method returns 1 etc.
	 * '$' is handled separately: the index of the '$' child is 26 (the last one in the array).
	 * @param word
	 * @return
	 */
	public int getChildIndex(String word) {
		int childIndex = word.charAt(0) - ASCII;
		if (word.charAt(0) == '$')
			childIndex = 26;
		return childIndex;
	}

	
	/**
	 * Return true if a string represented by a given suffix tree contains a given
	 * word. Return false otherwise.
	 */
	public boolean containsSubstring(String word) {

		return containsSubstring(word, root);
	}
	
	/**
	 * Return true if a string represented by the suffix tree with the given root,
	 * contains a given word. Return false otherwise. 
	 * Should be recursive and make use of the suffix tree.
	 */
	private boolean containsSubstring(String word, Node tree) {
		// FILL IN CODE
		
		String inCommon = commonPrefix(tree.string, word);

		//base case: 
		if (inCommon != null && inCommon.equals(word)) {
			return true;
		}
		if (word.equals(tree.string)) {
			return true;
		}

		else {
			if (inCommon != null) {
				String newWord = word.substring(inCommon.length());
				int i = 0;
				while (i < 27) {
					if (tree.children[i] != null) {
						if (tree.children[i].string.charAt(0) == newWord.charAt(0)) {
							return containsSubstring(newWord, tree.children[i]);
						}
					}
					i++;
				}
			}
			int j = 0;
			while (j < 27) {

				if (tree.children[j] != null) {
					if (tree.children[j].string.charAt(0) == word.charAt(0)) {
						return containsSubstring(word, tree.children[j]);
					}
				}
				
				j++;
			}
		}
		return false;
	
	}

	//a helper method that gives a list of index that contains in a certain node
	private List<Integer> getAllIndex(Node tree) {
		List<Integer> allIndex = new ArrayList<Integer>();
		if (tree.index >= 0) {
			allIndex.add(tree.index);
		}

		else if (tree.index == -1) {
			int i = 0;
			while (i < 27) {
				
				if (tree.children[i] != null) {

					allIndex.addAll(getAllIndex(tree.children[i]));
				}
				i++;
			}
		}

		return allIndex;
	}
	
	/**
	 * Check if a string represented by a given suffix tree contains a given
	 * word, and if yes, return the list of indices where each occurrence of word starts. 
	 * Should be sorted in ascending order.
	 * Example: if the suffix tree is built for the word "banana" and we call this method on "ana",
	 * the method should return [1, 3]. 
	 */
	
	public List<Integer> getSubstringIndices(String word) {

		List<Integer> indicesOccurrences = getSubstringIndices(word, root);
		return indicesOccurrences;
	}

	/**
	 * Check if a string represented by the suffix tree with the given root,
	 * contains a given word. Return the List of indices where the
	 * substring occurrences start. Should be recursive and make use of the suffix tree.
	 */

	private List<Integer> getSubstringIndices(String word, Node tree) {
		
		List<Integer> indices = new ArrayList<Integer>();
		// FILL IN CODE
		if (tree.index != -1) {
			indices.add(tree.index);
		}
		else {
			int childInd = getChildIndex(word);

			if (tree.children[childInd] != null) {
				String inCom = commonPrefix(word, tree.children[childInd].string);
				String check = word.substring(inCom.length());
				if (word.equals(tree.children[childInd].string) || check.length() == 0) {
					List<Integer> aList = getAllIndex(tree.children[childInd]);
					for (int a : aList) {
						indices.add(a);
					}
				}
				else if (containsSubstring(word)) {
					String inCommon = commonPrefix(word, tree.children[childInd].string);
					if (inCommon != null) {

						String newWord = word.substring(inCommon.length());
						return getSubstringIndices(newWord, tree.children[childInd]);
					}
				}
			}
		}
		//sort the list
		Collections.sort(indices);
		
		return indices; 
	}	

	
	/**
	 * Return the number of occurrences of a given word in the string, represented by the suffix tree
	 */
	public int numOccurrences(String word) {
		// FILL IN CODE
		// Hint: you can call getSubstringIndices method you wrote above
		
		List<Integer> arrList = getSubstringIndices(word);
		int num = arrList.size();
		
		return num; 
	}
	
	
	/** If the suffix tree contains a given suffix, return the index where it starts in the original string, 
	 * otherwise return -1.  */
	public int containsSuffix(String suffix) {
		return containsSuffix(suffix, root);
		
	}

	/** If a given suffix tree contains a given suffix, return its' index, otherwise return -1. 
	 * Should be recursive and make use of the suffix tree. */
	private int containsSuffix(String suffix, Node tree) {
		// FILL IN CODE

		//base case:

		if (tree.index >= 0) {
			return tree.index;
		}
		if (suffix.length() == 0) {
			return -1;
		}

		int suffixInd = getChildIndex(suffix);
		if (tree.children[suffixInd] != null) {
			String childreString = tree.children[suffixInd].string;
			String inCommon = commonPrefix(suffix, childreString);
			if (inCommon != null) {
				if (childreString.substring(inCommon.length()).length() == 0) {
					String newSuffix = suffix.substring(inCommon.length());
					return containsSuffix(newSuffix, tree.children[suffixInd]);
				}
			}
		}

		return -1; 
		
	}
}