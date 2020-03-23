package exercise2;

import java.util.Scanner;

public class MainProgram {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Create instance of class NormalEmployee
		NormalEmployee nemp = new NormalEmployee();
		
		System.out.println("Enter name of normal employee: ");
		String nm = scanner.nextLine();
		nemp.setName(nm);
		
		System.out.println("Enter address of normal employee: ");
		scanner.nextLine();
		String add = scanner.nextLine();
		nemp.setAddress(add);
		
		System.out.println("Enter Basic Salary of normal employee: ");
		int sal = scanner.nextInt();
		nemp.setBasicSalary(sal);
		
		System.out.println("The information of a normal employee: ");
		System.out.println("Name: " + nemp.getName());
		System.out.println("Address: " + nemp.getAddress());
		System.out.println("Basic Salary: " + nemp.getBasicSalary());
		System.out.println("Monthly Salary: " + nemp.getMonthlySalary());
		
		// Create instance of class BonusEmployee
		BonusEmployee bemp = new BonusEmployee();
				
		// setting values of bemp
		bemp.setName("John");
		bemp.setAddress("Ha Noi");
		bemp.setBasicSalary(2500);
		bemp.setBonusSalary(500);
		
		// print values of bemp		
		System.out.println("The information of a bonus employee: ");
		System.out.println("Name: " + bemp.getName());
		System.out.println("Address: " + bemp.getAddress());
		System.out.println("Basic Salary: " + bemp.getBasicSalary());
		System.out.println("Bonus Salary: " + bemp.getBonusSalary());
		System.out.println("Monthly Salary: " + bemp.getMonthlySalary());
		
		
		
	}
}
