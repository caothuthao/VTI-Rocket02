
package com.vti.finaltest.backend.datalayer;

import com.vti.finaltest.entity.*;

/**
 * 
 * This class is IManagerDao. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public interface IManagerDao{
	
	boolean login(String email, String passWord);
	
	boolean insertManager(Manager manager);

	boolean getManagerByEmail(String userName);
}
