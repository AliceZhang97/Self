

/**
 * A class that stores movie ratings for a user in a custom singly linked list of
 * MovieRatingNode objects. Has various methods to manipulate the list. Stores
 * only the head of the list (no tail!). The list should be sorted by
 * rating (from highest to smallest).
 */
import java.util.Iterator;

import java.util.HashMap;

public class MovieRatingsList implements Iterable<MovieRatingNode> {

	// FILL IN CODE: store the head of the list
	private MovieRatingNode head = null;

	/** A getter for the head variable */
	public MovieRatingNode head() {
		return head;
	}

	/**
	 * Return the reference to the node that contains the given movie title or
	 * null if such node does not exit.
	 * 
	 * @param movieTitle
	 * @return
	 */
	public MovieRatingNode find(String movieTitle) {
		MovieRatingNode current = head;
		while ( !(current.getMovieTitle()).equals(movieTitle) && (current.next() != null) ) {
			current = current.next();
		}
		return current;
	}

	/**
	 * Return the rating for a given movie. If the movie is not in the list,
	 * return -1.
	 */
	public int getRating(String movieTitle) {
		MovieRatingNode current = head;
		while ( !(current.getMovieTitle()).equals(movieTitle) ) {
			current = current.next();
		}
		return current.getMovieRating();
	}

	/**
	 * Create a new node with the given movie and rating, and appends it at the
	 * end of the array
	 * 
	 * @param movie
	 * @param rating
	 */
	public void append(String movie, int rating) {
		MovieRatingNode newNode = new MovieRatingNode(movie, rating);
		MovieRatingNode current = head;
		if (head == null) {
			head = newNode;
		} else {
			while (current.next() != null) {
				current = current.next();
			}
			current.setNext(newNode);
		}
	}

	/**
	 * Insert a new node (with a given movie and a given rating) into the list.
	 * Insert it in the right place based on the value of the rating. Assume the
	 * list is sorted by the value of ratings, from highest to smallest. The
	 * list should remain sorted after this insert operation.
	 */
	public void insertByRating(String movie, int rating) {
		// insert a node into the sorted list
		MovieRatingNode newNode = new MovieRatingNode(movie, rating);

		//when the list is empty
		if (head == null) {
			head = newNode;
		}
		//when the list has one node
		else if (head.next() == null) {
			if (rating >= head.getMovieRating()) {
				newNode.setNext(head);
				head = newNode;
			} else {
				head.setNext(newNode);
			}
		}
		//when the list has more than one node
		else {
			if (rating >= head.getMovieRating()) {
				newNode.setNext(head);
				head = newNode;
			} else {
				MovieRatingNode current = head.next();
				MovieRatingNode previous = head;
				while (current.next() != null) {
					if (current.getMovieRating() > rating) {
						current = current.next();
						previous = previous.next();
					} else {
						break;
					}
				}
				if (current.next() == null && current.getMovieRating() > rating) {
					current.setNext(newNode);
				} else {
					newNode.setNext(current);
					previous.setNext(newNode);
				}
			}
		}	
	}

	/**
	 * Change the rating for a given movie to newRating.The position of the node
	 * within the list should be changed accordingly, so that the list remains
	 * sorted by rating (from largest to smallest).
	 * 
	 * @param movieTitle
	 * @param newRating
	 */
	public void setRating(String movieTitle, int newRating) {
		MovieRatingNode current = head;
		while ( !current.getMovieTitle().equals(movieTitle) ) {
			current = current.next();
		}
		current.setMovieRating(newRating);

		//save the temperary removed node
		MovieRatingNode temRemovedNode = current;
		String temTitle = current.getMovieTitle();
		int temRating = current.getMovieRating();

		MovieRatingNode previous = head;
		while ( !previous.next().equals(current) ) {
			previous = previous.next();
		}
		previous.setNext(current.next());
		insertByRating(temTitle, temRating);
	}

	/**
	 * Compute the cosine similarity between two lists of ratings. Note: You are
	 * allowed to use a HashMap for this method.
	 */
	public double computeSimilarity(MovieRatingsList otherList) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		MovieRatingNode current = head;
		//iterate the first time, map movies to ratings
		while (current != null) {
			if ( !result.containsKey(current.getMovieTitle()) ) {
				String s = current.getMovieTitle();
				int i = current.getMovieRating();
				result.put(s,i);
			} 
			current = current.next();
		}

		//iterate the second time
		//get dot product
		int dotProduct = 0;
		for (String key : result.keySet()) {
			MovieRatingNode pointer = otherList.head();
			while (pointer != null) {
				if ( !key.equals(pointer.getMovieTitle()) ) {
					pointer = pointer.next();
				} else {
					break;
				}
			}
			if (pointer != null) {
				int tem = result.get(key) * pointer.getMovieRating();
				dotProduct = dotProduct + tem;
			} 
		}

		//get length 
		double length1 = 0.0;
		for (String key : result.keySet()) {
			int num = result.get(key);
			length1 = length1 + (num * num);
		}
		length1 = Math.sqrt(length1);

		double length2 = 0.0;
		MovieRatingNode pointer2 = otherList.head();
		while (pointer2 != null) {
			int num = pointer2.getMovieRating();
			length2 = length2 + (num * num);
			pointer2 = pointer2.next();
		}
		length2 = Math.sqrt(length2);

		//get cosine similarity
		double cosineSimilarity = dotProduct / (length1 * length2);

		return cosineSimilarity;

	}

	/**
	 * Return a sublist of this list where the rating values are in the range
	 * from begRating to endRating, inclusive.
	 */
	public MovieRatingsList sublist(int begRating, int endRating) {
		MovieRatingsList res = new MovieRatingsList();
		/*
		//check the given begRating and endRating
		if (endRating > begRating) {
			return null;
		}
		*/

		//find the begining of the sublist
		MovieRatingNode current = head;
		while (current != null) {
			if ( current.getMovieRating() != begRating ) {
				current = current.next();
			} else {
				break;
			}
		}
		//find the ending of the sublist
		while (current.next() != null) {
			if ( current.next().getMovieRating() >= endRating ) {
				res.append(current.getMovieTitle(), current.getMovieRating());
				current = current.next();
			} else {
				break;
			}
		}
		if (current.next() == null && current.getMovieRating() == endRating) {
			res.append(current.getMovieTitle(), current.getMovieRating());
		}

		return res;
	}

	//a private method that provides the number of movie ratings
	private int numOfRatings() {
		MovieRatingNode current = head;
		int num = 0;
		while (current != null) {
			current = current.next();
			num++;
		}
		return num;
	}

	/**
	 * Return an array of movie titles from the ratings list. The movie title
	 * should be in the array in the same order in which they were in the
	 * ratings list. (ordered by ratings, not titles)
	 */
	public String[] getTitles() {
		MovieRatingNode current = head;
		int num = numOfRatings();
		String[] titles = new String[num];
		int i = 0;
		while (current != null) {
			titles[i] = current.getMovieTitle();
			current = current.next();
			i++;
		}
		return titles;
	}

	/** Traverse the list and print info about each node */
	public void print() {
		MovieRatingNode current = head;
		if (current == null) {
			System.out.println("no element");
		} else {
			while (current != null) {
				System.out.println(current.toString());
				current = current.next();
			}
		}
	}

	/**
	 * Returns the middle node in the list - the one half way into the list.
	 * Needs to have the running time O(n), should be done in one pass. Hint:
	 * Use slow and fast pointers.
	 * 
	 * @return
	 */
	public MovieRatingNode getMiddleNode() {
		MovieRatingNode slow = head;
		MovieRatingNode fast = head;
		while (fast.next() != null) {
			fast = fast.next().next();
			slow = slow.next();
		}
		return slow;
	}

	/**
	 * Return the median rating (the number that is halfway into the sorted
	 * list). To compute it, find the middle node and return it's rating. If the
	 * middle node is null, return -1.
	 */
	public int getMedianRating() {
		MovieRatingNode slow = head;
		MovieRatingNode fast = head;
		while (fast.next() != null) {
			fast = fast.next().next();
			slow = slow.next();
		}
		if (slow == null) {
			return -1;
		} else {
			return slow.getMovieRating();
		}
	}

	/**
	 * Return a MovieRatingsList that contains n best rated movies. These are
	 * the first n movies from the beginning of the list. If the list is
	 * shorter than size n, it will return the whole list.
	 */
	public MovieRatingsList getNBestRankedMovies(int n) {
		MovieRatingsList result = new MovieRatingsList();
		MovieRatingNode current = head;
		int i = 1;
		while ( (i <= n) && (current != null) ) {
			result.append(current.getMovieTitle(), current.getMovieRating());
			current = current.next();
			i++;
		}
		return result;
	}

	/**
	 * Return a MovieRatingsList that contains n worst rated movies for this user.
	 * These are the last n movies from the end of the list. Use slow & fast
	 * pointers to find the n-th node from the end (required). Note: This method
	 * should compute the result in one pass. Do NOT use reverse().
	 */
	public MovieRatingsList getNWorstRankedMovies(int n) {
		MovieRatingsList result = new MovieRatingsList();

		MovieRatingNode p1 = head; //slow pointer
		MovieRatingNode p2 = head; //fast pointer
		int i = 0;
		//first move p2
		while (i < n) {
			p2 = p2.next();
			i++;
		}
		//move them together
		while (p2 != null) {
			p1 = p1.next();
			p2 = p2.next();
		}
		while (p1 != null) {
			result.append(p1.getMovieTitle(), p1.getMovieRating());
			p1 = p1.next();
		}
		return result;
	}

	/**
	 * Return a new list that is the reverse of the original list.
	 */
	public MovieRatingsList reverse(MovieRatingNode h) {
		MovieRatingsList r = new MovieRatingsList();
		MovieRatingNode current = head;
		MovieRatingNode pointer = null;
		while (pointer != head) {
			while (current.next() != pointer) {
				current = current.next();
			}
			pointer = current;
			r.append(current.getMovieTitle(), current.getMovieRating());
			current = head;
		} 
		return r;
	}

	/** Return an iterator that allows to traverse the list */
	@Override
	public Iterator<MovieRatingNode> iterator() {
		return new RatingsListIterator(0);
	}

	/**
	 * The inner class that represents the iterator for the movie ratings list.
	 * Iterates over the MovieRatingNode-s of the list.
	 */
	private class RatingsListIterator implements Iterator<MovieRatingNode> {

		MovieRatingNode curr = null;

		public RatingsListIterator(int index) {
			curr = head;
			for (int i = 0; i < index; i++) {
				curr = curr.next();
			}
		}

		@Override
		public boolean hasNext() {
			return curr != null; 
		}

		@Override
		public MovieRatingNode next() {
			if (!hasNext()) {
				System.out.println("No next element.");
				return null;
			}
			MovieRatingNode oldCurr = curr;
			curr = curr.next();
			return oldCurr; 
		}

	}

}
