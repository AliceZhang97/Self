/** 
	 A class to set up the Pokedex list.
	 @author Alice Zhang
**/
import java.util.ArrayList;

public class Pokedex {

	//data member
	private ArrayList<Pokemon> list;

	//constructor
	public Pokedex() {
		this.list = new ArrayList<Pokemon>();
	}

	//method to add a Pokemon into the list
	public void addPokemon(Pokemon pokemon) {
		this.list.add(pokemon);
	}

	//method to return a String that represents the Pokedex
	public String toString() {
		String resultString = "";
		for (Pokemon poke: this.list) {
			resultString = resultString + poke.toString() + "\n";
		}
		return resultString;
	}

	//method to calculate the average height
	public double averageHeight() {
		double totalHeight = 0;
		for (Pokemon poke: this.list) {
			totalHeight = totalHeight + poke.getHeight();
		}
		double averageHei = totalHeight / this.list.size();
		return averageHei;
	}

	//method to calculate the average weight
	public double averageWeight() {
		double totalWeight = 0;
		for (Pokemon poke: this.list) {
			totalWeight = totalWeight + poke.getWeight();
		}
		double averageWei = totalWeight / this.list.size();
		return averageWei;
	}

	//method to calculate the average experience
	public double averageExperience() {
		double totalExperience = 0;
		for (Pokemon poke: this.list) {
			totalExperience = totalExperience + poke.getExperience();
		}
		double averageExp = totalExperience / this.list.size();
		return averageExp;
	}

	//method to return the tallest Pokemon
	public String tallest() {
		int MAX = 0;
		for (int i = 0; i < this.list.size()-1; i++) {
			if (this.list.get(i+1).getHeight() > this.list.get(MAX).getHeight()) {
				MAX = i + 1;
			}
		}
		return list.get(MAX).getSpecies();
	}

	//method to return the smallest Pokemon
	public String smallest() {
		int MIN = 0;
		for (int i = 0; i < this.list.size()-1; i++) {
			if (this.list.get(i+1).getWeight() < this.list.get(MIN).getWeight()) {
				MIN = i + 1;
			}
		}
		return list.get(MIN).getSpecies();
	}

	//method to return all Pokemon with level greater than the level passed as input
	public ArrayList<Pokemon> mostExperienced(int level) {
		ArrayList<Pokemon> result = new ArrayList<>();
		for (Pokemon poke: this.list) {
			if (poke.getExperience() > level) {
				result.add(poke);
			}
		}
		return result;
	}
}
