
public class Officials extends Staffs{
	
	private String department;
	private int workingTime;
	private String position;
	
	public void input(){
		super.input();
		System.out.println("Enter the other information of Officials: ");
		
		System.out.println("department: ");
		scanner.nextLine();
		this.department = scanner.nextLine();
		
		System.out.println("workingTime: ");
		this.workingTime = scanner.nextInt();
		
		System.out.println("position (departmentHead/ viceHead/ staff): ");
		scanner.nextLine();
		String positionEnter = scanner.nextLine();
		while (!positionEnter.equals("departmentHead") && !positionEnter.equals("viceHead") && (!positionEnter.equals("staff"))){
			System.out.println("Invalid value, enter again!");
			positionEnter = scanner.nextLine();
		} this.position = positionEnter;
	}

	public String getDepartment(){
		return department;
	}
	
	public int getWorkingTime(){
		return workingTime;
	}
	
	public String getPosition(){
		return position;
	}
	
	@Override
	public float getSalary() {
		salary = salaryMultiplier * 730 + allowance + workingTime * 30;
		return salary;
	}
}
