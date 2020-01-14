package com.practice.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyBinaryTree {

	public BinaryTreeNode root;
	
	public void preOrderR(BinaryTreeNode root) {
		if(root!=null) {
			System.out.print(root.getData() + " ");
			preOrderR(root.getLeft());
			preOrderR(root.getRight());
		}
	}
	
	public void inOrderR(BinaryTreeNode root) {
		if(root!=null) {
			inOrderR(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrderR(root.getRight());
			
		}
	}
	
	public void postOrderR(BinaryTreeNode root) {
		if(root!=null) {
			postOrderR(root.getLeft());
			postOrderR(root.getRight());
			System.out.print(root.getData() + " ");	
		}
	}
	
	public List<Integer> preOrderI(BinaryTreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode tmp = s.pop();
			if(tmp.right != null) s.push(tmp.right);
			if(tmp.left != null) s.push(tmp.left);
			res.add(tmp.data);
		}
		return res;
	}
	
	public List<Integer> inOrderI(BinaryTreeNode root) {
		//TODO. Trickier.Check
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		while(root != null || s.size() > 0) {
			while(root != null) {
				s.push(root);
				root = root.left;
			}
			BinaryTreeNode tmp = s.pop();
			root = tmp.right; 
			res.add(tmp.data);
		}
		return res;
	}
	
	//https://www.geeksforgeeks.org/iterative-postorder-traversal/
	public void postOrderI(BinaryTreeNode root) {
		
	}
	
	public int sumOfLeftLeaves(BinaryTreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        
        if(root.left != null){
            if(root.left.left == null && root.left.right == null) 
                sum += root.left.data;
            else
                sumOfLeftLeaves(root.left); 
        }
        
        sum += sumOfLeftLeaves(root.right);
            
            return sum;
        
    }
	
	public int max(BinaryTreeNode root) {
		int max = Integer.MIN_VALUE;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		if(root == null) return max;
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode temp = s.pop();
			int data = temp.getData();
			if(data > max) max = data;
			if(temp.getRight() != null) s.push(temp.getRight());
			if(temp.getLeft() != null ) s.push(temp.getLeft());
		}
		return max;
	}
	
	public List<Integer> levelOrder(BinaryTreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		
		if(root == null) return null;
		BinaryTreeNode curr = root;
		q.offer(curr);
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			result.add(temp.getData());
			if(temp.getLeft() != null) q.offer(temp.getLeft());
			if(temp.getRight() != null) q.offer(temp.getRight());
		}
		return result;
	}
	
	public List<Integer> levelOrderReverse(BinaryTreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		
		if(root == null) return null;
		BinaryTreeNode curr = root;
		q.offer(curr);
		while(!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			s.push(temp);
			if(temp.getRight()!= null) q.offer(temp.getRight());
			if(temp.getLeft() != null) q.offer(temp.getLeft());
		}
		
		while(!s.isEmpty()) result.add(s.pop().getData());
		
		return result;
	}
	
	public int sizeOfTree(BinaryTreeNode root) {
		if(root==null) return 0;		
		return 1 + sizeOfTree(root.getLeft()) + sizeOfTree(root.getRight());
	}
	
	public int depthOfTree(BinaryTreeNode root) {
		if(root==null) return 0;
		int leftDepth = 1+ depthOfTree(root.getLeft());
		int rightDepth = 1 + depthOfTree(root.getRight());
		
		return Math.max(leftDepth, rightDepth);
		
	}
	
	public BinaryTreeNode deepestNode(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		if(root==null) return null;
		q.offer(root);
		BinaryTreeNode temp = null;
		while(!q.isEmpty()) {
			 temp = q.poll();
			if(temp.getLeft()!= null) q.offer(temp.getLeft());
			if(temp.getRight() != null) q.offer(temp.getRight());
		}
		return temp;
	}
	
	public BinaryTreeNode invertTree(BinaryTreeNode root) {
		
		if(root == null) return null;
		
		BinaryTreeNode  temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		
		return root;
	}
	
	public List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
        
        List<List<Integer>> res  =  new ArrayList<>();
        if(root  == null) return res;
        
        	pathSum(root,sum,res,new ArrayList<>());
        
        return res;
        
    }
    
    public void pathSum(BinaryTreeNode root, int sum, List<List<Integer>> res,List<Integer> tempList) {
    	if (root == null) {
            return;
        }
        
    	tempList.add(root.data);
        
        if (root.left == null && root.right == null && sum == root.data) {
            res.add((tempList));
        } else {
            pathSum(root.left, sum - root.data, res, tempList);
            pathSum(root.right, sum - root.data, res, tempList);
        }
        
        tempList.remove(tempList.size() - 1);
    }
        
    
	
}
