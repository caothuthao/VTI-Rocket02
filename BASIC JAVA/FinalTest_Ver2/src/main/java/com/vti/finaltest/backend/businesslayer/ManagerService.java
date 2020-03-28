
package com.vti.finaltest.backend.businesslayer;

import com.vti.finaltest.backend.datalayer.*;

import com.vti.finaltest.entity.*;

/**
 * 
 * This class is ManagerService implements IManagerService. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class ManagerService implements IManagerService {
	
	private IManagerDao dao;

	/**
	 * 
	 * Constructor for class ManagerService.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public ManagerService() {
		dao = new ManagerDao();
	}

	/**
	 * 
	 * This method is used to return boolean of insert manager 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	public boolean insertManager(Manager manager) {
		
		boolean bl = dao.getManagerByEmail(manager.getEmail());
		if(!bl) {
			return dao.insertManager(manager);
		}else {
			System.out.println("Email existed!");
			return false;
		}
		
	}

	/**
	 * 
	 * This method is used to return boolean of login manager
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 */
	@Override
	public boolean login(String email, String passWord) {
		return dao.login(email, passWord);
	}


}
