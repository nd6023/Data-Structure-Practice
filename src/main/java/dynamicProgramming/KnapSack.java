package dynamicProgramming;

public class KnapSack {
	
	public static void main( String args []) {
		KnapSack knapSack = new KnapSack();
		int [] val = {3,7,2,9};
        int [] weight = {2,2,4,5};
           
        int weightLimit = 10;
        System.out.println("Max proft: "+ knapSack.maxProfit(weight, val, weightLimit));
        
	}
	
	public int maxProfit(int [] weight, int [] val, int  weightLimit) {
		
		if(weight == null || weight.length == 0 || val == null || val.length == 0 || weight.length != val.length ) {
			return 0;
		}
		
		int len = weight.length;
		int tempAr [][] = new int[len + 1][weightLimit + 1];
		for(int i=0; i<=len; i++) {
			for(int j=0; j<=weightLimit; j++) {
				if(i==0 || j==0) {
					tempAr[i][j] = 0;
				}
				else if(weight[i-1] > j) {
					tempAr[i][j] = tempAr[i-1][j];
				}
				else {
					tempAr[i][j] = Math.max(tempAr[i-1][j], val[i-1] + tempAr[i-1][j-weight[i-1]]);
				}
			}
		}
		
		return tempAr[len][weightLimit];
	}

}
