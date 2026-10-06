/*
 *	Author:  
 *  Date: 
*/

import java.util.Scanner;
import java.util.Random;

class starter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a class. Wizard, Warrior, or Rogue.");
		String role = "";
		role = sc.nextLine();

		if(role.equalsIgnoreCase("Wizard") || role.equalsIgnoreCase("Warrior") || role.equalsIgnoreCase("Rogue")){
			System.out.println("Great! You chose the " + role + " role!");
		}
		else{
			System.out.println(role + " isn't a role. Try again.");
		}
		}

	}