package dynamicProgramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
		String s1 = "ACBEA";
		String s2 = "ADCA";
		System.out.println("The Longest Common Subsequence: "+longestCommonSubsequence.longestSubsequence(s1, s2));

	}
	
	public String longestSubsequence(String s1, String s2) {
		if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
			return null;
		}
		int len1 = s1.length(), len2 = s2.length();
		int tempAr[][] = new int[len1+1][len2+1];
		String tempPtr[][] = new String[len1+1][len2+1];
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					tempAr[i][j] = tempAr[i-1][j-1] + 1;
					tempPtr[i][j] = "S1S2";
				}
				else {
					tempAr[i][j] = Math.max(tempAr[i-1][j], tempAr[i][j-1]);
					if(tempAr[i-1][j] > tempAr[i][j-1]) {
						tempPtr[i][j] = "S2";
					}
					else {
						tempPtr[i][j] = "S1";
					}
				}
			}
		}
		System.out.println(tempAr[len1][len2]);
		int i = len1, j = len2;
		while(i > 0 && j > 0 ) {
				switch(tempPtr[i][j]) {
				case "S1":
					j--;
					break;
				case "S2" :
					i--;
					break;
				case "S1S2" :
					sb.append(s1.charAt(i-1));
					i--;
					j--;
					break;
				default: System.out.println("Wrong choice baby!!!");
					i--;
					j--;
				}
			
		}
		return sb.reverse().toString();
	}

}
