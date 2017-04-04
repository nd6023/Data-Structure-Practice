package Arrays;

public class PivotSortRotArr {
	
	public static void main(String args []) {
		
		PivotSortRotArr pivotSortRotArr = new PivotSortRotArr();
		int [] input = {156, 235, 457, 21, 32, 43, 74, 75, 86, 97, 108, 149};
		int key = 43;
		int pivot = pivotSortRotArr.findPivot(input);
		System.out.println("The pivot of the array is : \t"+pivot);
		System.out.println("Is the key present in the array: \t"+(pivotSortRotArr.isPresent(input, key, 0, pivot) || pivotSortRotArr.isPresent(input, key, pivot + 1, input.length)) );
	}
	
	public int findPivot(int [] input) {
		
		if(input == null || input.length == 0) {
			return -1;
		}
		int end = input.length - 1;
		int start = 0;
		int piv = 0;
		
		if(end == 0 || input[0] <= input[end]) {
			return 0;
		}
		
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			if(mid < input.length && input[mid + 1] < input [mid]) {
				piv = mid + 1;
				return piv;
			}
			else if(input[start] > input[mid]){
				end = mid - 1;
			}
			else {
				end = mid - 1;
			}
		}
		return piv;
		
	}
	
	public boolean isPresent(int [] input, int key, int start, int end) {
		if(input == null || input.length == 0) {
			return false;
		}
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(input[mid] == key) {
				return true;
			}
			else if(input[mid] < key) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return false;
	}
	
	
}