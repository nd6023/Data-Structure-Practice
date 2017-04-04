package dynamicProgramming;

public class Fibonacci {
	
	public static void main(String args[]) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println("The Fibonacci value is: "+fibonacci.findFibo(6));
	}
	
	public int findFibo(int no) {
		
		if(no < 0) {
			return 0;
		}
		if(no == 0) {
			return 0;
		}
		if(no == 1) {
			return 1;
		}
		int a = 0, b = 1, c = 0;
		for(int i = 2; i <= no; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}

}
