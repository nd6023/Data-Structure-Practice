package Arrays;

public class MissingNumber {
	
	public static void main(String [] args) {
		MissingNumber missingNumber = new MissingNumber();
		int [] ar1 = new int[]{9, 7, 8, 5, 4, 6, 2, 3, 1};
		int [] ar2 = new int[]{2, 4, 3, 9, 1, 8, 5, 6};
		System.out.println("The missing number is: \t"+missingNumber.findMissingNumber(ar1, ar2));
	}
	
	public int findMissingNumber(int [] ar1, int [] ar2) {
		int temp = 0;
		for(int no1 : ar1) {
			temp ^= no1;
		}
		for(int no2 : ar2) {
			temp ^= no2;
		}
		return temp;
	}
	
}