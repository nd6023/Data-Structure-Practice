package misc;

import java.util.Stack;

public class MaxHistArea {

	public static void main(String[] args) {
		MaxHistArea maxHistArea = new MaxHistArea();
		//int [] input = new int[]{2,1,2,3,1};
		int [] input = new int[]{1, 2, 4};
		System.out.println("The maximum Histarogram Area is: \t"+ maxHistArea.maxArea(input));

	}
	
	public int maxArea(int [] input) {
		
		if(input == null || input.length == 0) {
			return 0;
		}
		int len = input.length;
		boolean isInputTraversed = false;
		int maxArea[] = new int []{0}, i = 0;
		Stack <Integer> stk = new Stack<>();
		stk.push(0);
		for(i = 1; i < len; i++) {
			if(input[i] >= input[i-1]) {
				stk.push(i);
			}
			else {
				popStack(stk, input, i, isInputTraversed, input[i], maxArea);
			}
		}
		
		if(!stk.isEmpty()) {
 			isInputTraversed = true;
			popStack(stk, input, i, isInputTraversed, 0, maxArea);
		}
		
		return maxArea[0];
	}
	
	public void popStack(Stack<Integer> stk, int input[], int index, boolean isInputTraversed, int cur, int maxArea[]) {
		int area = 0, top = 0;
		
		if(!isInputTraversed) {
			while(!stk.isEmpty() && input[stk.peek()] > cur) {
				top = stk.pop();
				if(stk.isEmpty()) {
					area = input[top] * index;
				}
				else {
					area = input[top] * (index - stk.peek() - 1);
				}
				if(maxArea[0] < area) {
					maxArea[0] = area;
				}
			}
			stk.push(index);
		}
		else {
			while(!stk.isEmpty()) {
				top = stk.pop();
				if(stk.isEmpty()) {
					area = input[top] * index;
				}
				else {
					area = input[top] * (index - stk.peek() - 1);
				}
				if(maxArea[0] < area) {
					maxArea[0] = area;
				}
			}
		}	
	}
}
