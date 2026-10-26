/*
 *	Author:
 *  Date:
 * 	Collaborator(s):
*/
import pkg.*;
import java.util.Scanner;
import java.util.Random;

class starter {
	public static void main(String args[]) {
		Employee dwightSchrute = new Employee(1987, "Dwight", "Schrute", 4416.66);
		dwightSchrute.employeeToString();
		dwightSchrute.raiseSalary(1);

		Employee jimHalpert = new Employee(2474, "Jim", "Halpert", 4416.66);
		jimHalpert.employeeToString();
		jimHalpert.raiseSalary(1);

		Employee pamBeesly = new Employee(2011, "Pam", "Beesly", 2250);
		pamBeesly.employeeToString();
		pamBeesly.raiseSalary(5);

		Employee jacobPoole = new Employee(2026, "Jacob", "Poole", 5050.10);
		jacobPoole.employeeToString();
		jacobPoole.raiseSalary(2);
		
	}
}
