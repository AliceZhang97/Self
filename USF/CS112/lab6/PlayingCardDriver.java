/**
	Class of PlayingCard Driver.
	@author Alice Zhang
**/
import java.util.ArrayList;
import java.util.Collections;

public class PlayingCardDriver {
	public static void main(String[] args) {

		//new ArrayList of cards
		ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
		//adding elements
		cards.add(new PlayingCard(5, "spade",  "black"));
		cards.add(new PlayingCard(11, "heart", "red"));
		cards.add(new PlayingCard(11, "spade", "black"));
		cards.add(new PlayingCard(7, "diamond", "red"));
		cards.add(new PlayingCard(13, "club", "black"));

		//sort cards
		Collections.sort(cards);

		//display
		for (PlayingCard c : cards) {
			System.out.println(c);
		}
	}
}
