/**
 * 
 */
package com.vti.Assignment9.frontend;

import java.util.Scanner;

import com.vti.Assignment9.entity.Trainee;
import com.vti.Assignment9.utils.ScannerUtils;

/**
 * This class is Program. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 29, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 29, 2020
 */
public class Program {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Function function = new Function();
		
		System.out.println("Welcome to the system. \nFirstly, please enter your user name and password to login to the system:");
		
		// login:
		function.login();
		
		if (function.getResultLogin().equals("Login successfully!")){
			
			System.out.println("*********** MENU **************");
			System.out.println("1. Insert trainee");
			System.out.println("2. Update trainee");
			System.out.println("3. Exit");
			
			System.out.println("Please enter your choice:");
			int choice = ScannerUtils.readInt(scanner, "Please enter an integer number! Enter again:");
			
			boolean booleanValue = true;
			
			while(booleanValue){
				switch(choice){
				case 1:
					function.insertTrainee();
					break;
					
				case 2:
					function.updateTrainee();
					break;
					
				case 3:
					System.out.println("Exit Successfully!");
					booleanValue = false;
					break;
				default:
					System.out.println("Please chose 1-->3");
					break;
				}
			}
		} else {
			System.out.println("Login again!");
		}
		
	}
}
