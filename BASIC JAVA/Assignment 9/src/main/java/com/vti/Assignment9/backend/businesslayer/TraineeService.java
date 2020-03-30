
package com.vti.Assignment9.backend.businesslayer;

import com.vti.Assignment9.backend.datalayer.ITraineeDao;
import com.vti.Assignment9.backend.datalayer.TraineeDao;
import com.vti.Assignment9.entity.Trainee;

/**
 * This class is TraineeService. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 29, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 29, 2020
 */
public class TraineeService implements ITraineeService {

	private ITraineeDao dao;
	
	/**
	 * Constructor for class TraineeService.
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 */
	public TraineeService() {
		dao = new TraineeDao();
	}
	
	/* 
	* @see com.vti.Assignment9.backend.businesslayer.ITraineeService#login(java.lang.String, java.lang.String)
	*/
	public boolean login(String userName, String passWord) {
		
		return dao.login(userName, passWord);
		
	}

	/* 
	* @see com.vti.Assignment9.backend.businesslayer.ITraineeService#insertTrainee(com.vti.Assignment9.entity.Trainee)
	*/
	public boolean insertTrainee(Trainee trainee) {
		boolean booleanValueInsert = dao.getTraineeByUserName(trainee.getUserName());
		if (!booleanValueInsert){
			return dao.insertTrainee(trainee);
		} else {
			System.out.println("User existed!");
			return false;
		}
		
	}

	/* 
	* @see com.vti.Assignment9.backend.businesslayer.ITraineeService#updateTrainee(com.vti.Assignment9.entity.Trainee)
	*/
	public boolean updateTrainee(Trainee trainee) {
		boolean booleanValueUpdate = dao.getTraineeByUserName(trainee.getUserName());
		if (booleanValueUpdate){
			return dao.updateTrainee(trainee);
		} else {
			System.out.println("User does not exist!");
			return false;
		}
	}

}
