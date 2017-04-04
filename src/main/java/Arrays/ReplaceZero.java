package Arrays;

public class ReplaceZero {
	
	public static void main(String []args) {
		ReplaceZero replaceZero = new ReplaceZero();
		int input [] = {0,0,1,1,1,1,0,0,1,1,1,1,0,1,1,0,1,0,1,1,1,1,0};
		System.out.println("Max length optained after replacing zero is: \t"+replaceZero.repZero(input));
	}
	
	public int repZero(int [] input) {
		if(input == null || input.length ==0) {
			return 0;
		}
		int len = input.length;
		int start = 0, end = len, initial = 0;
		if(input[0] == 0) {
			start = 0;
			end = len;
		}
		else {
			start = 1;
			end = len + 1;
		}
		initial = start;
		int temp [] = new int[end];
		temp[start] = 1;
		for(int i = 1; i < len; i++) {
			if(input[i - 1] == input[i]) {
				temp[start]++;
			}
			else {
				temp[++start]++;
			}
		}
		
		int sum = 0, maxSum = 0, finalInd = 0;
		for(int i = initial; i <= start; i++) {
			finalInd += temp[i];
			if(i % 2 == 0 && temp[i] == 1) {
				if(i == 0) {
					sum = temp[i+1]+1;
				}
				else{
					sum = temp[i+1]+1+temp[i-1];
				}
				if(maxSum < sum) {
					maxSum = sum;
					finalInd += i;
				}
			}
		}
		
		return finalInd;
	}
	
}