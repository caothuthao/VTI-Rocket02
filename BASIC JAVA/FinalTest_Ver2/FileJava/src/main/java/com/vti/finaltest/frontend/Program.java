
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
		System.out.println("1. Manager");
		System.out.println("2. Employee");
		int input = ScannerUtils.readInt(sc, "Please enter an integer number!");
		
		while ((input != 1) && (input!= 2)){
			System.out.println("Invalid value, please enter again!");
			input = ScannerUtils.readInt(sc, "Please enter an integer number!");
		}
		
		if (input == 1){
			int choose;
			boolean value = true;
			while (value) {
				System.out.println("----------Welcome Manager---------");
				System.out.println("1.	Register.");
				System.out.println("2.	Login.");
				System.out.println("3.	Logout.");
				System.out.println("Please choose: ");
				choose = ScannerUtils.readInt(sc, "Please input data as INTEGER! \nPlease input again: ");
				switch (choose) {
					case 1:
						f.insertManager();
						if (f.getResultInsertManager().equals("Insert Successfully!")){
							System.out.println("Let's login!");
							f.login();
						} else {
							System.out.println("Register again:");
							f.insertManager();
						}
						break;
					case 2:
						f.login();
						break;
					case 3:
						System.out.println("Logout succesfully!");
						value = false;
						break;
					default:
						System.out.println("Please choose from 1 --> 3");
						break;
				}
			}
		} else if (input == 2){
			int choose;
			boolean value = true;
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
					if (f.getResultInsertEmployee().equals("Insert Successfully!")){
						System.out.println("Let's login!");
						f.loginEmployee();
					} else {
						System.out.println("Register again:");
						f.insertEmployee();
					}
					break;
				case 2:
					f.loginEmployee();
					break;
				case 3:
					System.out.println("Logout succesfully!");
					value = false;
					break;
				default:
					System.out.println("Please choose from 1 --> 3");
					break;
				}
			}
		}
	}
		
}

