package Arrays;

public class MaxSum {
	
	public static void main( String args[] ) {
		MaxSum maxSum = new MaxSum();
		int [] input = new int[]{2, -9, 5, 1, -4, 6, 0, -7, 8};
		System.out.println("The max sum is: \t"+maxSum.calMaxSum(input));
	}
	
	public int calMaxSum(int [] input) {
		if(input == null || input.length == 0) {
			return 0;
		}
		
		int len = input.length, maxSum = Integer.MIN_VALUE, sum = 0;
		for(int i = 0; i < len; i++) {
			sum += input[i];
			if(maxSum < sum) {
				maxSum = sum;
			}
			if(sum <= 0) {
				sum = 0;
			}
		}
		
		
		return maxSum;
		
	}
	
}