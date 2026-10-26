/*
 *	Author:  
 *  Date: 
*/

package pkg;
import java.util.*;

public class BankAccount {
	// -------GLOBAL VARIABLES-------
	int userId;
	double money;
	String name;
	boolean activated;

	// -------CONSTRUCTORS-------
	public bankAccount(){
		userId = 0;
		money = 0;
		name = "Unknown";
		activated = false;
		}
	}
	public bankAccount(int id, String user){
		userId = id;
		money = 0;
		name = user;
		activated = false;
	}

	public bankAccount(int id, String user, boolean active){
		userId = id;
		money = 0;
		name = user;
		activated = active;
	}

	public bankAccount(int id, String user, boolean active, double moolah){
		userId = id;
		money = moolah;
		name = user;
		activated = active;
	}

	// -------METHODS-------

	public void setMoney(double moolah){
		money = moolah;
		return;
	}

	public double getMoney(){
		return money;

	}

		public void printDetails(){
		System.out.println("Name: " + name);
		System.out.println("User ID: " + userId);
		System.out.println("$" + money);
		if(activated){
			System.out.println("This account is active.");
		}
		else{
			System.out.println("This account is not activated.");
		}
		return;
	}
