package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubstring {

	public static void main(String args[]) {
		LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
		String s1 = "CLCL";
		String s2 = "LCLC";
		System.out.println("Longest Common Substring: ");
		List<String> myList = longestCommonSubstring.longestSubstring(s1, s2);
		if(myList!=null){
			for(String str: myList) {
				System.out.println(str);
			}
		}
	}
	
	public List<String> longestSubstring(String s1, String s2) {
		List<String> myList = null;
		StringBuilder sb = new StringBuilder();
		if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
			return myList;
		}
		int len1 = s1.length(), len2 = s2.length(), max = -1;
		int [][] tempArr = new int[len1 + 1][len2 + 1];
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					tempArr[i][j] = tempArr[i-1][j-1] + 1;
				}
				if(tempArr[i][j] > max) {
					max = tempArr[i][j];
					myList = new ArrayList<>();
					myList.add(s1.substring(i-max, i));
				}
				else if(tempArr[i][j] == max) {
					myList.add(s1.substring(i-max, i));
				}
			}
		}
		return myList;
	}
}
