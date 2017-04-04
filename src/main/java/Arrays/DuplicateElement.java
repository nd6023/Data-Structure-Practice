package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElement {
	
	public static void main(String [] args) {
		DuplicateElement duplicateElement = new DuplicateElement();
		int [] input = new int[]{2, 4, 1, 2, 6, 1, 6, 3, 0};
		List<Integer> resList = duplicateElement.findDuplicate(input);
		for(int no : resList) {
			System.out.print(no+"\t");
		}
	}
	
	public List<Integer> findDuplicate(int [] input) {
		if(input == null || input.length == 0) {
			return null;
		}
		int len = input.length;
		Set<Integer> resSet = new HashSet<>();
		List<Integer> resList = new ArrayList<>();
		for(int i = 0; i < len; i++) {
			if(resSet.contains(input[i])) {
				resList.add(input[i]);
			}
			else {
				resSet.add(input[i]);
			}
		}
		
		return resList;
	}
	
}