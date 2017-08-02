/**
	A class to build a list of Pokemon, desplay all pokemon information,
	and display some calculations based on the information.
	@author Alice Zhang
**/

public class PokemonDriver {
	public static void main(String[] args) {

		PokedexBuilder builder = new PokedexBuilder();
		if (args.length != 1) {
			System.out.println("Error.");
			System.exit(0);
		}

		Pokedex list = builder.buildPokedex(args[0]);

		//display all Pokemon
		System.out.println("All Pokemon:\n");
		System.out.println(list.toString());

		//desplay the calculations
		System.out.println("Average height: " + list.averageHeight());
		System.out.println("Average weight: " + list.averageWeight());
		System.out.println("Average experience: " + list.averageExperience());
		System.out.println("Species of Tallest: " + list.tallest());
		System.out.println("Species of Smallest: " + list.smallest());
		System.out.println("Pokemon with experience greater than 200:");
		for (Pokemon poke: list.mostExperienced(200)) {
			System.out.println(poke.toString());
		}
	}
}
