package Arrays;

public class CalSquareSorted {

	public static void main(String[] args) {
		CalSquareSorted calSquareSorted = new CalSquareSorted();
		int [] input = new int[]{-5, -3, -1, 2, 4, 7};
		int [] output = calSquareSorted.calSquare(input);
		if(output != null){
			for(int no : output) {
				System.out.print(no + "\t");
			}
		}
		else {
			System.out.println("Wrong input");
		}
		

	}
	
	public int [] calSquare(int input []) {
		if(input == null || input.length == 0) {
			return null;
		}
		int len = input.length;
		int output[] = new int[len];
		
		int index = findFirstPositive(input, 0, len-1);
		int left = 0, right = 0, cur = 0;
		if(index > 0 && index < len) {
			left = index -1;
		}
		else {
			left = -1;
		}
		if(index < len) {
			right = index;
		}
		else {
			right = len;
		}
		while(left >= 0 && right < len) {
			int left2 = input[left] * input[left];
			int right2 = input[right] * input[right];
			if(left2 < right2) {
				output[cur] = left2;
				cur++;
				left--;
			}
			else {
				output[cur] = right2;
				cur++;
				right++;
			}
			
		}
		
		while(left >= 0) {
			int left2 = input[left] * input[left];
			output[cur] = left2;
			cur++;
			left--;
		}
		
		while(right < len) {
			int right2 = input[right] * input[right];
			output[cur] = right2;
			cur++;
			right++;
		}
		return output;
	}
	
	public int findFirstPositive(int [] input, int start, int end) {
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(input[mid] > 0) {
				if(mid - 1 >= 0 && input[mid-1] > 0) {
					end = mid -1;
				}
				else {
					return mid;
				}
			}
			else {
				start = mid + 1;
			}
		}
		return 0;
		
	}

}
