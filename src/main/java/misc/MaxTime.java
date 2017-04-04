package misc;

import java.util.Arrays;

public class MaxTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxTime maxTime = new MaxTime();
		int input [] = new int[]{1,2,3,4};
		System.out.println("Max time is: "+ maxTime.getTime(input));

	}
	
	public String getTime(int [] input) {
		StringBuilder sb = new StringBuilder();
		if(input == null || input.length != 4) {
			return "Wrong input";
		}
		
		int index = 0;
		Arrays.sort(input);
		
		if(isExist(input,2)) {
			sb.append("2");
			
		}
		else if(isExist(input,1)) {
			sb.append("1"+input[3]);
			input[3] = -1;
		}
		else if(isExist(input,0)) {
			sb.append("0"+input[3]);
			input[3] = -1;
		}
		for(int i = 0; i < 4; i++) {
			if(isExist(input,2)) {
				sb.append("2");
				
			}
		}
		
		return null;
	}
	
	public boolean isExist(int [] input, int no) {
		
		return false;
	}

}
