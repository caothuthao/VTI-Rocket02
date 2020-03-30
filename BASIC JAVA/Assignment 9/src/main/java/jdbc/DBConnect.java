
package jdbc;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * This class is DBConnect. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 29, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 29, 2020
 */
public class DBConnect {
	 
	/**
	 * 
	 * This method is used to open connection to database. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 * @return
	 */
	public static Connection openConnection() {
		
		Connection con = null;
		Properties propertiesFile = new Properties();
		try {
			propertiesFile.load(new FileInputStream("src/main/resource/database.properties"));
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File Not Found");
		} catch (IOException ex) {
			System.out.println("Error: IO Exception!");
		}

		String url = propertiesFile.getProperty("connectionString");
		String user = propertiesFile.getProperty("username");
		String password = propertiesFile.getProperty("password");
		String driver = propertiesFile.getProperty("driverSQLName");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: Class Not Found");
		} catch (SQLException ex) {
			System.out.println("Error: SQL Exception");
		}

		return con;
	}
	
	/**
	 * 
	 * This method is used to close database connection. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 29, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 29, 2020
	 * @param con
	 * @param pstmt
	 * @param rs
	 */
	public static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println("Error: SQL Exception!");
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException ex) {
				System.out.println("Error: SQL Exception!");
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException ex) {
				System.out.println("Error: SQL Exception!");
			}
	}

}
