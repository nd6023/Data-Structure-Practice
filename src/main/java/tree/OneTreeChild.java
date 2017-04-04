package tree;

public class OneTreeChild {

	public static void main(String[] args) {
		OneTreeChild oneTreeChild = new OneTreeChild();
		int input[] = {9,8,5,7,6};
		int input2[] = {8,5,4,7,6};
		System.out.println("Is the given preorder traversal of the tree contains on one child:\t"+oneTreeChild.checkOneChild(input2));

	}
	
	public boolean checkOneChild(int input[]) {
		
		if(input == null || input.length == 0) {
			return false;
		}
		int len = input.length;
		boolean res = true;
		
		int min = input[len-1], max = input[len-1];
		for(int i = len - 2; i >= 0; i--) {
			if(!(input[i] > max || input[i] < min)) {
				return false;
			}
			min = Integer.min(min,  input[i]);
			max = Integer.max(max,  input[i]);
		}
		
		return res;
	}

}
