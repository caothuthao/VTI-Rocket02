
package com.vti.finaltest.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.jdbc.*;

import com.vti.finaltest.entity.*;

/**
 * 
 * This class is EmployeeDao. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */

public class EmployeeDao implements IEmployeeDao {

	/*
	 * @see com.vti.jdbc.backend.datalayer.ITraineeDAO#login(java.lang.String,
	 * java.lang.String)
	 */
	public boolean loginEmployee(String email, String passWord) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Employee where email=? and passWord=?");
			pstmt.setString(1, email);
			pstmt.setString(2, passWord);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dem++;
			}
			if (dem == 1) {
				return true;
			}else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	
	/*
	 * @see
	 * com.vti.jdbc.backend.datalayer.ITraineeDAO#insertTrainee(com.vti.jdbc.entity.
	 * Trainee)
	 */
	public boolean insertEmployee(Employee employee) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					"insert into Employee (passWord, firstName, lastName, email, phone, projectName, ProSkill) values (?,?,?,?,?,?,?)");
			pstmt.setString(1, employee.getPassWord()); 
			pstmt.setString(2, employee.getFirstName());
			pstmt.setString(3, employee.getLastName());
			pstmt.setString(4, employee.getEmail());
			pstmt.setString(5, employee.getPhone());
			pstmt.setString(6, employee.getProjectName());
			pstmt.setString(7, employee.getProSkill());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	
	/* 
	* @see com.vti.jdbc.backend.datalayer.ITraineeDAO#getTraineeByUserName(java.lang.String)
	*/
	//@Override
	public boolean getEmployeeByEmail(String email) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Employee where email=?");
			pstmt.setString(1, email);		
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dem++;
			}
			if (dem == 1) {
				return true;
			}else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

}
