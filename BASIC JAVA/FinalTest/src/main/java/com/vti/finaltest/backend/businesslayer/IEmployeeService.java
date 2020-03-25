
package com.vti.finaltest.backend.businesslayer;

import com.vti.finaltest.entity.*;

/**
 * 
 * This class is IEmployeeService. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public interface IEmployeeService {
	
	boolean loginEmployee(String email, String passWord);

	boolean insertEmployee(Employee employee);

}
