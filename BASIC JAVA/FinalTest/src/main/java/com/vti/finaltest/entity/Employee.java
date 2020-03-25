/**
 * 
 */
package com.vti.finaltest.entity;

 /**
 * This class is Employee. 
 * 
 * @Description: .
 * @author: CaoThuThao
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: CaoThuThao
 * @modifer_date: Mar 25, 2020
 */
public class Employee extends User{
	
	private String projectName;
	private String proSkill;
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the proSkill
	 */
	public String getProSkill() {
		return proSkill;
	}
	/**
	 * @param proSkill the proSkill to set
	 */
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	
	
}
