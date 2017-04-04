package Arrays;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static final int EMPTY = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		int ar1[] = new int[]{1,EMPTY, 3, 5, EMPTY, EMPTY, EMPTY, EMPTY, 7};
		int ar2[] = new int[]{-1, 0, 4, 6, 10};
		mergeSortedArray.mergeArr(ar1, ar2);
		for(int no: ar1) {
			System.out.print("\t"+no);
		}
	}
	
	public void mergeArr(int ar1[], int ar2[]) {
		int l1 = ar1.length - 1, l2 = ar2.length - 1;
		int validInd = l1, i = 0;
		for(i = l1; i >= 0; i--) {
			if(ar1[i] != EMPTY) {
				ar1[validInd] = ar1[i];
				--validInd;
			}
		}
		i = validInd + 1;
		int j = 0, k = 0;
		while(i <= l1 && j <= l2) {
			if(ar1[i] < ar2[j]) {
				ar1[k] = ar1[i];
				i++;
				k++;
			}
			else {
				ar1[k] = ar2[j];
				k++;
				j++;
			}
		}
		while(j <= l2) {
			ar1[k] = ar2[j];
			k++;
			j++;
		}
	}
	

}
