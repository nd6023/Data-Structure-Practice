package misc;

import java.util.ArrayList;
import java.util.List;

public class SortHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortHeight sortHeight =new SortHeight();
		int input[] = new int[]{2,3,5,6,4,10,7,9,11,12};
		System.out.println("The elements to be sorted are: "+ sortHeight.minSort(input) );
	}
	
	public int minSort(int [] input) {
		
		if(input == null || input.length <= 1) {
			return  0;
		}
		int len = input.length;
		List<Integer> unOrderedElement = new ArrayList<>();
		int left = 1, right = len - 2;
		
		while(left < len) {
			if(input[left - 1] > input[left]) {
				
				unOrderedElement.add(left);
			}
			++left;
		}
		
		int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
		for(int no: unOrderedElement) {
			System.out.println("34: ArrayList elements: "+ no);
			if(no > maxVal) {
				maxVal = no;
			}
			if(no < minVal) {
				minVal = no;
			}
		}
		System.out.println("40: Max: "+ maxVal);
		System.out.println("41: Min: "+ minVal);
		return (findCorrectIndex(input, unOrderedElement.get(unOrderedElement.size()-1), len-1, maxVal) - findCorrectIndex(input, 0, unOrderedElement.get(0), minVal));
	}

	public int findCorrectIndex(int [] input, int start, int end, int element) {
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(input[mid] > element && input[mid - 1] < element) {
				System.out.println("47: "+ element);
				return mid;
			}
			else if(input[mid] > element) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println("57: "+ element);
		return 0;
	}
}
