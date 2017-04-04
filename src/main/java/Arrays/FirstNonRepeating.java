package Arrays;

public class FirstNonRepeating {
	
	public static void main(String args[]) {
		FirstNonRepeating firstNonRepeating = new FirstNonRepeating();
		String input = "ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB";
		System.out.println("First non-repeating element is: \t"+firstNonRepeating.firstNR(input));
	}
	
	public char firstNR(String input) {
		if(input == null || input.length() == 0) {
			return '?';
		}
		int len = input.length();
		int temp[] = new int[26];
		for(int i = 0; i < 26; i++) {
			temp[i] = -10;
		}
		for(int i = 0; i < len; i++) {
			if(temp[input.charAt(i) - 'A'] == -10) {
				temp[input.charAt(i) - 'A'] = i;
			}
			else {
				temp[input.charAt(i) - 'A'] = -1;
			}
		}
		int firstEle = Integer.MAX_VALUE;
		char firstEleVal = 0;
		for( int i = 0; i < 26; i++) {
			if(temp[i] > 0 && firstEle > temp[i]) {
				firstEle = temp[i];
				firstEleVal = (char) (i + 'A');
			}
		}
		return firstEleVal;
	}
	
	
}