
package com.vti.Assignment9.backend.businesslayer;

import com.vti.Assignment9.entity.Trainee;

/**
 * This class is ITraineeService. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 29, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 29, 2020
 */
public interface ITraineeService {
	
	boolean login (String userName, String passWord);
	
	boolean insertTrainee (Trainee trainee);
	
	boolean updateTrainee (Trainee trainee);
	
}
