package Arrays;

public class RearrangePositiveNegative {
	
	public static void main(String args[]) {
		RearrangePositiveNegative rearrangePositiveNegative = new RearrangePositiveNegative();
		int []input = new int[]{-1,3,2,4,5,-6,7,-9};
		int [] output = rearrangePositiveNegative.rearrangePosNeg(input);
		if(output == null) {
			System.out.println("Input is wrong");
		}
		else {
			for(int no: output) {
				System.out.print(no+"\t");
			}
		}
		
	}
	
	public int [] rearrangePosNeg(int input[]) {
		if(input == null || input.length == 0) {
			return null;
		}
		int len = input.length;
		int [] output = new int[len];
		int [] tempP = new int[len];
		int [] tempN = new int[len];
		int cp = 0, cn = 0;
		for(int i = 0; i < len; i++) {
			if(input[i] < 0) {
				tempN[cn++] = input[i];
			}
			else {
				tempP[cp++] = input[i];
			}
		}
		int n1 = 0, p1 = 0, cnt = 0;
		while(n1 < cn && p1 < cp) {
			if(cnt % 2 == 0) {
				output[cnt++] = tempP[p1++];
			}
			else {
				output[cnt++] = tempN[n1++];
			}
		}
		
		while(n1 < cn) {
			output[cnt++] = tempN[n1++];
		}
		
		while(p1 < cp) {
			output[cnt++] = tempP[p1++];
		}
		
		return output;
	}
	
}