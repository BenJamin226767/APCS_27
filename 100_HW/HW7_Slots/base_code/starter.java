/*
 *	Author:
 *  Date:
 * 	Collaborator(s): 
*/

import java.util.Scanner;

class starter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String play = "";
		String playAgain = "";
		int money = 100;
		int input;

		int num1;
		int num2;
		int num3;
		System.out.println("Would you like to play? Enter Y/N.");
		play = sc.nextLine();

		while(play.equalsIgnoreCase("y") && money > 0){
			System.out.println("Your money: $" + money);
			System.out.println("How much would you like to enter?");
			input = sc2.nextInt();
			money = money - input;
			if(input <= money){
				num1 = (int)(Math.random() * 10)+1; 
				num2 = (int)(Math.random() * 10)+1; 
				num3 = (int)(Math.random() * 10)+1; 

				System.out.println(num1 + "||" + num2 + "||" + num3);
				if(num1 == num2 && num1 == num3){
					System.out.println("JACKPOT! Tripling $" + input + "!");
					money = money+(input*3);
				}
				else if(num1 == num2 || num1 == num3 || num2 == num3){
					System.out.println("Winner! Doubling $" + input + "!");
					money = money+(input*2);
				}
				else{
					System.out.println("LOSE. You lose $" + input + ".");
				}
			System.out.println("Would you like to play again? Y/N.");
			play = sc.nextLine();
			}

		}
			System.out.println("Goodbye!");
			System.out.println("Your money after casino: $" + money);

	}
}
