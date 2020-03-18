package exercise1;

public class SelectionSort extends SequenceNumber implements Sort{

	SelectionSort(int n) {
		super(n);
	}

	@Override
	public void sort() {
		
	}
	
	private static void swap (int []A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
		
	public void sort(int[] arr, int n){
		
			for(int i=0; i<n-1; i++) {
				int minArr = i;
				for(int j=i+1; j<n; j++) {
					if(arr[minArr]>arr[j]) {
						minArr = j;
					}
				}
				if(i!=minArr)
					swap(arr, minArr, i);
			}
	}
}
