/**
 * 
 */
package com.vti.Assignment9.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.Assignment9.entity.Trainee;
import jdbc.DBConnect;

/**
 * This class is ITraineeDao.
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 29, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 29, 2020
 */
public class TraineeDao implements ITraineeDao {

	/*
	 * @see com.vti.Assignment9.backend.datalayer.ITraineeDao#login(com.vti.
	 * Assignment9.entity.Trainee)
	 */
	public boolean login(String userName, String passWord) {

		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Trainee where userName=? and passWord=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, passWord);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dem++;
			}
			if (dem == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Error1: SQL Exception!");
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.Assignment9.backend.datalayer.ITraineeDao#insertTrainee(com.vti.
	 * Assignment9.entity.Trainee)
	 */
	public boolean insertTrainee(Trainee trainee) {
		
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					"insert into Trainee (userName, passWord, firstName, lastName, email) values (?,?,?,?,?)");
			pstmt.setString(1, trainee.getUserName()); 
			pstmt.setString(2, trainee.getPassWord()); 
			pstmt.setString(3, trainee.getFirstName());
			pstmt.setString(4, trainee.getLastName());
			pstmt.setString(5, trainee.getEmail());
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Error2: SQL Exception!");
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.Assignment9.backend.datalayer.ITraineeDao#updateTrainee(com.vti.
	 * Assignment9.entity.Trainee)
	 */
	public boolean updateTrainee(Trainee trainee) {
		
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					" update Trainee set userName =?, passWord =?, firstName=?, lastName=?, email=? where userName = ?");
			pstmt.setString(1, trainee.getUserName()); 
			pstmt.setString(2, trainee.getPassWord()); 
			pstmt.setString(3, trainee.getFirstName());
			pstmt.setString(4, trainee.getLastName());
			pstmt.setString(5, trainee.getEmail());
			pstmt.setString(6, trainee.getUserName());
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Error3: SQL Exception!");
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false; 
	
	}

	/*
	 * @see
	 * com.vti.Assignment9.backend.datalayer.ITraineeDao#getTraineeByEmail(java.
	 * lang.String)
	 */
	public boolean getTraineeByUserName(String userName) {
		
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Trainee where userName=?");
			pstmt.setString(1, userName);		
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
			System.out.println("Error4: SQL Exception!");
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

}
