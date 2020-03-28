
package com.vti.finaltest.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.jdbc.*;

import com.vti.finaltest.entity.*;

/**
 * 
 * This class is ManagerDao. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class ManagerDao implements IManagerDao {

	/**
	 * 
	 * This method is used to return boolean value of loginManager
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param email
	 * @param passWord
	 */
	public boolean login(String email, String passWord) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Manager where email=? and passWord=?");
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
			System.out.println("Error: SQL Exception!");
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	
	/**
	 * 
	 * This method is used to return boolean value of insert Manager
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param manager
	 */
	public boolean insertManager(Manager manager) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					"insert into Manager (passWord, firstName, lastName, email, expInYear, phone) values (?,?,?,?,?,?)");
			pstmt.setString(1, manager.getPassWord()); 
			pstmt.setString(2, manager.getFirstName());
			pstmt.setString(3, manager.getLastName());
			pstmt.setString(4, manager.getEmail());
			pstmt.setInt(5, manager.getExpInYear());
			pstmt.setString(6, manager.getPhone());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Error: SQL Exception!");
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	
	/**
	 * 
	 * This method is used to return boolean value of getManagerByEmail
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param email
	 */
	//@Override
	public boolean getManagerByEmail(String email) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Manager where email=?");
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
			System.out.println("Error: SQL Exception!");
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

}
