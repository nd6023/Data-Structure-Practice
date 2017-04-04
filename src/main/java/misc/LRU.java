package misc;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

	Map<String, String> myMap = new LinkedHashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LRU lru = new LRU();
		int size = 3;
		lru.cache(lru.myMap, size);

	}
	
	public void cache(Map<String, String> myMap, int size) {
		
		int mapSize = myMap.size();
		if(mapSize <= size) {
			// put vales
		}
		else {
			// remove values;
			//myMap.
		}
		
	}

}
