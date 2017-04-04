package Strings;

public class PatternMatching {

	public static void main( String [] args) {
		PatternMatching patternMatching = new PatternMatching();
		String input = "xaylmzsdf";
		String pat = "x?y*z*";
		System.out.println("\nDoes the input string follows the pattren?\t "+patternMatching.matchPat(input.toCharArray(), pat.toCharArray()));
	}
	
	public boolean matchPat(char [] input, char [] pat) {
		if(input == null || input.length == 0 || pat == null || pat.length == 0) {
			return false;
		}
		
		int temp = 1;
		for(int i = 1; i < pat.length; i++) {
			if(!(pat[i] == '*' && pat[i] == pat[i - 1])) {
				pat[temp] = pat[i];
				temp++;
			}
		}

		int lenP = temp, lenS = input.length;
		
		boolean res [][] = new boolean[lenS+1][lenP+1];
		
		res[0][0] = true;
		if(pat[0] == '*') {
			res[0][1] = true;
		}
		
		for(int i = 1; i <= lenS; i++) {
			for(int j = 1; j <= lenP; j++) {
				if((input[i - 1] == pat[j - 1]) || pat[j - 1] == '?') {
					res[i][j] = res[i - 1][j - 1];
				}
				else if(pat[j - 1] == '*') {
					res[i][j] = res[i - 1][j] || res[i][j - 1];
				}
			}
		}
		
		return res[lenS][lenP];
	}
	
}
