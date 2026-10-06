/*
 *	Author:  
 *  Date: 
*/

import java.util.Scanner;
import java.util.Random;

class starter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = "";
		name = sc.nextLine();
		System.out.println("Choose a class. Wizard, Warrior, or Rogue.");
		String role = "";
		role = sc.nextLine();

		if(role.equalsIgnoreCase("Wizard") || role.equalsIgnoreCase("Warrior") || role.equalsIgnoreCase("Rogue")){
			System.out.println("Great! You chose the " + role + " role!");
		}
		else{
			System.out.println(role + " isn't a role. Try again.");
		}
		
		int strength = 0;
		int dexterity = 0;
		int intelligence = 0;
		int charisma = 0;

		int cstrength = 0;
		int cdexterity = 0;
		int cintelligence = 0;
		int ccharisma = 0;

		int points = 20;
		System.out.println("You have 20 points.");
		System.out.println("How many points would you like to spend on strength?");
		cstrength = sc.nextInt();
		if(cstrength <= points && cstrength <= 10){
			strength = strength + cstrength;
			points = points - cstrength;
		}
		else{
			System.out.println("You don't have that many points. Set strength to 0 and moving on...");
		}
		
		System.out.println("You have " + points + " points.");
		System.out.println("How many points would you like to spend on dexterity?");
		cdexterity = sc.nextInt();
		if(cdexterity <= points && cdexterity <= 10){
			dexterity = dexterity + cdexterity;
			points = points - cdexterity;
		}
		else{
			System.out.println("You don't have that many points. Set dexterity to 0 and moving on...");
		}

		System.out.println("You have " + points + " points.");
		System.out.println("How many points would you like to spend on intelligence?");
		cintelligence = sc.nextInt();
		if(cintelligence <= points && cintelligence <= 10){
			intelligence = intelligence + cintelligence;
			points = points - cintelligence;
		}
		else{
			System.out.println("You don't have that many points. Set intelligence to 0 and moving on...");
		}

		System.out.println("You have " + points + " points.");
		System.out.println("How many points would you like to spend on charisma?");
		ccharisma = sc.nextInt();
		if(ccharisma <= points && ccharisma <= 10){
			charisma = charisma + ccharisma;
			points = points - ccharisma;
		}
		else{
			System.out.println("You don't have that many points. Set charisma to 0 and moving on...");
		}
		System.out.println("Here are your stats: ");
		System.out.println("Name: " + name);
		System.out.println("Role: " + role);
		System.out.println("Strength: " + strength);
		System.out.println("Dexterity: " + dexterity);
		System.out.println("Intelligence: " + intelligence);
		System.out.println("Charisma: " + charisma);
		if(points > 0){
			System.out.println("Unspent points: " + points);
		}

	}
}