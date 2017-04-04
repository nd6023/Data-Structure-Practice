package Arrays;

public class LongestSubstring {
	
	public static void main(String [] args) {
		LongestSubstring longestSubstring =new LongestSubstring();
		String input = "ABCDABDEFGCABD";
		input = input.toLowerCase();
		System.out.println("The longest substring without non repeating charectors is: \t"+longestSubstring.longSub(input));
	}
	
	public String longSub(String input) {
		if(input == null || input.length() == 0) {
			return null;
		}
		int alpha [] = new int[26];
		for(int i = 0; i < 26; i++) {
			alpha[i] = -1;
		}
		int len = input.length(), minLast = 0;
		int temp [] = new int[len];
		for(int i = 0; i < len; i++) {
			if(alpha[input.charAt(i) - 'a'] == -1) {
				alpha[input.charAt(i) - 'a'] = i;
				if(i==0) {
					temp[i] = 1;
				}
				else{
					temp[i] = temp[i-1] + 1;
				}
			}
			else {
				int lastRep = Math.max(minLast, alpha[input.charAt(i) - 'a']);
				minLast = lastRep;
				temp[i] = i - lastRep;
				alpha[input.charAt(i) - 'a'] = i;
			}
			
		}
		int index = -1, max = -1;
		for(int i = 0; i < len; i++) {
			if(temp[i] > max) {
				max = temp[i];
				index = i;
			}
		}
		return input.substring(index-max + 1, index + 1);
	}
	
}