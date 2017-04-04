package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindPeakElement {
	
	public static void main(String args []) {
		
		FindPeakElement findPeakElement = new FindPeakElement();
		int input[] = new int[]{8, -2, 1,4,3,6,7,5, 10};
		List <Integer> resList = findPeakElement.findPeak(input);
		if(resList == null) {
			System.out.println("No peaks!");
		}
		else {
			for(int no: resList) {
				System.out.print(no+"\t");
			}
		}
		
	}
	
	public List<Integer> findPeak(int [] input) {
		
		if(input == null || input.length == 0) {
			return null;
		}
		List <Integer> resList = new ArrayList<>();
		int len = input.length;
		if(len < 2) {
			resList.add(input[0]);
			return resList;
		}
		for(int i = 0; i < len - 1; i++) {
			if(i == 0 && input[i+1] < input[i]) {
				resList.add(input[i]);
			}
			else if(input[i+1] < input[i] && input[i-1] < input[i]){
				resList.add(input[i]);
			}
		}
		
		if(input[len-2] < input[len-1]) {
			resList.add(input[len-1]);
		}
		
		return resList;
		
	}
	
}