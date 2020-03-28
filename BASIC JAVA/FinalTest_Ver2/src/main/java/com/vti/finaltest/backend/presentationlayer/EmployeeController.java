
package com.vti.finaltest.backend.presentationlayer;

import com.vti.finaltest.backend.businesslayer.EmployeeService;
import com.vti.finaltest.backend.businesslayer.IEmployeeService;
import com.vti.finaltest.backend.validate.Validate;
import com.vti.finaltest.entity.*;

/**
 * 
 * This class is EmployeeController. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class EmployeeController {
	
	private IEmployeeService service;

	/**
	 * 
	 * Constructor for class EmployeeController.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public EmployeeController() {
		service = new EmployeeService();
	}

	/**
	 * 
	 * This method is insertEmployee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param employee
	 * @return
	 */
	public boolean insertEmployee(Employee employee) {
		//validate
		if (null == employee) {
			return false;
		}
		
		if (!Validate.isPhone(employee.getPhone())) {
			return false;
		}
		
		if (!Validate.isEmail(employee.getEmail())) {
			return false;
		}
		
		if (!Validate.isProjectName(employee.getProjectName())) {
			return false;
		}

		return service.insertEmployee(employee);
	}

	/**
	 * 
	 * This method is loginEmployee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param email
	 * @param passWord
	 * @return
	 */
	public boolean loginEmployee(String email, String passWord) {
		
		//validate
		if (!Validate.isEmail(email)) {
			return false;
		}
		
		if (!Validate.isPassword(passWord)) {
			return false;
		}
		
		return service.loginEmployee(email, passWord);
	}
}
