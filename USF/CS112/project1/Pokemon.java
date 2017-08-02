/**
	A class to set up the Pokemon.
	@author Alice Zhang
**/

public class Pokemon {
	
	//data members
	private String species;
	private int height;
	private int weight;
	private int experience;
	private boolean favorite;

	//get-methods
	public String getSpecies() {
		return this.species;
	}
	public int getHeight() {
		return this.height;
	}
	public int getWeight() {
		return this.weight;
	}
	public int getExperience() {
		return this.experience;
	}
	public boolean getFavorite() {
		return this.favorite;
	}

	//toString method
	public String toString() {
		String returnValue = this.species + "(" + this.height + ", " + this.weight + ") with experience " + this.experience + " - ";
		if (this.favorite) {
			returnValue = returnValue + "Starred";
		}
		else {
			returnValue = returnValue + "Not Starred";
		}
		return returnValue;
	}

	//constructor 
	public Pokemon(String species, int height, int weight, int experience, boolean favorite) {
		this.species = species;
		this.height = height;
		this.weight = weight;
		this.experience = experience;
		this.favorite = favorite;
	}
}
