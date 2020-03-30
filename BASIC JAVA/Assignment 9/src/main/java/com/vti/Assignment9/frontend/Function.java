/**
 * 
 */
package com.vti.Assignment9.frontend;

import java.util.Scanner;

import com.vti.Assignment9.backend.presentationlayer.TraineeController;
import com.vti.Assignment9.entity.Trainee;
import com.vti.Assignment9.utils.ScannerUtils;

/**
 * This class is Function. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 29, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 29, 2020
 */
public class Function {
	
	Scanner scanner = new Scanner(System.in);
	
	private TraineeController controller;
	
	private String resultLogin;
	
	/**
	 * @return the resultLogin
	 */
	public String getResultLogin() {
		return resultLogin;
	}

	/**
	 * @param resultLogin the resultLogin to set
	 */
	public void setResultLogin(String resultLogin) {
		this.resultLogin = resultLogin;
	}

	/**
	 * Constructor for class Function.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 */
	public Function() {
		controller = new TraineeController();
	}

	/**
	 * 
	 * This method is used to login trainee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 * @param userName
	 * @param passWord
	 */
	public void login(){
		
		String userName = "";
		String passWord = "";
		
		// enter user name
		System.out.println("UserName: ");
		userName = ScannerUtils.readString(scanner, "Can't enter null value! \nPlease try again: ");
		
		// enter password
		System.out.println("PassWord: ");
		passWord = ScannerUtils.readString(scanner, "Can't enter null value! \nPlease try again: ");
		
		// check login
		boolean bl = controller.login(userName, passWord);
		if (!bl) {
			this.setResultLogin("Please login again!");
			System.out.println(resultLogin);
		} else {
			this.setResultLogin("Login successfully!");
			System.out.println(resultLogin);
		}
	
	}
	
	/**
	 * 
	 * This method is used to insert trainee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 * @param trainee
	 */
	public void insertTrainee (){
		
		Trainee trainee = new Trainee();
		
		System.out.println("UserName:");
		String userName = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setUserName(userName);
		
		System.out.println("Password:");
		String passWord = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setPassWord(passWord);
		
		System.out.println("First Name:");
		String firstName = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setUserName(firstName);
		
		System.out.println("Last Name:");
		String lastName = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setUserName(lastName);
		
		System.out.println("Email:");
		String email = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setUserName(email);

		// check insert
		boolean booleanValueInsert = controller.insertTrainee(trainee);
		
		if (!booleanValueInsert){
			System.out.println("Insert Failed!");
		} else {
			System.out.println("Insert Successfully!");
		}
	}

	/**
	 * 
	 * This method is used to update trainee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 * @param trainee
	 */
	public void updateTrainee (){
		
		Trainee trainee = new Trainee();
		
		System.out.println("UserName:");
		String userName = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setUserName(userName);
		
		System.out.println("Password:");
		String passWord = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setPassWord(passWord);
		
		System.out.println("First Name:");
		String firstName = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setUserName(firstName);
		
		System.out.println("Last Name:");
		String lastName = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setUserName(lastName);
		
		System.out.println("Email:");
		String email = ScannerUtils.readString(scanner, "Please enter a string! Enter again:");
		trainee.setUserName(email);
	
		boolean booleanValueUpdate = controller.updateTrainee(trainee);
		if (!booleanValueUpdate){
			System.out.println("Update Failed!");
		} else {
			System.out.println("Update Successfully!");
		}
	}
	
}
