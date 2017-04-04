package Arrays;

import java.util.Stack;

public class ButSellStocks {
	
	public static void main(String args [] ) {
		ButSellStocks butSellStocks = new ButSellStocks();
		int input[] = {100, 80, 120, 130, 70, 60, 100, 125};
		int input2[] = {100, 80, 70, 65, 60, 55, 50};
		System.out.println("The max profit obtained from multiple buy-sell of stocks is: \t"+butSellStocks.bsStocks(input2));
	}
	
	public int bsStocks(int [] input) {
		if(input == null || input.length == 0) {
			return 0;
		}
		int len = input.length;
		int maxProfit = 0;
		int [][]temp = new int[len][len];
		for(int i = 0; i < len; i++) {
			temp[0][i] = input[i] - input[0];
		}
		for(int i = 1; i < len; i++) {
			for(int j = i; j < len; j++) {
				temp[i][j] = Integer.max(temp[i-1][j], input[j] - input[i]);
			}
		}
		Stack<Integer> stk = new Stack<>();
		stk.push(temp[len - 1][len - 1]);
		int pre = len - 1;
		int maxOnePofit = 0;
		for(int i = 0; i < len; i++) {
			if(temp[i][i] > 0 && maxOnePofit < temp[i][i]) {
				maxOnePofit = temp[i][i];
			}
		}
		System.out.println("Max profit in one transaction is: \t"+maxOnePofit);
		for(int i = len - 2; i >= 0; i--) {
			if(temp[i][i] > 0) {
				if(i + 1 < pre){
					stk.push(temp[i][i]);
					pre = i;
				}
				else if(temp[i][i] > stk.peek()) {
					stk.pop();	
					stk.push(temp[i][i]);
					pre = i;
				}
			}
		}
		
		while(!stk.empty()) {
			maxProfit += stk.pop();
		}
		
		return maxProfit;
	}
	
}