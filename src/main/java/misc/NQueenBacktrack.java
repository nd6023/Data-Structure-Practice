package misc;

import java.util.ArrayList;
import java.util.List;

public class NQueenBacktrack {
	
	class Location {
		int x;
		int y;
		
		Location() {
			x = -1;
			y = -1;
		}
		
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) {
		NQueenBacktrack nQueenBacktrack = new NQueenBacktrack();
		int size = 4;
		Location [] resultLoc = new Location[size];
		if(!nQueenBacktrack.placeQueen(resultLoc, size)) {
			System.out.println("The queens could not be placed");
		}
		else {
			for(Location loc: resultLoc) {
				System.out.println(loc.x+"\t"+loc.y);
			}
		}
		

	}
	
	public boolean placeQueen(Location [] resLoc, int size) {
		
		boolean safeFlag = placeQueenUtil(resLoc, size, 0);
		if(safeFlag) {
			return true;
		}
		resLoc = new Location[0];	
		return false;
	}
	
	public boolean placeQueenUtil(Location resLoc [], int n, int row) {
		if(n == row) {
			return true;
		}
		int col = 0;
		for(col = 0; col < n; col++) {
			boolean foundSafe = true;
			for(int queen = 0; queen < n; queen++) {
				if((col == resLoc[queen].y) ) {
					foundSafe = false;
					break;
				}
			}
			if(foundSafe) {
				resLoc[row] = new Location(row, col);
				if(placeQueenUtil(resLoc, n, row + 1)) {
					return true;
				}
			}
		}
		return false;
	}

}
