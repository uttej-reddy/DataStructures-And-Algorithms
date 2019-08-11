package com.practice.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyBinaryTree {

	BinaryTreeNode root;
	
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
		List<Integer> result = new ArrayList<Integer>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		if(root == null) result = null;
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode temp = s.pop();
			result.add(temp.getData());
			if(temp.getRight() != null) s.push(temp.getRight());
			if(temp.getLeft() != null ) s.push(temp.getLeft());
		}
		return result;
	}
	
	public List<Integer> inOrderI(BinaryTreeNode root) {
		//TODO. Trickier.Check
		List<Integer> result = new ArrayList<Integer>();
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		if(root == null) return null;
		return result;
	}
	
	public void postOrderI(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
		if(root==null) return;
		s1.push(root);
		while(!s1.isEmpty()) {
			BinaryTreeNode temp = s1.pop();
			if(temp.getLeft()!=null) s1.push(temp.getLeft());
			if(temp.getRight()!=null) s1.push(temp.getRight());
			s2.push(temp);
		}
		while(!s2.isEmpty()) {
			System.out.print(s2.pop().getData() + " ");
		}
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
		int leftDepth = depthOfTree(root.getLeft());
		int rightDepth = depthOfTree(root.getRight());
		int depth = (leftDepth > rightDepth) ? leftDepth+1 : rightDepth+1;
		return depth;
		
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
	
}
