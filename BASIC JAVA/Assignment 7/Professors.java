
import java.util.Scanner;

public class Professors extends Employees {

	private String faculty;
	private String academicDegree;
	private int monthlyTeachingTime;

	Scanner scanner = new Scanner(System.in);

	/**
	 * This method is used to enter values of professors from the keyboard
	 * 
	 * @author Cao_Thu_Thao
	 */
	public void input() {
		super.input();
		System.out.println("Enter the other information of professor: ");

		// enter faculty
		System.out.println("faculty: ");
		scanner.nextLine();
		this.faculty = scanner.nextLine();

		// enter academic degree
		scanner.nextLine();
		System.out.println("academicDegree (bachelor/ master/ doctor):");
		// academicDegreeEnter is stored academicDegree which user enter from
		// the keyboard
		String academicDegreeEnter = scanner.nextLine();
		// while academicDegreeEnter != default values, print notification,
		// suggest user enter value again
		while ((!academicDegreeEnter.equals("bachelor")) && (!academicDegreeEnter.equals("master"))
				&& (!academicDegreeEnter.equals("doctor"))) {
			System.out.println("Invalid value, please enter again!");
			academicDegreeEnter = scanner.nextLine();
		}
		this.academicDegree = academicDegreeEnter;
		// if academicDegreeEnter == each of default values, assign this values
		// to academicDegree.

		// enter monthlyTeachingTime
		System.out.println("monthlyTeachingTime: ");
		this.monthlyTeachingTime = scanner.nextInt();
	}

	/**
	 * This method is used to return faculty of professor
	 */
	public String getFaculity() {
		return faculty;
	}

	/**
	 * This method is used to return academic degree of professor
	 */
	public String getAcademicDegree() {
		return academicDegree;
	}

	/**
	 * This method is used to return monthlyTeachingTime of professor
	 */
	public int getMonthlyTeachingTime() {
		return monthlyTeachingTime;
	}

	/**
	 * This method is used to return salary of professor
	 * 
	 * @author Cao_Thu_Thao
	 * @return salary
	 */
	@Override
	public float getSalary() {
		salary = salaryMultiplier * 730 + allowance + monthlyTeachingTime * 45;
		return salary;
	}

	/**
	 * This method is used to print some information of professor to the screen
	 * @author CaoThuThao
	 */
	public void print(){
		super.print();
		System.out.println("Faculty: " + this.faculty);
		System.out.println("Academic Degree: " + this.academicDegree);
		System.out.println("Monthly Teaching Time" + this.monthlyTeachingTime);
		System.out.println("Salary:" + this.getSalary());
	}
	
	/**
	 * This method is used to split last name of professor, after that moving it to beginning
	 * @param nameProfessor
	 * @return result
	 * @author CaoThuThao
	 */
	public String getSortedName(String nameProfessor) {

		String result;
		String[] names = nameProfessor.split(" ");
		String firstName, lastName;
		String middleName = "";

		firstName = names[0];
		lastName = names[names.length - 1];
		for (int i = 1; i < names.length - 1; i++) {
			middleName = middleName + " " + names[i];
		}

		result = lastName + " " + firstName  + " " + middleName;
		return result;

	}

}
