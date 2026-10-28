/*
 *	Author:
 *  Date:
 * 	Collaborator(s):
*/
import pkg.*;
import java.util.Scanner;
import java.util.Random;

class starter {
	public static void main(String args[]) {
		Spiderman tobeyMaguire = new Spiderman("Tobey Maguire", 48, "Green Goblin");
		tobeyMaguire.getActor();
		tobeyMaguire.getAge();
		tobeyMaguire.getVillain();

		Spiderman andrewGarfield = new Spiderman("Andrew Garfield", 40, "Electro");
		andrewGarfield.getActor();
		andrewGarfield.setAge(40);
		andrewGarfield.getAge();
		andrewGarfield.getVillain();

		Spiderman tomHolland = new Spiderman("Tom Holland", 20, "The Vulture");
		tomHolland.getActor();
		tomHolland.setAge(27);
		tomHolland.getAge();
		tomHolland.getVillain();

		Spiderman randomGuy = new Spiderman("Random Guy", 20, "Random EVIL Guy");
		randomGuy.getActor();
		randomGuy.setAge(1000);
		randomGuy.getAge();
		randomGuy.getVillain();
		
		tobeyMaguire.fight();
		tobeyMaguire.printArt();

		andrewGarfield.fight();
		andrewGarfield.printArt();

		tomHolland.fight();
		tomHolland.printArt();

		randomGuy.fight();
		randomGuy.printArt();

		
	}
}
