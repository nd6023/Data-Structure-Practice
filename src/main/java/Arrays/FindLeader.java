package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindLeader {
	
	public static void main(String args []) {
		FindLeader findLeader = new FindLeader();
		int [] input = new int[]{98, 23, 54, 12, 20, 7, 27};
		List<Integer> resList = findLeader.findLeaderArr(input);
		if(resList == null) {
			System.out.println("There are no leaders.");
		}
		else {
			System.out.println("The leaders are: \t");
			for(int no : resList) {
				System.out.print(no+"\t");
			}
		}
		
	}
	
	public List<Integer> findLeaderArr(int [] input) {
		if(input == null || input.length == 0){
			return null;
		}
		List<Integer> resList = new ArrayList<>();
		int len = input.length - 1;
		resList.add(input[len]);
		int count = 0;
		for(int i = len - 1; i >= 0; i--) {
			if(resList.get(count) < input[i]) {
				resList.add(input[i]);
				count++;
			}
		}
		
		return resList;
	}
	
}