
package com.vti.finaltest.frontend;

import java.util.Scanner;

import com.vti.finaltest.utils.*;

/**
 * 
 * This class is Main Program. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class Program {

	public static void main(String[] args) {
		Function f = new Function();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**** Welcome *****");
		System.out.println("You are ( A Manager / An Employee)?");
		String input ="";
		input = ScannerUtils.readString(sc, "Please enter a string");
		
		while ((!input.equals("A Manager")) && (!input.equals("An Employee"))){
			System.out.println("Invalid value, please enter again! (A Manager or An Employee");
			input = ScannerUtils.readString(sc, "Please enter a string");
		}
		
		if (input.equals("A Manager")){
		
			int choose;

			while (true) {
			
				System.out.println("----------Welcome Manager---------");
				System.out.println("1.	Register.");
				System.out.println("2.	Login.");
				System.out.println("3.	Logout.");
				System.out.println("Please choose: ");
				choose = ScannerUtils.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");
				switch (choose) {
					case 1:
						f.insertManager();
					case 2:
						f.login();
						break;
					case 3:
						System.out.println("Logout succesfully!");
						break;
					default:
						System.out.println("Please choose from 1 --> 3");
						break;
				}
			}
		} else if (input.equals("An Employee")){
		
			int choose;

			while (true) {
			
				System.out.println("----------Welcome Employee---------");
				System.out.println("1.	Register.");
				System.out.println("2.	Login.");
				System.out.println("3.	Logout.");
				System.out.println("Please choose: ");
				choose = ScannerUtils.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");
				switch (choose) {
					case 1:
						f.insertEmployee();
					case 2:
						f.loginEmployee();
						break;
					case 3:
						System.out.println("Logout succesfully!");
						break;
					default:
						System.out.println("Please choose from 1 --> 3");
						break;
				}
			}
		}
	}
		
}

