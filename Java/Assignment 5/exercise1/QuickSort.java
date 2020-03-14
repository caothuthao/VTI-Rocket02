package exercise1;

public class QuickSort extends SequenceNumber implements Sort{

	QuickSort(int n) {
		super(n);
	}

	@Override
	public void sort(){
		
	}
		
	public void sort(int[] arr, int left, int right){
		
		if (arr == null || arr.length == 0)
			return;

		if (left >= right)
			return;

		int middle = left + (right - left) / 2;
		int pivot = arr[middle];
		int i = left, j = right;

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
			    j--;
			}

			if (i <= j) {
				int temp = arr[i];
			    arr[i] = arr[j];
			    arr[j] = temp;
			    i++;
			    j--;
			}
		}

		if (left < j){
			sort(arr, left, j);

		if (right > i)
			sort(arr, i, right);
		
		}
	}
	
	public static void main(String[] args) {
		
		QuickSort qs = new QuickSort(4);
		
		qs.input();
		System.out.println("Array: ");
		qs.print(array);
		
		System.out.println("Array after sorting: ");
		qs.sort(array, 0, 3);
		qs.print(array);
		
	}
	
}
