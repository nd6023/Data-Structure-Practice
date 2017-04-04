package tree;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TreeVariousMethods {

	public static void main(String[] args) {
		
		TreeVariousMethods treeVariousMethods = new TreeVariousMethods();
		TreeNode root = new TreeNode(1);
		treeVariousMethods.createTree(root);
		treeVariousMethods.printRightTree(root);
		System.out.println("\nMax depth of the tree is: \t"+treeVariousMethods.maxDepth(root));
		System.out.println("\nMin depth of the tree is: \t"+treeVariousMethods.minDepth(root));
		treeVariousMethods.printVariousPath(root);
		System.out.println("\nTop view of the map by preorder traversal is :\n");
		treeVariousMethods.topView(root);
		System.out.println("\nTop view of the map by level order traversal is :\n");
		treeVariousMethods.topViewLevel(root);
		System.out.println("\nBottom view of the map is :\n");
		treeVariousMethods.bottomView(root);
		
		

	}
	
	public void createTree(TreeNode root) {
		
		TreeNode n1   = new TreeNode(2);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(4);
        TreeNode n4   = new TreeNode(5);
        TreeNode n5   = new TreeNode(6);
        TreeNode n6   = new TreeNode(8);
        TreeNode n7   = new TreeNode(9);
        TreeNode n8   = new TreeNode(10);
        TreeNode n9   = new TreeNode(12);
        TreeNode n10   = new TreeNode(14);
        TreeNode n11   = new TreeNode(21);
         
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
	
	public void printRightTree(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		List<Integer> rightView = new ArrayList<>();
		List<Integer> leftView = new ArrayList<>();
		List<Integer> bottomView = new ArrayList<>();
		
		
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		que.offer(null);
		TreeNode cur = null, pre = null;
		boolean isLeft = true;
		int leftSum = 0;
		while(!que.isEmpty()) {
			pre = cur;
			cur = que.poll();
			if(cur != null) {
				if(isLeft) {
					leftView.add(cur.getData());
					isLeft = false;
				}
				if(cur.getLeft() == null && cur.getRight() == null) {
					bottomView.add(cur.getData());
				}
				
				if(cur.getLeft() != null && cur.getRight() == null && cur.getLeft().getLeft() == null && cur.getLeft().getRight() == null) {
					leftSum += cur.getLeft().getData();
				}
				
				if(cur.getLeft()!=null) {
					que.offer(cur.getLeft());
				}
				if(cur.getRight()!=null) {
					que.offer(cur.getRight());
				}
			}
			else {
				if(!que.isEmpty()) {
					que.offer(null);
				}
				rightView.add(pre.getData());
				isLeft = true;
			}
		}
		
		System.out.println("Left leaf sum: \t" + leftSum);
		
		System.out.println("\nLeft view!!!");
		for(int no : leftView) {
			System.out.print(no+"\t");
		}
		
		System.out.println("\nRight view!!!");
		for(int no : rightView) {
			System.out.print(no+"\t");
		}
		
		/*
		System.out.println("\nBottom view!!!");
		for(int no : bottomView) {
			System.out.print(no+"\t");
		}
		*/
		
	}
	
	public int maxDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		return Integer.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
	}
	
	public int minDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		que.offer(null);
		TreeNode cur = null;
		int minLvl = 1;
		while(!que.isEmpty()) {
			cur = que.poll();
			if(cur != null) {
				if(cur.getLeft() == null && cur.getRight() == null) {
					return minLvl;
				}	
			}
			else {
				if(!que.isEmpty()) {
					que.offer(null);
				}
				minLvl++;
			}
		}
		return minLvl;
	}
	
	public void printVariousPath(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		int path [] = new int[256];
		printRootLeaf(root, path, 0);
		
	}
	
	public void printRootLeaf(TreeNode root, int [] path, int index) {
		
		if(root == null) {
			return;
		}
		
		path[index] = root.getData();
		index++;
		
		if(root.getLeft() == null && root.getRight() == null) {
			printNode(path, index);
			return;
		}
		
		if(root.getLeft() != null) {
			printRootLeaf(root.getLeft(), path, index);
		}
		
		if(root.getRight() != null) {
			printRootLeaf(root.getRight(), path, index);
		}
	}
	
	public void printNode(int [] path, int index) {
		System.out.println();
		for(int i = 0; i < index; i++){
			System.out.print(path[i]+"\t");
		}
	}
	
	class MapDetails {
		int val;
		int level;
		
		MapDetails(int val, int level) {
			this.val = val;
			this.level = level;
		}
	}
	
	public void topView(TreeNode root) {
		
		Map<Integer, MapDetails> tempMap = new TreeMap<>();
		
		findTopView(root, 0, 0, tempMap);
		
		Iterator<Entry<Integer, MapDetails>> itr = tempMap.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, MapDetails> myMap = itr.next();
			System.out.print(myMap.getValue().val+"\t");
		}
		
	}
	
	public void findTopView(TreeNode root, int dis, int level, Map<Integer, MapDetails> tempMap) {
		
		if(root == null) {
			return;
		}
		
		MapDetails mapDetails = tempMap.get(dis);
		
		if(mapDetails != null) {
			if(level < mapDetails.level) {
				mapDetails = new MapDetails(root.getData(), level);
				tempMap.put(dis, mapDetails);
			}
		}
		else {
			mapDetails = new MapDetails(root.getData(), level);
			tempMap.put(dis, mapDetails);
		}
		
		findTopView(root.getLeft(), dis - 1, level + 1, tempMap);
		findTopView(root.getRight(), dis + 1, level + 1, tempMap);
	}
	
	public void topViewLevel(TreeNode root) {
		
		Map<Integer, QueueEntry> tempMap = new TreeMap<>();
		
		findTopViewLevel(root, 0, 0, tempMap);
		
		Iterator<Entry<Integer, QueueEntry>> itr = tempMap.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, QueueEntry> myMap = itr.next();
			System.out.print(myMap.getValue().node.getData()+"\t");
		}
		
	}
	
	public void findTopViewLevel(TreeNode root, int dis, int level, Map<Integer, QueueEntry> tempMap) {
		
		if(root == null) {
			return;
		}
		
		Queue<QueueEntry> que = new LinkedList<>();
		
		que.offer(new QueueEntry(root, 0));
		que.offer(null);
		int curLevel = 0;
		while(!que.isEmpty()) {
			QueueEntry tempQue = que.poll();
			if(tempQue!=null) {
				
				if(tempMap.get(tempQue.dis) == null) {
					tempMap.put(tempQue.dis, new QueueEntry(tempQue.node, tempQue.dis));
				}
				
				if(tempQue.node.getLeft()!=null) {
					que.offer(new QueueEntry(tempQue.node.getLeft(), tempQue.dis - 1));
				}
				
				if(tempQue.node.getRight()!=null) {
					que.offer(new QueueEntry(tempQue.node.getRight(), tempQue.dis + 1));
				}
			}
			else {
				curLevel++;
				if(!que.isEmpty()) {
					que.offer(null);
				}
			}
		}
		
		
		
	}
	
	class QueueEntry {
		TreeNode node;
		int dis;
		
		QueueEntry(TreeNode node, int dis) {
			this.node = node;
			this.dis = dis;
		}
	}
	
	public void bottomView(TreeNode root) {
		
		Map<Integer, MapDetails> tempMap = new TreeMap<>();
		findBottomView(root, 0, 0, tempMap);
		
		Iterator<Entry<Integer, MapDetails>> itr = tempMap.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry<Integer, MapDetails> resMap = itr.next();
			System.out.print(resMap.getValue().val+"\t");
		}
		
	}
	
	public void findBottomView(TreeNode root, int dis, int level, Map<Integer, MapDetails> tempMap) {
		
		if(root == null) {
			return;
		}
		
		MapDetails mapDetails = tempMap.get(dis);
		if(mapDetails != null) {
			if(level > tempMap.get(dis).level) {
				tempMap.put(dis,  new MapDetails(root.getData(), level));
			}
			
		}
		else {
			tempMap.put(dis,  new MapDetails(root.getData(), level));
		}
		findBottomView(root.getLeft(), dis - 1, level + 1, tempMap);
		findBottomView(root.getRight(), dis + 1, level + 1, tempMap);
	}
	
}
