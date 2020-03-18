package exercise1;

import java.util.Scanner;
public class SequenceNumber {

		private int[] array;
	
		Scanner scanner = new Scanner(System.in);
		
		public int[] getArray(){
			return array;
		}
		
		// input method is used to enter number from keyboard
		public void input(){
			for (int i = 0; i < array.length; i++) {
				System.out.println("Enter element " + (i+1) + "of the array: ");
				array[i] = scanner.nextInt();
			}
		}

		// print method is used to print array to screen
		public void print() {
			for (int i = 0; i < array.length; i++) {
				System.out.println("array[" + i + "]" + ":" + array[i]);
			}
		}
		
		SequenceNumber(int n){
			array = new int[n];
		}
}

