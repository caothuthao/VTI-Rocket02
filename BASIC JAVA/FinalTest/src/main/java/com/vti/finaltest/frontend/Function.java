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
	
		System.out.println("First Name: ");
		manager.setFirstName(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("Last Name: ");
		manager.setLastName(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("Phone: ");
		manager.setPhone(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("Email: ");
		manager.setEmail(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("PassWord: ");
		manager.setPassWord(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("Exp Int Year: ");
		manager.setExpInYear(ScannerUtils.readInt(sc, "Not null! \nTry again"));

	
		boolean bl = new ManagerController().insertManager(manager);
		if (bl) {
			System.out.println("Insert Successfully!");
		}else {
			System.out.println("Insert Failed!");
		}
	}
	
	/**
	 * 
	 * This method is loginManager. 
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
		
		System.out.println("Email: ");
		email = ScannerUtils.readString(sc, "Can't not null! \nPlease try again: ");
		
		System.out.println("PassWord: ");
		passWord = ScannerUtils.readString(sc, "Can't not null! \nPlease try again: ");
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
	
		System.out.println("First Name: ");
		employee.setFirstName(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("Last Name: ");
		employee.setLastName(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("Phone: ");
		employee.setPhone(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("Email: ");
		employee.setEmail(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("PassWord: ");
		employee.setPassWord(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("Project Name: ");
		employee.setProjectName(ScannerUtils.readString(sc, "Not null! \nTry again"));
		
		System.out.println("ProSkill: ");
		employee.setProSkill(ScannerUtils.readString(sc, "Not null! \nTry again"));

	
		boolean bl = new EmployeeController().insertEmployee(employee);
		if (bl) {
			System.out.println("Insert Successfully!");
		}else {
			System.out.println("Insert Failed!");
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
		
		System.out.println("Email: ");
		email = ScannerUtils.readString(sc, "Can't not null! \nPlease try again: ");
		
		System.out.println("PassWord: ");
		passWord = ScannerUtils.readString(sc, "Can't not null! \nPlease try again: ");
		boolean bl = new ManagerController().login(email, passWord);
		if (!bl) {
			System.out.println("Please login again!");
		} else {
			System.out.println("Login successfully!");
		}
	
	}
}
