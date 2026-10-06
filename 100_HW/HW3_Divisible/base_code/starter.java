/*
 *	Author:
 *  Date:
 * 	Collaborator: 
*/

import java.util.Scanner;

class starter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer:");
		int num1 = sc.nextInt();
		System.out.println("");
		System.out.print("Enter another integer:");
		int num2 = sc.nextInt();
		System.out.println("");

		if (num1 % 2 == 0) {
			System.out.println(num1 + " is even.");
		}
		else{
			System.out.println(num1 + " is odd.");
		}

		if (num2 % 2 == 0) {
			System.out.println(num2 + " is even.");
		}
		else{
			System.out.println(num2 + " is odd.");
		}








		if (num1 % 3 == 0 && num1 % 4 == 0 && num1 % 5 == 0) {
			System.out.println(num1 + " is divisible by 3, 4, and 5.");
		}
		else{
			System.out.println(num1 + " is not divisible by 3, 4, and 5.");
		}

		if (num2 % 3 == 0 && num2 % 4 == 0 && num2 % 5 == 0) {
			System.out.println(num2 + " is divisible by 3, 4, and 5.");
		}
		else{
			System.out.println(num2 + " is not divisible by 3, 4, and 5.");
		}
	}
}
