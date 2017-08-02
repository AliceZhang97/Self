/*
	A driver class of the Pokemon class.
	@ author Alice Zhang
*/

public class PokemonDriver {

	public static void main(String[] args) {


		Pokemon p1 = new Pokemon("Pikachu",114,true);

		Pokemon p2 = new Pokemon("Jigglypuff",58,false);

		Pokemon p3 = new Pokemon("Arcanine",100);

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	}
} 
