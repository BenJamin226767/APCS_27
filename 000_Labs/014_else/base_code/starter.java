/*
 *	Author:  
 *  Date: 
*/

import java.util.Scanner;
import java.util.Random;

class starter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("This is a guessing game. Guess a number between 1-1000");
		int numberToGuess = (int)(Math.random()*1000)+1;
		int userGuess;
		userGuess = sc.nextInt();

		if(userGuess == numberToGuess){
			System.out.println("You guessed correctly! You win!");
		}
		else{
			System.out.println("That is incorrect.");
			System.out.println("The number was: " + numberToGuess);
		}

	}
}
