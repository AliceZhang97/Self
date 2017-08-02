/**
	A class to set up PlayingCard.
	@author Alice Zhang
**/

public class PlayingCard implements Comparable<PlayingCard> {

	//properties
	private int value;
	private String suit;
	private String color;

	//getters
	public int getValue() {
		return this.value;
	}
	public String getSuit() {
		return this.suit;
	}

	//toString method
	public String toString() {
		String returnValue = "";
		if (this.getValue() == 11) {
			returnValue = returnValue + "Jack";
		}
		if (this.getValue() == 12) {
			returnValue = returnValue + "Queen";
		}
		if (this.getValue() == 13) {
			returnValue = returnValue + "King";
		}
		if (this.getValue() != 11 && this.getValue() != 12 && this.getValue() != 13) {
			returnValue = returnValue + this.value;
		}
		return "Value: " + returnValue + " Suit: " + this.suit + " Color: " + this.color;
	}

	//compareTo method
	public int compareTo(PlayingCard other) {

		int c;

		if(this.value == other.value) {
			return this.suit.compareTo(other.getSuit());
		}
		else if(this.value < other.value) {
			c = -1;
		} else {
			c = 1;
		}
		return c;
	}

	//constructor
	public PlayingCard(int value, String suit, String color) {
		this.value = value;
		this.suit = suit;
		this.color = color;
	}
}

