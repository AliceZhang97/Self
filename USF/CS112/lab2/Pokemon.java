/* 
	A class to set up the Pokemon.
	@ author Alice Zhang
*/

public class Pokemon {
	
	// data members 
	private String species;
	private int experience;
	private boolean favorite;

	// getters
	public String getSpecies() {
		return this.species;
	}
	public int getExperience() {
		return this.experience;
	}
	public boolean getFavorite() {
		return this.favorite;
	}

	// setters
	public void setSpecies(String species) {
		this.species = species;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	// toString method
	public String toString() {
		String returnValue = this.species + " with Experience " + this.experience + " - ";
		if (this.favorite) {
			returnValue = returnValue + "Starred";
		}
		else {
			returnValue = returnValue + "Not Starred";
		}
		return returnValue;
	}

	// constructor (1)
	public Pokemon(String species, int experience, boolean favorite) {
		this.species = species;
		this.experience = experience;
		this.favorite = favorite;
	}

	// constructor (2)
	public Pokemon(String species, int experience) {
		favorite = false;
		this.species = species;
		this.experience = experience;
	}
}
