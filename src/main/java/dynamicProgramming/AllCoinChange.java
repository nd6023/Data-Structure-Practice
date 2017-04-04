package dynamicProgramming;

public class AllCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllCoinChange allCoinChange = new AllCoinChange();
		int coins[] = new int[]{1,2,3};
		int sum = 5;
		System.out.println("Total number of ways to get the sum: "+ allCoinChange.coinChange(coins, sum));

	}
	
	public int coinChange(int [] coins, int sum) {
		if(coins == null || coins.length == 0 || sum <=0) {
			return 0;
		}
		int lenR = coins.length;
		int lenC = sum + 1;
		int temp[][] = new int[lenR][lenC];
		for(int j = 0; j < lenC; j++) {
			if(coins[0] > j) {
				temp[0][j] = 0;
			}
			else {
				temp[0][j] = 1;
			}
		}
		for(int i = 1; i < lenR; i++) {
			for(int j = 0; j < lenC; j++) {
				if(j == 0) {
					temp[i][j] = 1;
				}
				else if(coins[i] > j) {
					temp[i][j] = temp[i-1][j];
				}
				else {
					temp[i][j] = temp[i-1][j] + temp[i][j-coins[i]];
				}
			}
		}
		
		return temp[lenR-1][lenC-1];
	}

}
