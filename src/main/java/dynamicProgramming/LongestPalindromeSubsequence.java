package dynamicProgramming;

public class LongestPalindromeSubsequence {

	public static void main(String[] args) {
		LongestPalindromeSubsequence longestPalindromeSubsequence = new LongestPalindromeSubsequence();
		String input = "LPSSAPAL";
		System.out.println("The Longest Palindrome Subsequence: "+ longestPalindromeSubsequence.longestPaliSubsequence(input));
	}

public int longestPaliSubsequence(String input) {
		
		if(input == null || input.length() == 0) {
			return 0;
		}
		
		int len = input.length();
		int tempAr[][] = new int[len][len];
		
		for(int i = 0; i < len; i++) {
			tempAr[i][i] = 1;
		}
		
		for(int cL = 2; cL <= len; cL++) {
			for(int i = 0; i < len - cL + 1; i++) {
				int j = i + cL - 1;
				if(input.charAt(i)==input.charAt(j)) {
					tempAr[i][j] = tempAr[i+1][j-1] + 2;
				}
				else {
					tempAr[i][j] = Math.max(tempAr[i][j-1], tempAr[i+1][j]);
				}
			}
		}
		return tempAr[0][len-1];
	}
}
