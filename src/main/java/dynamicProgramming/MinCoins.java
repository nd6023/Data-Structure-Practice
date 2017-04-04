package dynamicProgramming;

public class MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCoins minCoins = new MinCoins();
		int coins[] = new int []{2, 5, 3, 7};
		int sum = 3;
		System.out.println("The min number of coins are: "+minCoins.calMinCoins(coins, sum));

	}
	
	public int calMinCoins(int coins[], int sum) {
		if(coins == null || coins.length == 0 || sum <1) {
			return 0;
		}
		int len = coins.length, lenC = sum + 1;
		int temp [][] = new int [len][lenC];
		for(int i = 0; i < lenC; i++) {
			if(coins[0] > i) {
				temp[0][i] = 0;
			}
			/*
			else if((temp[0][i - coins[0]] == 0) && (i - coins[0])!=0){
				temp[0][i] = 0;
			}
			*/
			else {
				temp[0][i] = temp[0][i-coins[0]] + 1;
			}
			
		}
		for(int i = 1; i < len; i++) {
			for(int j = 0; j < lenC; j++) {
				if(j == 0) {
					temp[i][j] = 0;
				}
				else {
					if(coins[i] > j) {
						temp[i][j] = temp[i-1][j];
					}
					/*
					else if((temp[i][j - coins[i]] == 0) && (j - coins[i])!=0){
						temp[i][j] = 0;
					}
					*/
					else {
						temp[i][j] = Math.min(temp[i-1][j], temp[i][j-coins[i]] + 1);
					}
				}
			}
		}
		return temp[len-1][sum];
	}

}
