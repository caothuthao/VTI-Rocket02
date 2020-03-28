package com.vti.finaltest.frontend;

import java.util.Scanner;

import com.vti.finaltest.entity.Employee;
import com.vti.finaltest.entity.Manager;
import com.vti.finaltest.utils.*;
import com.vti.finaltest.backend.presentationlayer.EmployeeController;
import com.vti.finaltest.backend.presentationlayer.ManagerController;

/**
 * 
 * This class is Function. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class Function {
	
	Scanner sc = new Scanner(System.in);
	
	private String resultInsertManager;
	private String resultInsertEmployee;
	
	
	/**
	 * @return the resultInsertManager
	 */
	public String getResultInsertManager() {
		return resultInsertManager;
	}

	/**
	 * @param resultInsertManager the resultInsertManager to set
	 */
	public void setResultInsertManager(String resultInsertManager) {
		this.resultInsertManager = resultInsertManager;
	}

	/**
	 * @return the resultInsertEmployee
	 */
	public String getResultInsertEmployee() {
		return resultInsertEmployee;
	}

	/**
	 * @param resultInsertEmployee the resultInsertEmployee to set
	 */
	public void setResultInsertEmployee(String resultInsertEmployee) {
		this.resultInsertEmployee = resultInsertEmployee;
	}

	/**
	 * 
	 * This method is insertManager. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public void insertManager() {
		
		Manager manager = new Manager();
	
		// input first name
		System.out.println("First Name: ");
		manager.setFirstName(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// input last name
		System.out.println("Last Name: ");
		manager.setLastName(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// input phone
		System.out.println("Phone: ");
		manager.setPhone(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// input email
		System.out.println("Email: ");
		manager.setEmail(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// input password
		System.out.println("PassWord: ");
		manager.setPassWord(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// input experience integer year
		System.out.println("Exp Int Year: ");
		manager.setExpInYear(ScannerUtils.readInt(sc, "Can't enter null value! \nTry again"));

		// check insert
		boolean bl = new ManagerController().insertManager(manager);
		if (bl) {
			resultInsertManager = "Insert Successfully!";
			System.out.println(resultInsertManager);
		}else {
			
			resultInsertManager = "Insert Failed!";
			System.out.println(resultInsertManager);
		}
	}
	
	/**
	 * 
	 * This method is used to login Manager. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public void login(){
		
		String email = "";
		String passWord = "";
		
		// enter email
		System.out.println("Email: ");
		email = ScannerUtils.readString(sc, "Can't enter null value! \nPlease try again: ");
		
		// enter password
		System.out.println("PassWord: ");
		passWord = ScannerUtils.readString(sc, "Can't enter null value! \nPlease try again: ");
		
		// check login
		boolean bl = new ManagerController().login(email, passWord);
		if (!bl) {
			System.out.println("Please login again!");
		} else {
			System.out.println("Login successfully!");
		}
	
	}
	
	/**
	 * 
	 * This method is used to insert Employee . 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public void insertEmployee() {
		
		Employee employee = new Employee();
	
		// enter first name
		System.out.println("First Name: ");
		employee.setFirstName(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// enter last name
		System.out.println("Last Name: ");
		employee.setLastName(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// enter phone
		System.out.println("Phone: ");
		employee.setPhone(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// enter email
		System.out.println("Email: ");
		employee.setEmail(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// enter password
		System.out.println("PassWord: ");
		employee.setPassWord(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// enter project name
		System.out.println("Project Name (Testing System/ CRM/ TimeSheet): ");
		employee.setProjectName(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));
		
		// enter pro skill
		System.out.println("ProSkill: ");
		employee.setProSkill(ScannerUtils.readString(sc, "Can't enter null value! \nTry again"));

		// check insert
		boolean bl = new EmployeeController().insertEmployee(employee);
		if (bl) {
			resultInsertEmployee = "Insert Successfully!";
			System.out.println(resultInsertEmployee);
		}else {
			
			resultInsertEmployee = "Insert Failed!";
			System.out.println(resultInsertEmployee);
		}
	}
	
	/**
	 * 
	 * This method is used to login Employee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public void loginEmployee(){
		
		String email = "";
		String passWord = "";
		
		// enter email
		System.out.println("Email: ");
		email = ScannerUtils.readString(sc, "Can't enter null value! \nPlease try again: ");
		
		// enter password
		System.out.println("PassWord: ");
		passWord = ScannerUtils.readString(sc, "Can't enter null value! \nPlease try again: ");
		
		// check login
		boolean bl = new EmployeeController().loginEmployee(email, passWord);
		if (!bl) {
			System.out.println("Please login again!");
		} else {
			System.out.println("Login successfully!");
		}
	
	}
}
