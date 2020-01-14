import java.util.Random;

public class Assignment1 {
	public static void main(String[] args) {
		// Question 1:
		String[] ho ={"Cao", "Nguyen", "Tran", "Pham", "Do", "Phan", "Dinh"};
		String[] tenDem ={"Thu","Thi","Hong","Van","Hoang","Van","Tien"};
		String[] ten = {"Thao		","Trang		","Nhung		","Nguyet		","Tien		","Thanh		","Nhat		"};
		
		String[] tenDayDu = new String[10];
		
		Random random = new Random();
	
		for(int i=0; i<10; i++){
			int numberHo = random.nextInt(7);
			int numberTenDem = random.nextInt(7);
			int numberTen = random.nextInt(7);
			tenDayDu[i] = ho[numberHo]+" " + tenDem[numberTenDem] +" "+ ten[numberTen];
		}
		
		// create ID		
//		String stringID = "1111111";
//				
//		
//		String[] ID = new String[10];
//		for(int i=0; i<10; i++){
//			ID[i] = "SV" + stringID;
//			int soID = Integer.parseInt(stringID);
//			soID ++;
//			stringID = Integer.toString(soID);
//		}
//		for(int i=0; i<10; i++){
//			System.out.println(ID[i]);
//		}
		
		// Question 2:
		int stringID = 1111111;
		
		String[] ID = new String[10];
		for(int i=0; i<10; i++){
			ID[i] = "SV" + stringID +"	";
			stringID ++;
		}
		//Question 3:
		String[] birthDate = new String[10];
		
		for(int i=0; i<10; i++){
			int birthDay = 2 + random.nextInt(29);
			int birthMonth = 3 + random.nextInt(9);
			birthDate[i] = birthDay +"/" + birthMonth+"/" + "1991";
		}
		
		// Question 4:
		System.out.println("________________________________________________");
		System.out.println("Full name		ID		Date");
		System.out.println("_________________________________________________");
		for(int i=0; i<10; i++){
			System.out.println(tenDayDu[i] + ID[i] + birthDate[i] );
		}
		System.out.println("_________________________________________________");
		
	}
}
