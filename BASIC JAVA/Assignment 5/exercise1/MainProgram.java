package exercise1;

import java.util.Scanner;

public class MainProgram {
	public static void main(String[] args) {
		
		System.out.println("Enter the length of the array:");
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		
		// InsertSort
		InsertSort is = new InsertSort(length);
		//Enter  elements of the array
		is.input();
		//Print the array before sorting
		System.out.println("Array: ");
		is.print();
		//Sorting the array
		is.sort(is.getArray(), length);
		//Print the array after sorting
		System.out.println("Array after Insert Sorting: ");
		is.print();
		
		System.out.println("---------------------------------------------");
		
		// QuickSort
		QuickSort qs = new QuickSort(length);
		//Enter  elements of the array
		qs.input();
		//Print the array before sorting
		System.out.println("Array: ");
		qs.print();
		//Sorting the array
		qs.sort(qs.getArray(), 0, length-1);
		//Print the array after sorting
		System.out.println("Array after Quick Sorting: ");
		qs.print();
		
		System.out.println("---------------------------------------------");
		
		//SelectionSort
		SelectionSort ss = new SelectionSort(length);
		//Enter  elements of the array
		ss.input();
		//Print the array before sorting
		System.out.println("Array: ");
		ss.print();
		//Sorting the array
		ss.sort(ss.getArray(), length);
		//Print the array after sorting
		System.out.println("Array after Selection Sorting: ");
		ss.print();
	}
}
