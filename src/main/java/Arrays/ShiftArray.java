package Arrays;

public class ShiftArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShiftArray shiftArray = new ShiftArray();
		int myAr[] = new int[]{1,2,3,4,5,6,7};
		int shift = 1;
		int len = myAr.length - 1;
		shift %= len;
		shiftArray.shAr(myAr, 0, len);
		shiftArray.shAr(myAr, 0, shift-1);
		shiftArray.shAr(myAr, shift, len);
		for(int no: myAr) {
			System.out.print(no);
		}
	}
	
	public void shAr(int [] myAr, int start, int end) {
		int temp = 0;
		while(start <= end) {
			temp = myAr[start];
			myAr[start] = myAr[end];
			myAr[end] = temp;
			++start;
			--end;
		}
	}

}
