package Arrays;

public class SearchSortedMatrix {
	
	public static void main(String [] args) {
		SearchSortedMatrix searchSortedMatrix = new SearchSortedMatrix();
		int[][] mat =  {   { 2, 6, 7, 11},
                { 3, 8, 10, 12},
                { 4, 9, 11, 13},
                { 5, 15, 16, 18}
                };
		int num = 18;
		System.out.println("Search sorted matrix: \t"+searchSortedMatrix.searchMat(mat, num));
	}
	
	public boolean searchMat(int [][] mat, int num) {
		if(mat == null || mat.length == 0) {
			return false;
		}
		int row = mat.length;
		int col = mat[0].length;
		int i = 0, j = col - 1;
		while(i < row && j >= 0) {
			if(mat[i][j] == num) {
				return true;
			}
			else if(mat[i][j] > num) {
				j--;
			}
			else {
				i++;
			}
		}
		
		
		return false;
	}
	
}