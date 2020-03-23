import java.util.Random;

public class Assignment3 {
	
	public static void main(String[] args) {
		String[] firstName = { "Cao", "Nguyen", "Tran", "Pham", "Do", "Phan", "Dinh" };
		String[] middleName = { "Thu", "Thi", "Hong", "Van", "Hoang", "Van", "Tien" };
		String[] name = { "Thao		", "Trang		", "Nhung		", "Nguyet		", "Tien		", "Thanh		",
				"Nhat		" };

		String[] fullName = new String[10];

		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int numberFirstname = random.nextInt(7);
			int numberMiddleName = random.nextInt(7);
			int numberName = random.nextInt(7);
			fullName[i] = firstName[numberFirstname] + " " + middleName[numberMiddleName] + " " + name[numberName];
		}

		// Question 2:
		int numberID = 1111111;

		String[] ID = new String[10];
		for (int i = 0; i < 10; i++) {
			ID[i] = "SV" + numberID + "	";
			numberID++;
		}
		// Question 3:
		String[] birthDate = new String[10];

		for (int i = 0; i < 10; i++) {
			int birthMonth = 2 + random.nextInt(11);
			int birthDay = 0;
			switch (birthMonth) {
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				birthDay = 1 + random.nextInt(31);
				break;
			case 2:
				birthDay = 1 + random.nextInt(28);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				birthDay = 1 + random.nextInt(30);
				break;
			}
			birthDate[i] = birthDay + "/" + birthMonth + "/" + "1991";
		}

		// Assignment 3:
		
		int[] RA = { 0, 5, 6, 1, 3, 4, 4, 7, 2, 10 };
		int[] SD = { 8, 5, 6, 3, 6, 3, 4, 1, 2, 0 };
		int[] CP = { 2, 5, 2, 7, 3, 3, 3, 9, 6, 0 };
		int[] CUT = { 9, 7, 1, 7, 3, 3, 3, 1, 7, 0 };
		int[] FMT = { 4, 7, 7, 7, 3, 3, 10, 1, 1, 0 };

		float[] AVG = new float[10];
		for (int i = 0; i < 10; i++) {
			AVG[i] = (float) (RA[i] + SD[i] + CP[i] + CUT[i] + FMT[i]) / 5;
		}

		// Xep hang AVG
		// Sap xep mang theo thu tu giam dan cua diem trung binh
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 10; j++) {
				if (AVG[i] < AVG[j]) {
					float tempAvg = AVG[i];
					AVG[i] = AVG[j];
					AVG[j] = tempAvg;
					

					int tempRA = RA[i];
					RA[i] = RA[j];
					RA[j] = tempRA;
					

					int tempSD = SD[i];
					SD[i] = SD[j];
					SD[j] = tempSD;
					

					int tempCP = CP[i];
					CP[i] = CP[j];
					CP[j] = tempCP;
					

					int tempCUT = CUT[i];
					CUT[i] = CUT[j];
					CUT[j] = tempCUT;
					

					int tempFMT = FMT[i];
					FMT[i] = FMT[j];
					FMT[j] = tempFMT;
					

					String tempFullName = fullName[i];
					fullName[i] = fullName[j];
					fullName[j] = tempFullName;
					
					String tempBirthDate = birthDate[i];
					birthDate[i] = birthDate[j];
					birthDate[j] = tempBirthDate;
					

					String tempID = ID[i];
					ID[i] = ID[j];
					ID[j] = tempID;
					
				}
			}
		}

		// tao mang rank chua so xep hang (tinh theo diem trung binh) cua cac sinh vien
		int rank[] = new int[10];
		for (int i=0; i<10; i++){
			rank[i] = i+1;
		}

		// in ket qua ra ngoai man hinh
		System.out.println("Full name		ID		Date		RA	SD	CP	CUT	FMT	Avg	Rank");
		System.out.println(
				"___________________________________________________________________________________________________________");
		for (int i = 0; i < 10; i++) {
			System.out.println(fullName[i] + ID[i] + birthDate[i] + "	" + RA[i] + "	" + SD[i] + "	" + CP[i]
					+ "	" + CUT[i] + "	" + FMT[i] + "	" + AVG[i] + "	" + rank[i]);
		}
	}
}
