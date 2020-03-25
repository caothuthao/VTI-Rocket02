
package com.vti.finaltest.backend.businesslayer;

import com.vti.finaltest.backend.datalayer.*;

import com.vti.finaltest.entity.*;

/**
 * 
 * This class is class EmployeeService implements IEmployeeService. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class EmployeeService implements IEmployeeService {
	
	private IEmployeeDao dao;

	/**
	 * 
	 * Constructor for class EmployeeService.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public EmployeeService() {
		dao = new EmployeeDao();
	}

	/**
	 * 
	 */
	public boolean insertEmployee(Employee employee) {
		
		boolean bl = dao.getEmployeeByEmail(employee.getEmail());
		if(!bl) {
			return dao.insertEmployee(employee);
		}else {
			System.out.println("Email existed!");
			return false;
		}
		
	}

	/**
	 * 
	 */
	@Override
	public boolean loginEmployee(String email, String passWord) {
		return dao.loginEmployee(email, passWord);
	}


}
