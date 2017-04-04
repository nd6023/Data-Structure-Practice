package Arrays;

import java.util.ArrayList;
import java.util.List;

public class RainWater {
	
	public static void main(String args[]) {
		
		RainWater rainWater = new RainWater();
		int [] input = {1,5,2,3,1,7,2};
		System.out.println("Amount of water harvested between the buildings are:\t"+rainWater.calStoredRainWater(input));
		
	}
	
	public int calStoredRainWater(int [] input) {
		
		if(input == null || input.length == 0) {
			return 0;
		}
		List<Integer> tempList = new ArrayList<>();
		int maxWaterStored = 0;
		int len = input.length;
		for(int i = 1; i < len-1; i++) {
			if(input[i] > input[i-1] && input[i] > input[i+1]) {
				tempList.add(i);
			}
		}
		int size = tempList.size();
		if(size < 2) {
			return 0;
		}
		int cur = tempList.get(0), next = tempList.get(1), nxc = 2, pre = cur;
		while(cur < tempList.get(size-1)){
			if(cur >= next) {
				pre = next;
				next = tempList.get(nxc++);
			}
			 
			maxWaterStored = Integer.min(tempList.get(pre), tempList.get(next)) - input[cur];
			cur++;
		}
		
		
		
		return maxWaterStored;
	}
	
}