package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindCommonElement {
	
	public static void main(String args[]) {
		
		FindCommonElement findCommonElement = new FindCommonElement();
		int[][] arrays = {
                {23, 34, 67, 89, 123, 566, 1000},
                {11, 22, 23, 24,33, 37, 185, 566, 987, 1223, 1234},
                {23, 43, 67, 98, 566, 678},
                {1, 4, 5, 23, 34, 76, 87, 132, 566, 665},
                {1, 2, 3, 23, 24, 344, 566}
              };
		
		int[][] arrays2 = {
				{1, 3, 4, 4, 5, 43, 67, 98, 566, 678},
				{1, 4, 4, 5, 23, 34, 76, 87, 132, 566, 665},
				{1, 2, 4, 4, 5, 23, 24, 344, 566}
		};

		//List<Integer> resList = findCommonElement.getCommonElements(arrays);
		List<Integer> resList = findCommonElement.getCommonElements(arrays2);
		if(resList == null) {
			System.out.println("No common elements found");
		}
		else {
			for(int no : resList) {
				System.out.print(no+"\t");
			}
		}
		
	}
	
	public List<Integer> getCommonElements(int [][] input) {
		
		if(input == null || input.length == 0) {
			return null;
		}
		List<Integer> resList = new ArrayList<>();
		int row = input.length;
		
		int minLen = Integer.MAX_VALUE;
		int minArr [] = null;
		
		for(int i = 0; i < row; i++) {
			if(input[i].length < minLen) {
				minLen = input[i].length;
				minArr = input[i];
			}
		}
		
		boolean isPresent = true;
		int temp [] = new int[row];
		for( int i = 0; i < minLen; i++) {
			isPresent = true;
			for(int j = 0; j < row; j++) {
				if(!isPresent) {
					
					break;
				}
				isPresent = findBS(input[j], temp, j, (input[j].length - 1), minArr[i]);
			}
			if(isPresent) {
				resList.add(minArr[i]);
			}
		}
		
		return resList;
	}
	
	public boolean findBS(int [] input, int [] index, int indexVal, int end, int val) {
		if(input == null || input.length == 0) {
			return false;
		}
		int start = index[indexVal];
		if(start > 0) {
			start++;
		}
		boolean resFlag = false;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(input[mid] == val) {
				while(mid-1 >= start && input[mid] == input[mid-1]) {
					mid--;
				}
				resFlag = true;
				index[indexVal] = mid;
				return resFlag;
			}
			else if(input[mid] < val) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		return resFlag;
	}
	
}