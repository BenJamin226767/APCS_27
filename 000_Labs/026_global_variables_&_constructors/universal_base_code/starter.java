/*
 *	Author:  
 *  Date: 
*/

import pkg.*;
import java.util.*;

class starter {
	public static void main(String args[]) {
		// Your code goes below here
		bankAccount a = new bankAccount();
		bankAccount b = new bankAccount(001, "Benjamin Dayag");
		bankAccount c = new bankAccount(002, "Jacob Poole", true);
		bankAccount d = new bankAccount(003, "John", true, 200.50);

		a.printDetails();
		b.printDetails();
		c.printDetails();
		
		d.setMoney(200.50);
		
		System.out.println("$" + d.getMoney());

		a.printDetails();
		b.printDetails();
		c.printDetails();
		d.printDetails();
	}
}
