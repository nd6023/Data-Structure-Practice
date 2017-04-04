package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import tree.HeapArray;

// Incomplete

public class MostFrequent {
	
	public static void main(String args[]) {
		MostFrequent mostFrequent = new MostFrequent();
		int input[] = new int[]{};
		int rank = 1;
		System.out.println("The "+rank+" frequent elemets are:\t"+mostFrequent.calMosFrequent(input,rank));
	}
	
	public String calMosFrequent(int [] input, int rank) {
		if(input == null || input.length == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int len = input.length;
		
		
		Map<Integer, Integer> myMap = new HashMap<>();
		
		for(int i = 0; i < len; i++) {
			if(myMap.containsKey(input[i])) {
				myMap.put(input[i], myMap.get(input[i]) + 1);
			}
			else {
				myMap.put(input[i],  1);
			}
		}
		Iterator<Entry<Integer, Integer>> itr = myMap.entrySet().iterator();
		
		Map<Integer, Integer> treeMap = new TreeMap<>();
		
		while(itr.hasNext()) {
			Map.Entry<Integer, Integer> tempMap = itr.next();
			treeMap.put(tempMap.getValue(), tempMap.getKey());
		}
		
		Iterator<Entry<Integer, Integer>> itrTree = treeMap.entrySet().iterator();
		
		while(itrTree.hasNext()) {
			Map.Entry<Integer, Integer> myMapItr = itrTree.next();
			
		}
		
		return sb.toString();
	}
	
}