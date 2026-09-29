/*
 *	Author:
 *  Date:
 * 	Collaborator:
*/

import java.util.Scanner;

class starter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numpick = 0;
		System.out.println("The goal of the game is to guess the planet in our solar system with two hints.");
		System.out.println("Make sure to capitalize your answer!");
		numpick = (int)(Math.random()*8)+1;
		String word;
		String yourpick = "";
		if(numpick == 1){
			word = "Mercury";
			System.out.println("This planet's year is shorter than its solar day: it takes 88 Earth days to orbit the Sun, but 176 Earth days to go from one sunrise to the next.");
			yourpick = sc.nextLine();
			if(yourpick.equals(word)){
				System.out.println("That is correct!");
			}
			else{
				System.out.println("That is incorrect.");
				System.out.println("Here is another hint:");
				System.out.println("This is the smallest planet in our solar system and the closest one to the Sun");
				yourpick = sc.nextLine();
				if(yourpick.equals(word)){
					System.out.println("That is correct!");
				}
				else{
					System.out.println("That is incorrect. You lose! Restart program to try again.");
				}
			}
		}
		else if(numpick == 2){
			word = "Venus";
			System.out.println("This is the hottest planet in our solar system.");
			yourpick = sc.nextLine();
			if(yourpick.equals(word)){
				System.out.println("That is correct!");
			}
			else{
				System.out.println("That is incorrect.");
				System.out.println("Here is another hint:");
				System.out.println("This is the second planet from the sun.");
				yourpick = sc.nextLine();
				if(yourpick.equals(word)){
					System.out.println("That is correct!");
				}
				else{
					System.out.println("That is incorrect. You lose! Restart program to try again.");
				}
			}
		}
		else if(numpick == 3){
			word = "Earth";
			System.out.println("The only planet in our solar system that has liquid water on it's surface.");
			yourpick = sc.nextLine();
			if(yourpick.equals(word)){
				System.out.println("That is correct!");
			}
			else{
				System.out.println("That is incorrect.");
				System.out.println("Here is another hint:");
				System.out.println("This is the only known astronomical object in the universe to harbor life.");
				yourpick = sc.nextLine();
				if(yourpick.equals(word)){
					System.out.println("That is correct!");
				}
				else{
					System.out.println("That is incorrect. You lose! Restart program to try again.");
				}
			}
		}
		else if(numpick == 4){
			word = "Mars";
			System.out.println("This planet is the only planet where we have successfully landed roving vehicles to explore alien landscape.");
			yourpick = sc.nextLine();
			if(yourpick.equals(word)){
				System.out.println("That is correct!");
			}
			else{
				System.out.println("That is incorrect.");
				System.out.println("Here is another hint:");
				System.out.println("This is known as the Red Planet");
				yourpick = sc.nextLine();
				if(yourpick.equals(word)){
					System.out.println("That is correct!");
				}
				else{
					System.out.println("That is incorrect. You lose! Restart program to try again.");
				}
			}
		}
		else if(numpick == 5){
			word = "Jupiter";
			System.out.println("This planet has the strongest gravitational force out of all the planets in our solar system.");
			yourpick = sc.nextLine();
			if(yourpick.equals(word)){
				System.out.println("That is correct!");
			}
			else{
				System.out.println("That is incorrect.");
				System.out.println("Here is another hint:");
				System.out.println("This is the largest planet in the solar system with a mass more than twice than all the planets combined.");
				yourpick = sc.nextLine();
				if(yourpick.equals(word)){
					System.out.println("That is correct!");
				}
				else{
					System.out.println("That is incorrect. You lose! Restart program to try again.");
				}
			}
		}
		else if(numpick == 6){
			word = "Saturn";
			System.out.println("This planet is the only planet in our solar system with an average density lower than water.");
			yourpick = sc.nextLine();
			if(yourpick.equals(word)){
				System.out.println("That is correct!");
			}
			else{
				System.out.println("That is incorrect.");
				System.out.println("Here is another hint:");
				System.out.println("This planet has rings.");
				yourpick = sc.nextLine();
				if(yourpick.equals(word)){
					System.out.println("That is correct!");
				}
				else{
					System.out.println("That is incorrect. You lose! Restart program to try again.");
				}
			}
		}
		else if(numpick == 7){
			word = "Uranus";
			System.out.println("This planet spins completely on its side with an extreme axial tilt of roughly 98 degrees.");
			yourpick = sc.nextLine();
			if(yourpick.equals(word)){
				System.out.println("That is correct!");
			}
			else{
				System.out.println("That is incorrect.");
				System.out.println("Here is another hint:");
				System.out.println("This is the coldest planet in the solar system.");
				yourpick = sc.nextLine();
				if(yourpick.equals(word)){
					System.out.println("That is correct!");
				}
				else{
					System.out.println("That is incorrect. You lose! Restart program to try again.");
				}
			}
		}
		else{
			word = "Neptune";
			System.out.println("This is the first ever planet discovered using math instead of using a telescope.");
			yourpick = sc.nextLine();
			if(yourpick.equals(word)){
				System.out.println("That is correct!");
			}
			else{
				System.out.println("That is incorrect.");
				System.out.println("Here is another hint:");
				System.out.println("This is the most distant planet in our solar system.");
				yourpick = sc.nextLine();
				if(yourpick.equals(word)){
					System.out.println("That is correct!");
				}
				else{
					System.out.println("That is incorrect. You lose! Restart program to try again.");
				}
			}
		}
	}
}
