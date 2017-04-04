package Arrays;

public class MaxSubArray {
	
	public static void main( String [] args) {
		MaxSubArray maxSubArray = new MaxSubArray();
		int [] input = new int[]{11, -8, 16, -7, 24, -2, 3};
		int size = 3;
		System.out.println("Max average subarray of size is : \t");
		int [] output = maxSubArray.maxSubArray(input, size);
		if(output == null) {
			System.out.println("Input error!");
		}
		else {
			for(int no : output) {
				System.out.println(no+"\t");
			}
		}
	}
	
	public int [] maxSubArray(int [] input, int size) {
		if(input == null || input.length ==0) {
			return null;
		}
		int len = input.length, sum = 0, maxSum = Integer.MIN_VALUE, cnt = 0;
		int [] temp = new int[size];
		int [] subArr = new int[size];
		for(int i = 0; i < len - size; i++) {
			for(int j = i; j < i + size; j++) {
				sum += input[j];
				temp[cnt++] = input[j];
			}
			if(maxSum < sum) {
				maxSum = sum;
				for(int z = 0; z < size; z++) {
					subArr[z] = temp[z];
				}
			}
			sum = 0;
			cnt = 0;
		}
		return subArr;
	}
	
}