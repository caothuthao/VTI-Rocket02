import java.util.Collection;
import java.util.List;

public class Staffs extends Employees{
	
	private String department;
	private int workingTime;
	private String position;
	
	
	/**
	 * This method is used to enter values of Officials from the keyboard
	 * @author Cao_Thu_Thao
	 */
	public void input(){
		super.input();
		System.out.println("Enter the other information of Officials: ");
		
		// enter department
		System.out.println("department: ");
		scanner.nextLine();
		this.department = scanner.nextLine();
		
		// enter working time
		System.out.println("workingTime: ");
		this.workingTime = scanner.nextInt();
		
		// enter position
		System.out.println("position (departmentHead/ viceHead/ staff): ");
		scanner.nextLine();
		//positionEnter is stored position which user enter from the keyboard
		String positionEnter = scanner.nextLine();
		//while positionEnter != default values, print notification, suggest user enter value again
		while (!positionEnter.equals("departmentHead") && !positionEnter.equals("viceHead") && (!positionEnter.equals("staff"))){
			System.out.println("Invalid value, enter again!");
			positionEnter = scanner.nextLine();
		} 
		// if academicDegreeEnter == each of default values, assign this values to academicDegree.
		this.position = positionEnter;
	}

	
	/**
	 * This method is used to return Department of Officials
	 */
	public String getDepartment(){
		return department;
	}
	
	/**
	 * This method is used to return WorkingTime of Officials
	 */
	public int getWorkingTime(){
		return workingTime;
	}
	
	/**
	 * This method is used to returntPosition of Officials
	 */
	public String getPosition(){
		return position;
	}
	
	/**
	 * This method is used to return salary of Officials
	 * @author Cao_Thu_Thao
	 * @return salary
	 */
	@Override
	public float getSalary() {
		salary = salaryMultiplier * 730 + allowance + workingTime * 30;
		return salary;
	}
	
	
	/**
	 * This method is used to print some information of staff to the screen
	 * @author CaoThuThao
	 */
	public void print(){
		super.print();
		System.out.println("Department: " + this.department);
		System.out.println("Working Time: " + this.workingTime);
		System.out.println("Position: " + this.position);
		System.out.println("Salary:" + this.getSalary());
	}
	
	/**
	 * Method searchStaff is used to search and print the information of staff who has name and department user entered from
	 * the keyboard
	 * @author CaoThuThao
	 * @param listStaffs
	 * @param nameSearch
	 * @param departmentSearch
	 */
	public static void searchStaff (List<Staffs> listStaffs, String nameSearch, String departmentSearch){
		for (int i = 0; i < listStaffs.size(); i++) {
			if ((listStaffs.get(i).fullName.equals(nameSearch)) && (listStaffs.get(i).getDepartment().equals(departmentSearch))){
				listStaffs.get(i).print();
			}
		}		
	}
}
