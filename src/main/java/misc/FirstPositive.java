package misc;

public class FirstPositive {

	// This is the text editor interface.
	// Anything you type or change here will be seen by the other person in real
	// time.
	//
	// Given an unsorted integer array, find the first missing positive integer.
	// For example,
	// Given [1,2,0] return 3,
	// and [3,4,-1,1] return 2.
	// [1,2,3,4,5]
	// [9873, 1, 5]
	//
	// Runtime O(n), and constant space

	
	// The missing positive val will always be in the range of [0......length of input array]
	// So find sum of all values in that range in array and sum of arithmatic progression [1,2,3,..... input.length]
	// diff of sumAP and sumInputRange is answer
	
	public static void main(String[] args) {
		FirstPositive firstPositive = new FirstPositive();
		int input[] = new int[] {9873, 1, 5};
		System.out.println("Value is \t" + firstPositive.firstPositiveInt(input));
	}

	public int firstPositiveInt(int[] input) {

		if (input == null || input.length == 0) {
			return 1;
		}

		int len = input.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		//find sum of all positive values, min and max among all elements in the range of [1....input.length+1]
		for (int i = 0; i < len; i++) {
			if (input[i] > 0 && input[i] <= len + 1) {
				sum += input[i];

				if (max < input[i]) {
					max = input[i];
				}
				if (min > input[i]) {
					min = input[i];
				}
			}
		}

		//if all values are negative or min positive val is greater than 1
		if (max <= 0 || min > 1) {
			return 1;
		}

		// sum of AP [1 .... max]
		int requiredSum = (max + 1) * max / 2;

		int diff = requiredSum - sum;
		if (diff == 0) {
			return ++max;
		}
		
		return diff;
	}
}