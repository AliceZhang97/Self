import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.lang.*;

import java.io.PrintWriter;

/**
 * A custom linked list that stores user info. Each node in the list is of type
 * UserNode.
 * 
 * @author okarpenko
 *
 */
public class UsersList {
	private UserNode head = null; // head of the list
	private UserNode tail = null; // tail of the list

	/** A default constructor */
	public UsersList() {
	}

	/** A getter for the head */
	public UserNode head() {
		return head;
	}

	/** A getter for the tail */
	public UserNode tail() {
		return tail;
	}

	/** Add a new node to the end of list */
	public void append(UserNode newNode) {
		if (head == null) {
			head = newNode;
			tail = head;
			return;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	/** Return a UserNode that contains a given userId */
	public UserNode get(int userId) {
		if (head == null) {
			return null;
		}
		else {
			UserNode current = head;
			while (current != null) {
				if (current.getId() != userId) {
					current = current.next();
				} else {
					break;
				}
			}
			while ( current.getId() != userId ) {
				if (current.next() == null && current.getId() != userId) {
					return null;
				}
				current = current.next();
			}
			return current;
		}
	}

	/**
	 * Read user ratings from the file and save data for each user in this list.
	 * For each user, the movie ratings list will be sorted by rating (from
	 * largest to smallest).
	 */
	public void loadUserInfo(String filename) {
	
		//read the file
		File inputFile = new File(filename);
		try(Scanner input = new Scanner(inputFile)) {
			while (input.hasNextLine()) {
				String line = input.nextLine();
				int userId = 0;
				int numofRatings = 0;
				//check if the line contains user id
				if (!line.contains(";")) {
					String[] var = line.split(" ");
					userId = Integer.parseInt(var[0]);
					numofRatings = Integer.parseInt(var[1]);
					//if it contains user id, create a new MovieRatingsList
					MovieRatingsList mrList = new MovieRatingsList();
					for (int i = 0; i < numofRatings; i++) {
						String line2 = input.nextLine();
						String[] var2 = line2.split("; ");
						String movieTitle = var2[0];
						int movieRating = Integer.parseInt(var2[1]);
						//store ratings into mrList
						mrList.insertByRating(movieTitle, movieRating);
					}
					//store every userNode
					UserNode newNode = new UserNode(userId, mrList);
					append(newNode);
					//skip the empty line
					if (input.hasNextLine()) {
						input.nextLine();
					}
				}
			}
		} catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return;
		}
	}
	

	/**
	 * Compute the similarity between the user with the given userId and all the
	 * other users. Finds the maximum similarity and returns the
	 * "most similar user".
	 */
	public UserNode findMostSimilarUser(int userid) {
		UserNode tem = get(userid);
		UserNode current = head;
		UserNode returnNode = head;
		double max = 0.0;
		while (current != null) {
			if (current.getId() != userid && current.next() != null) {
				double value = tem.computeSimilarity(current);
				if (value > max) {
					max = value;
					returnNode = current;
				}
				current = current.next();
			}
			current = current.next();
		}
		return returnNode;
	}

	/**
	 * Compute up to num movie recommendations for the user with the given user
	 * id and print these movie titles to the file with the given name. First
	 * calls findMostSimilarUser and then getFavoriteMovies(num) method on the
	 * "most similar user" to get up to num recommendations.
	 */
	public void findRecommendations(int userid, int num, String filename) {
		// -Compute similarity between userid and all the other users
		// -Find the most similar user and recommend movies that the most similar
		// user rated as 5. 
		// - Recommend only the movies that userid has not seen (has not
		// rated).

		UserNode tem = findMostSimilarUser(userid);

		//temporary array that stores 5 favorite movies
		String[] temArray = tem.getFavoriteMovies(num);

		//array that contains all movie titles that the user have seen
		String[] a = get(userid).getMovies();

		//updated array that will only contain the movies in the temArray that the user have not seen before
		String[] updatedArray = new String[5];

		//set a boolean value
		boolean contains = false;
		int i = 0;
		for (String s1 : temArray) {
			for (String s2 : a) {
				if (s1.equals(s2)) {
					//this movie should not be recommended
					contains = true;
					break;
				}
			}
			if (!contains) {
				updatedArray[i] = s1;
				i++;
			} 
			else {
				contains = false;
			}
		}

		//print valid movies to the file 
		try {
			PrintWriter printWriter = new PrintWriter(filename);
			for (String s : temArray) {
				printWriter.println(s);
			}
			printWriter.flush();
			printWriter.close(); 
		} catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return;
		}
	}

	/**
	 * Compute up to num movie anti-recommendations for the user with the given
	 * user id and print these movie titles to the given file. These are the
	 * movies the user should avoid. First calls findMostSimilarUser and then
	 * getLeastFavoriteMovies(num) method on the "most similar user" to get up
	 * to num movies the most similar user strongly disliked.
	 */
	public void findAntiRecommendations(int userid, int num, String filename) {
		UserNode tem = findMostSimilarUser(userid);

		//temporary array that stores 5 least favorite movies
		String[] temArray = tem.getLeastFavoriteMovies(num);

		//array that contains all movie titles that the user have seen
		String[] a = get(userid).getMovies();

		//updated array that will only contain the movies in the temArray that the user have not seen before
		String[] updatedArray = new String[5];

		boolean contains = false;
		int i = 0;
		for (String s1 : temArray) {
			for (String s2 : a) {
				if (s1.equals(s2)) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				updatedArray[i] = s1;
				i++;
			} 
			else {
				contains = false;
			}
		}
		//print valid movies to a file
		try {
			PrintWriter printWriter = new PrintWriter(filename);
			for (String s : updatedArray) {
				if (s != null) {
					printWriter.println(s);
				}
			}
			printWriter.flush();
			printWriter.close(); 
		} catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return;
		}
	}

	/**
	 * Return an array that contains the highest rated movie for each user.
	 * Since the MovieRatingsList is sorted from highest rated movie to lowest, to
	 * implement this method, you just need to traverse the list of user nodes,
	 * and for each user, get the first movie from their ratings list.
	 * 
	 * @return
	 */
	public String[] findFavoriteMoviesForAll() {
		//get the number of users
		UserNode current = head;
		int num = 0;
		while (current != null) {
			num++;
			current = current.next();
		}

		//create a return array
		String[] returnArray = new String[num];
		current = head;
		int i = 0;
		while (current != null) {
			String title = current.getMovies()[0];
			returnArray[i] = title;
			current = current.next();
			i++;
		}
		return returnArray;

	}
}
