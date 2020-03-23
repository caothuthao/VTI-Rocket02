
import java.util.Scanner;

public class Professors extends Staffs {
		
	private String faculty;
	private String academicDegree;
	private int monthlyTeachingTime;
		
	Scanner scanner = new Scanner(System.in);
		
	public void input(){
		super.input();
		System.out.println("Enter the other information of professor: ");
		
		System.out.println("faculty: ");
		scanner.nextLine();
		this.faculty = scanner.nextLine();
		
		System.out.println("academicDegree (bachelor/ master/ doctor):");
		scanner.nextLine();
		String academicDegreeEnter = scanner.nextLine();
		while ((!academicDegreeEnter.equals("bachelor")) && (!academicDegreeEnter.equals("master")) && (!academicDegreeEnter.equals("doctor"))){
			System.out.println("Invalid value, please enter again!");
			academicDegreeEnter = scanner.nextLine();
		} this.academicDegree = academicDegreeEnter;
			
		System.out.println("monthlyTeachingTime: ");
		this.monthlyTeachingTime = scanner.nextInt();
	}
	
	public String getFaculity(){
		return faculty;
	}
	
	public String getAcademicDegree(){
		return academicDegree;
	}
	
	public int getMonthlyTeachingTime(){
		return monthlyTeachingTime;
	}

	@Override
	public float getSalary() {
		salary = salaryMultiplier * 730 + allowance + monthlyTeachingTime * 45;
		return salary;
	}
}

