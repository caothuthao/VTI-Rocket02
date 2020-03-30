/**
 * 
 */
package com.vti.Assignment9.backend.presentationlayer;

import com.vti.Assignment9.backend.businesslayer.ITraineeService;
import com.vti.Assignment9.backend.businesslayer.TraineeService;
import com.vti.Assignment9.entity.Trainee;

/**
 * This class is booleanValueUpdate. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 29, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 29, 2020
 */
public class TraineeController {
	
	private ITraineeService service;
	
	/**
	 * Constructor for class TraineeController.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 */
	public TraineeController() {
		service = new TraineeService();
	}
	
	/**
	 * 
	 * This method is used to return boolean value of login trainee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 * @param userName
	 * @param passWord
	 */
	public boolean login (String userName, String passWord){
		
		// validate
//		if ((userName.equals("")) || (passWord.equals(""))){
//			System.out.println("Username and password must be not empty!");
//			return false;
//		}
	
		return service.login(userName, passWord);
		
	}
	
	/**
	 * 
	 * This method is used to return boolean value of insert trainee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 * @param userName
	 * @param passWord
	 */
	public boolean insertTrainee(Trainee trainee){
		
		//validate
//		if (trainee == null){
//			return false;
//		}
		
		return service.insertTrainee(trainee);
		
	}
	
	/**
	 * 
	 * This method is used to return boolean value of update trainee. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 * @param userName
	 * @param passWord
	 */
	public boolean updateTrainee(Trainee trainee){
		
		//validate
//		if (trainee == null){
//			return false;
//		}
		
		return service.updateTrainee(trainee);
		
	}
}
