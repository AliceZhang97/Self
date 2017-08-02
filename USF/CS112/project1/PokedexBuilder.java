/** 
	 A class to create new Pokedex from a given CSV file.
	 @author Alice Zhang
**/
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class PokedexBuilder {

	public Pokedex buildPokedex(String filename) {

		Pokedex list = new Pokedex();

		File inputFile = new File(filename);

		try(Scanner input = new Scanner(inputFile)) {
			input.useDelimiter(",|\n");

			//skip the first line
			input.nextLine();

			while(input.hasNext()) {
				input.next();
				String species = input.next();
				input.next();
				int height = input.nextInt();
				int weight = input.nextInt();
				int experience = input.nextInt();
				input.next();
				int favoritecount = input.nextInt();
				boolean favorite;
				if (favoritecount == 1) {
					favorite = true;
				}
				else {
					favorite = false;
				}

				Pokemon pokemon = new Pokemon(species, height, weight, experience, favorite);
				list.addPokemon(pokemon);
			}

		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return null;
		}

		return list;
	}
}
