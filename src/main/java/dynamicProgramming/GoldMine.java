package dynamicProgramming;

public class GoldMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoldMine goldMine = new GoldMine();
		int[][] mine = { { 1, 3, 1, 5 }, 
                { 2, 2, 4, 1 }, 
                { 5, 0, 2, 3 },
                { 0, 6, 1, 2 } };
	
		System.out.println(goldMine.calGoldMine(mine));

	}
	
	public int calGoldMine(int [][]mine) {
		if(mine == null || mine.length == 0) {
			return 0;
		}
		int lenR = mine.length, lenC = mine[0].length;
		int res[][] = new int[lenR][lenC];
		for(int i = 0; i < lenR; i++) {
			res[i][lenC - 1] = mine[i][lenC - 1];
		}
		for(int j = lenC - 2; j >= 0; j--) {
			for(int i = 0; i < lenR; i++) {
				if(i == 0 && i != lenR - 1) {
					res[i][j] = mine[i][j] + Math.max(res[i][j+1], res[i+1][j+1]);
				}
				else if(i != 0 && i == lenR - 1) {
					res[i][j] = mine[i][j] + Math.max(res[i][j+1], res[i-1][j+1]);
				}
				else if(i == 0 && i == lenR - 1) {
					res[i][j] = mine[i][j] + res[i][j+1];
				}
				else {
					res[i][j] = mine[i][j] + Math.max(Math.max(res[i][j+1], res[i+1][j+1]), res[i-1][j+1]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < lenR; i++) {
			if(max < res[i][0]) {
				max = res[i][0];
			}
		}
		return max;
		
	}

}
