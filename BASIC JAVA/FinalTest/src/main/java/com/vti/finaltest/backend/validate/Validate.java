
package com.vti.finaltest.backend.validate;

import java.util.regex.Pattern;

/**
 * This class is Validate. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class Validate {

	/**
	 * 
	 * This method is isEmail. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @return
	 */
	public static boolean isEmail(String input) {
		// empty
		if (input.equals("")) {
			System.out.println("Email must not be empty!");
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 30) || !isSatisfyMinLength(input, 6)) {
			System.out.println("Email must has 6 to 30 characters!");
			return false;
		}

		// regular expression
		boolean result = checkRegularExpression(input, "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@");
		if (!result) {
			System.out.println("Email must has 6 to 30 characters and include @, lower, upper characters, ...");
		}
		return result;
	}
	
	/**
	 * 
	 * This method is used to check validate password. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @return
	 */
	public static boolean isPassword(String input) {
		// empty
		if (input.equals("")) {
			System.out.println("Password must not be empty!");
			return false;
		}

		// regular expression
		boolean result = checkRegularExpression(input,"^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,12}$");
		if (!result) {
			System.out.println("Password must has 6 to 8 characters and include 1 upper characters");
		}
		return result;
	}

	/**
	 * 
	 * This method is used to check validate phone. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @return
	 */
	public static boolean isPhone(String input) {
		// empty
		if (input.equals("")) {
			System.out.println("Phone must not be empty!");
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 12) || !isSatisfyMinLength(input, 9)) {
			System.out.println("Phone number must has 9 to 12 numbers!");
			return false;
		}

		// regular expression
		boolean result = checkRegularExpression(input, "^[0-9]{9,12}$");
		if (!result) {
			System.out.println("Phone number must has 9 to 12 numbers and include 0-9!");
		}
		return result;

	}

	/**
	 * 
	 * This method is used to check validate project name. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @return
	 */
	public static boolean isProjectName(String input) {
		// empty
		if (input.equals("")) {
			System.out.println("Project name must not be empty!");
			return false;
		}
		
		if ((!input.equals("(Testing System")) || (!input.equals("(CRM")) || (!input.equals("(TimeSheet")) ){
			return false ;
		}

		return true;
	}

	/**
	 * 
	 * This method is used to check validate proskill. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @return
	 */
	public static boolean isProSkill(String input) {
		// empty
		if (input.equals("")) {
			System.out.println("ProSkill must not be empty!");
			return false;
		}

		return true;
	}

	/**
	 * 
	 * This method is used to check validate exp int year. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @return
	 */
	public static boolean isExpInYear(final int input) {

		// input interger number
		if (input < 0 || input > 10) {
			System.out.println("Exp number has integer number!");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * This method is used to validate max length of String. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @param maxLength
	 * @return
	 */
	public static boolean isSatisfyMaxLength(String input, int maxLength) {
		if (!(input.equals("")) && input.length() <= maxLength) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * This method is used to validate min length of String . 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @param minLength
	 * @return
	 */
	public static boolean isSatisfyMinLength(String input, int minLength) {
		if (!(input.equals("") && input.length() >= minLength)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * This method is checkRegularExpression. 
	 * 
	 * @Description: .
	 * @author: CaoThuThao
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: CaoThuThao
	 * @modifer_date: Mar 25, 2020
	 * @param input
	 * @param regular
	 * @return
	 */
	public static boolean checkRegularExpression(String input, String regular) {
		// validate input
		if (input.equals("")) {
			return false;
		}
		// validate success
		return Pattern.compile(regular).matcher(input).matches();
	}
}