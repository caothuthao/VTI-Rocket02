package exercise1;

import java.util.Scanner;
public class SequenceNumber {

		public static int[] array;
	
		Scanner scanner = new Scanner(System.in);
		
		public int[] getArray(){
			return array;
		}

		// input method is used to enter a number from keyboard
		public void input(){
			for (int i = 0; i < array.length; i++) {
				System.out.println("Enter element " + (i+1) + "of array: ");
				array[i] = scanner.nextInt();
			}
			
		}

		// print method is used to print array to screen
		public void print(int array[]) {
			for (int i = 0; i < array.length; i++) {
				System.out.println("array[" + i + "]" + ":" + array[i]);
			}
		}
		
		SequenceNumber(int n){
			array = new int[n];
		}
		
//		public static void main(String[] args) {
//			SequenceNumber sn = new SequenceNumber(3);
//			
//			sn.input();
//			
//			System.out.println("Array: ");
//			sn.print(array);
//			
//		}
}

