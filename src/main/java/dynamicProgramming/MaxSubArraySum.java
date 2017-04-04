package dynamicProgramming;

public class MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
		//int [] input = new int[]{2,-9,5,1,-4,6,0,-7,8};
		int [] input = new int[]{-2,-9,-5,-1,-4};
		System.out.println(maxSubArraySum.maxSum(input));

	}
	
	public int maxSum(int [] input) {
		if(input == null || input.length == 0) {
			return 0;
		}
		int len = input.length, maxVal = Integer.MIN_VALUE, curVal = 0;
		for(int i = 0; i < len; i++) {
			curVal += input[i];
			if(maxVal < curVal) {
				maxVal = curVal;
			}
			if(curVal < 0) {
				curVal = 0;
			}
		}
		return maxVal;
	}

}
