
package com.vti.finaltest.backend.presentationlayer;

import com.vti.finaltest.backend.businesslayer.IManagerService;
import com.vti.finaltest.backend.businesslayer.ManagerService;
import com.vti.finaltest.entity.*;
import com.vti.finaltest.backend.validate.*;

/**
 * 
 * This class is ManagerController. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class ManagerController {
	
	private IManagerService service;

	/**
	 * 
	 * Constructor for class ManagerController.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public ManagerController() {
		service = new ManagerService();
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
	 * @param manager
	 * @return
	 */
	public boolean insertManager(Manager manager) {
		
		//validate
		if (null == manager) {
			return false;
		}
		
		if (!Validate.isPhone(manager.getPhone())) {
			return false;
		}
		
		if (!Validate.isEmail(manager.getEmail())) {
			return false;
		}
		
		if (!Validate.isExpInYear(manager.getExpInYear())) {
			return false;
		}
		
		return service.insertManager(manager);
	}

	
	/**
	 * 
	 * This method is login. 
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
	public boolean login(String email, String passWord) {
		
		//validate
		if (!Validate.isEmail(email)) {
			return false;
		}
		if (!Validate.isPassword(passWord)) {
			return false;
		}
		
		return service.login(email, passWord);
	}
}
