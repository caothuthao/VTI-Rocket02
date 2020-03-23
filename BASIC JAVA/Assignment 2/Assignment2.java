import java.util.Random;

public class Assignment1 {
	public static void main(String[] args) {
		// Question 1:
		String[] firstName ={"Cao", "Nguyen", "Tran", "Pham", "Do", "Phan", "Dinh"};
		String[] middleName ={"Thu","Thi","Hong","Van","Hoang","Van","Tien"};
		String[] name = {"Thao		","Trang		","Nhung		","Nguyet		","Tien		","Thanh		","Nhat		"};
		
		String[] fullName = new String[10];
		
		Random random = new Random();
	
		for(int i=0; i<10; i++){
			int numberFirstname = random.nextInt(7);
			int numberMiddleName = random.nextInt(7);
			int numberName = random.nextInt(7);
			fullName[i] = firstName[numberFirstname]+" " + middleName[numberMiddleName] +" "+ name[numberName];
		}
		 
		// Question 2:
		int numberID = 1111111;
		
		String[] ID = new String[10];
		for(int i=0; i<10; i++){
			ID[i] = "SV" + numberID +"	";
			numberID ++;
		}
		//Question 3:
		String[] birthDate = new String[10];
		
		for(int i=0; i<10; i++){
			int birthMonth = 2 + random.nextInt(11);
			int birthDay = 0;
			switch (birthMonth){
			case 3:
				birthDay = 1+ random.nextInt(31);
				break;
			case 5:
				birthDay = 1+ random.nextInt(31);
				break;
			case 7:
				birthDay = 1+ random.nextInt(31);
				break;
			case 8:
				birthDay = 1+ random.nextInt(31);
				break;
			case 10:
				birthDay = 1+ random.nextInt(31);
				break;
			case 12:
				birthDay = 1+ random.nextInt(31);
				break;
			case 2:
				birthDay = 1+ random.nextInt(28);
				break;
			case 4:
				birthDay = 1+ random.nextInt(30);
				break;
			case 6:
				birthDay = 1+ random.nextInt(30);
				break;
			case 9:
				birthDay = 1+ random.nextInt(30);
				break;
			case 11:
				birthDay = 1+ random.nextInt(30);
				break;	
			}
			birthDate[i] = birthDay +"/" + birthMonth+"/" + "1991";
		}
		
		// Question 4:
		System.out.println("________________________________________________");
		System.out.println("Full name		  ID		Date");
		System.out.println("_________________________________________________");
		for(int i=0; i<10; i++){
			System.out.println(fullName[i] + ID[i] + birthDate[i] );
		}
		System.out.println("_________________________________________________");
		
	}
}
