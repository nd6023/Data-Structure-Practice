package misc;

public class Arithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arithmetic arithmetic = new Arithmetic();
		String input = "2*3+5/6*3+15";
		System.out.println("The result is \t:"+arithmetic.calExp(input));

	}
	
	public double calExp(String input) {
		
		if(input == null || input.length() == 0) {
			return 0;
		}
		
		int len = input.length();
		
		//if()
		
		return 0;
		
	}

}
