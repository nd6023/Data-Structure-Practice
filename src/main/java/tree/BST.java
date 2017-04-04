package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

	public static void main(String[] args) {
		BST bst = new BST();
		TreeNode root = new TreeNode(50);
		System.out.println("Creating BST ...");
		bst.createBST(root);
		System.out.println("\nCheck is it a BST?\t"+bst.isBST(root));
		System.out.println("\nLevel order traversal of BST:\n");
		bst.printLevelBST(root);
		int element1 = 29;
		System.out.println("\nInserting element "+element1+" into BST");
		bst.insert(root, element1);
		int element2 = 23;
		System.out.println("\nInserting element "+element2+" into BST");
		bst.insert(root, element2);
		int element3 = 63;
		System.out.println("\nInserting element "+element3+" into BST");
		bst.insert(root, element3);
		System.out.println("\nCheck is it a BST?\t"+bst.isBST(root));
		System.out.println("\nLevel order traversal of BST:\n");
		bst.printLevelBST(root);
		int elementD1 = 23;
		System.out.println("\nDeleting element "+elementD1+" from BST");
		bst.delete(root, elementD1);
		int elementD2 = 75;
		System.out.println("\nDeleting element "+elementD2+" from BST");
		bst.delete(root, elementD2);
		int elementD3 = 24;
		System.out.println("\nDeleting element "+elementD3+" from BST");
		bst.delete(root, elementD3);
		System.out.println("\nCheck is it a BST?\t"+bst.isBST(root));
		System.out.println("\nLevel order traversal of BST:\n");
		bst.printLevelBST(root);
	}
	
	public void createBST(TreeNode root) {
		
		TreeNode n1   = new TreeNode(24);
        TreeNode n2   = new TreeNode(60);
        TreeNode n3   = new TreeNode(20);
        TreeNode n4   = new TreeNode(27);
        TreeNode n5   = new TreeNode(52);
        TreeNode n6   = new TreeNode(21);
        TreeNode n7   = new TreeNode(58);
        TreeNode n8   = new TreeNode(22);
        TreeNode n9   = new TreeNode(56);
        TreeNode n10   = new TreeNode(9);
        TreeNode n11   = new TreeNode(75);
         
        root.setLeft(n1);  
        root.setRight(n2); 
         
        n1.setLeft(n3); 
        
        n1.setRight(n4);
         
        n2.setLeft(n5); 
        
        n2.setRight(n11);
         
        n3.setRight(n6); 
        
        n3.setLeft(n10);
         
        n5.setRight(n7);
         
        n6.setRight(n8); 
        
        n7.setLeft(n9);
		
	}
	
	public boolean isBST(TreeNode root) {
		if(root == null || (root.getLeft() == null && root.getRight() == null)) {
			return true;
		}
		boolean resLeft = true, resRight = true;
		if(root.getLeft() != null) {
			if(root.getData() > root.getLeft().getData()) {
				resLeft = true;
			}
			else {
				resLeft = false;
			}
		}
		
		if(root.getRight() != null) {
			if(root.getData() <= root.getRight().getData()) {
				resRight = true;
			}
			else {
				resRight = false;
			}
		}
		
		return resLeft && resRight && isBST(root.getLeft()) && isBST(root.getRight()) ;
	}
	
	public void printLevelBST(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		que.offer(null);
		
		while(!que.isEmpty()) {
			TreeNode temp = que.poll();
			if(temp != null) {
				System.out.print(temp.getData()+"\t");
				if(temp.getLeft() != null) {
					que.offer(temp.getLeft());
				}
				if(temp.getRight() != null) {
					que.offer(temp.getRight());
				}
			}
			else {
				if(!que.isEmpty()) {
					que.offer(null);
				}
			}
			
		}
		
	}
	
	public void insert(TreeNode root, int val) {
		
		TreeNode temp = root;
		TreeNode newNode = new TreeNode(val);
		
		while(temp!=null) {
			if(root.getData() == val) {
				newNode.setRight(temp.getRight());
				temp.setRight(newNode);
				return;
			}
			if(temp.getData() < val) {
				if(temp.getRight() == null) {
					temp.setRight(newNode);
					return;
				}
				temp = temp.getRight();
				
			}
			else {
				if(temp.getLeft() == null) {
					temp.setLeft(newNode);
					return;
				}
				temp = temp.getLeft();
			}
		}
		
	}
	
	public void delete(TreeNode root, int val) {
		
		if(root == null) {
			return;
		}
		
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		que.offer(null);
		TreeNode temp = null;
		boolean isFoundR = false, isFoundL = false;
		
		while(!que.isEmpty()) {
			temp = que.poll();
			if(temp != null) {
				if(temp.getLeft() != null && temp.getLeft().getData() == val) {
					isFoundL = true;
					break;
				}
				if(temp.getRight() != null && temp.getRight().getData() == val) {
					isFoundR = true;
					break;
				}
				if(temp.getLeft() != null) {
					que.offer(temp.getLeft());
				}
				if(temp.getRight() != null) {
					que.offer(temp.getRight());
				}
			}
			else {
				if(!que.isEmpty()) {
					que.offer(null);
				}
			}
			
		}
		if(isFoundL) {
			if(temp.getLeft().getLeft() == null && temp.getLeft().getRight() == null) {
				temp.setLeft(null);
				return;
			}
			if(temp.getLeft().getLeft() != null && temp.getLeft().getRight() == null) {
				temp.getLeft().setData(temp.getLeft().getLeft().getData());
				temp.getLeft().setLeft(null);
				return;
			}
			if(temp.getLeft().getLeft() == null && temp.getLeft().getRight() != null){
				temp.getLeft().setData(temp.getLeft().getRight().getData());
				temp.getLeft().setRight(null);
				return;
			}
			if(temp.getLeft().getLeft() != null && temp.getLeft().getRight() != null){
				
			}
			
		}
		
	}

}
