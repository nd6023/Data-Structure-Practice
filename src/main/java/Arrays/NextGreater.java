package Arrays;

import java.util.Stack;

public class NextGreater {
	
	public static void main(String args []) {
		NextGreater nextGreater = new NextGreater();
		int input[] = new int[]{98, 23, 54, 12, 20, 7, 27};
		System.out.println("The next greater elements are following."); 
		nextGreater.findNextGreater(input);
	}
	
	public void findNextGreater(int [] input) {
		if(input == null || input.length == 0) {
			System.out.println("No greater element found");
		}
		Stack<Integer> stk = new Stack<>();
		stk.push(input[0]);
		int len = input.length;
		for(int i = 1; i < len; i++) {
			if(stk.peek() < input[i]) {
				System.out.println("Next greater element for "+stk.pop()+"\t=\t"+input[i]);
				i--;
			}
			else {
				stk.push(input[i]);
			}
		}
		while(!stk.isEmpty()) {
			System.out.println("Next greater element for "+stk.pop()+"\t=\tnull");
		}
	}
	
}