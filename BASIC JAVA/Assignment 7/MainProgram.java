import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*******MENU*********");
		System.out.println("1. Search staff by name and department");
		System.out.println("2. Sort list professors by name");
		
		System.out.println("Before entering your choice, please enter some information of list professor and list staff!");
		//Enter list professor:
		List<Professors> listProfessors = new ArrayList<>();
		System.out.println("Enter number of professor:");
		int numberProfessor = ScannerUtils.readInt(scanner,"Please enter a int number! Enter again:");
		
		for (int i = 0; i < numberProfessor; i++) {
			listProfessors.add(new Professors());
			System.out.println("Enter the information of listProfessor[" + (i+1) + "]");
			listProfessors.get(i).input();
		}
		
		//enter list staff:
		List<Staffs> listStaffs = new ArrayList<>();
		System.out.println("Enter number of Staff:");
		int numberStaff = ScannerUtils.readInt(scanner,"Please enter a int number! Enter again:");
		
		for (int i = 0; i < numberStaff; i++) {
			listStaffs.add(new Staffs());
			System.out.println("Enter the information of listStaffs[" + (i+1) + "]");
			listStaffs.get(i).input();
		}
		// print 2 list:
		System.out.println("***************************************");
		System.out.println("List professor: ");
		for (int j = 0; j < listProfessors.size(); j++) {
			System.out.println("----------------------------------------------");
			listProfessors.get(j).print();
		}
		System.out.println("***************************************");
		System.out.println("List Staff: ");
		for (int j = 0; j < listStaffs.size(); j++) {
			System.out.println("----------------------------------------------");
			listStaffs.get(j).print();
		}
		
		//enter the choice
		System.out.println("Okay. Now, please enter your choice: ");
		int choice = ScannerUtils.readInt(scanner,"Please enter a int number! Enter again:");
		
		
		if (choice == 1){
			System.out.println("Enter name and department of staff which you want to search");
			System.out.println("Name: ");
			String nameSearch = ScannerUtils.readString(scanner, "Please enter string, enter again!");
			scanner.nextLine();
			System.out.println("Department: ");
			String departmentSearch = ScannerUtils.readString(scanner, "Please enter string, enter again!");
			
			
			// call searchStaff method and print the result
			System.out.println("Information of staff who you want to search: ");
			Staffs.searchStaff(listStaffs, nameSearch, departmentSearch);
			
			
		} else if (choice == 2){
			Collections.sort(listProfessors, new Comparator<Professors>() {

				@Override
				public int compare(Professors obj1, Professors obj2) {
					return obj1.getSortedName(obj1.fullName).compareTo(obj2.getSortedName(obj2.fullName));
				}

			});

			System.out.println("List professors after sorting by name: ");
			for (Professors pr : listProfessors) {
				pr.print();
			}
		}
		
	}
}


