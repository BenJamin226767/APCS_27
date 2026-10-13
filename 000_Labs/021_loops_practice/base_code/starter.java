/*
 *	Author:  
 *  Date: 
*/

import java.util.Scanner;

class starter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int number = (int)(Math.random()*1000)+1;
		int guess = 0;
		System.out.println("Guess the number 1-1000.");
		while(number != guess){
			guess = sc.nextInt();
			if(guess != number){
				if(guess > number){
					System.out.println("Your guess is too high! Try again.");
				}
				else{
					System.out.println("Your guess is too low! Try again.");
				}
			}
			else{
				System.out.println("You guessed correctly! The number was: " + number);
			}
		}
	}
}
