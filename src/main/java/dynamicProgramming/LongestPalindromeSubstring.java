package dynamicProgramming;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
		String str = "BANANA";
		System.out.println("Longest Palindrome Substring: " + longestPalindromeSubstring.longestPaliSubstring(str));
	}
	
	public String longestPaliSubstring(String input) {
		
		if(input == null || input.length() == 0) {
			return null;
		}
		int len = input.length();
		int start = 0, maxL = 0;
		boolean tempAr[][] = new boolean[len][len];
		for(int i =0; i < len; i++) {
			tempAr[i][i] = true;
		}
		
		for(int i = 0; i < len-1; i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				tempAr[i][i+1] = true;
			}
		}
		
		for(int cL = 3; cL <= len; cL++) {
			for(int i = 0; i < len - cL + 1; i++) {
				int j = i + cL - 1;
				if((input.charAt(i) == input.charAt(j)) && tempAr[i+1][j-1]) {
					tempAr[i][j] = true;
					if(maxL < cL) {
						maxL = cL;
						start = i;
					}
				}
			}
		}
		
		return input.substring(start, maxL+1);
	}

}
