package tree;

import java.util.ArrayList;
import java.util.List;

public class HeapArray {
	
	public List<Integer> heapList;
	
	public HeapArray() {
		heapList = new ArrayList<>();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapArray heapArray = new HeapArray();
		int input [] = new int[]{13, 8, 3, 6, 1, 20, 9, 5, 7, 2};
		heapArray.createHeap(input);
		for(int no : heapArray.heapList) {
			System.out.print("\t"+no);
		}
		System.out.println("");
		heapArray.remove(20);
		for(int no : heapArray.heapList) {
			System.out.print("\t"+no);
		}
		

	}
	
	public void remove(int no) {
		if(!heapList.contains(no)) {
			return;
		}
		int size = heapList.size();
		int ind = heapList.indexOf(no);
		
		heapList.set(ind, heapList.get(size - 1));
		heapList.remove(size - 1);
		shiftDown(ind);
		
		
		
	}
	
	public void shiftDown(int ind) {
		int cur = heapList.get(ind);
		int size = heapList.size();
		int ch1 = (ind * 2) + 1;
		int ch2 = (ind * 2) + 2;
		int temp = 0;
		if(ch2 > size -1 && ch1 > size - 1) {
			return;
		}
		else if(ch2 > size -1) {
			temp = ch1;
		}
		else {
			if(heapList.get(ch1) > heapList.get(ch2)) {
				temp = ch1;
			}
			else {
				temp = ch2;
			}
		}
		if(cur < heapList.get(temp)) {
			int t1 = heapList.get(temp);
			heapList.set(temp, heapList.get(ind));
			heapList.set(ind, t1);
			shiftDown(temp);
		}
		else {
			return;
		}
		
	}
	
	public void createHeap(int [] input) {
		
		int len = input.length;
		for(int i = 0; i < len; i++) {
			heapList.add(input[i]);
			shiftUp(i);
			
		}
		
	}
	
	public void shiftUp(int ind) {
		int size = heapList.size();
		if(size <= 1 || ind < 1) {
			return;
		}
		int par = (ind - 1)/2;
		if(heapList.get(ind) <= heapList.get(par)) {
			return;
		}
		int temp = heapList.get(par);
		heapList.set(par, heapList.get(ind));
		heapList.set(ind, temp);
		shiftUp(par);
	}

}
