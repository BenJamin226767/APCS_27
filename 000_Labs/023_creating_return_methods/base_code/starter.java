/*
 *	Author:  
 *  Date: 
*/

import java.util.Scanner;

class starter {
	public static void main(String args[]) {
		// Your code goes below here
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer:");
		int x = sc.nextInt();
		System.out.println("Enter another integer:");
		int y = sc.nextInt();
		
		System.out.println(pow(x, y));

		
	}
	public static int pow(int x, int y){
		int power = 0;
		int ans = 0;
		while(power < y){
			power++;
			ans = x * x;
			x = x*ans;
			
			
		}
		return ans;
	}
}
