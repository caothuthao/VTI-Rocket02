
package com.vti.finaltest.backend.datalayer;

import com.vti.finaltest.entity.*;

/**
 * 
 * This class is IEmployeeDao . 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public interface IEmployeeDao{
	
	boolean loginEmployee(String email, String passWord);

	boolean insertEmployee(Employee employee);

	boolean getEmployeeByEmail(String email);
}
