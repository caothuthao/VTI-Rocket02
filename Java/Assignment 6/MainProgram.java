
public class MainProgram {
	public static void main(String[] args) {

		// Create instance of Professors
		Professors pf = new Professors();
		pf.input();

		System.out.println("--------------------------");
		System.out.println("Full Name: " + pf.fullName);
		System.out.println("Faculity: " + pf.getFaculity());
		System.out.println("Academic Degree: " + pf.getAcademicDegree());
		System.out.println("Allowance: " + pf.allowance);
		System.out.println("Monthly Teaching Time: " + pf.getMonthlyTeachingTime());
		System.out.println("Salary Multiplier: " + pf.salaryMultiplier);
		System.out.println("Salary: " + pf.getSalary());
		
		// Create instance of Officials
		Officials oc = new Officials();
		oc.input();

		System.out.println("--------------------------");
		System.out.println("Full Name: " + oc.fullName);
		System.out.println("Department: " + oc.getDepartment());
		System.out.println("Working Time: " + oc.getWorkingTime());
		System.out.println("Salary Multiplier: " + oc.salaryMultiplier);
		System.out.println("Allowance: " + oc.allowance);
		System.out.println("Position: " + oc.getPosition());
		System.out.println("Salary: " + oc.getSalary());
	}
}
