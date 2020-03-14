package exercise1;

public class InsertSort extends SequenceNumber implements Sort {

	InsertSort(int n) {
		super(n);
	}

	@Override
	public void sort() {

	}

	public void sort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			int x = arr[i];
			int y = i;
			while (y > 0 && arr[y - 1] > x) {
				arr[y] = arr[y - 1];
				y--;
			}
			arr[y] = x;
		}
	}
	
	public static void main(String[] args) {
		
		InsertSort is = new InsertSort(4);
		
		is.input();
		System.out.println("Array: ");
		is.print(array);
		
		System.out.println("Array after sorting: ");
		is.sort(array, 4);
		is.print(array);
	
	}
}
