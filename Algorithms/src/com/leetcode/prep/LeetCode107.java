package com.leetcode.prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import com.practice.binarytree.BinaryTreeNode;
import com.practice.binarytree.MyBinaryTree;

public class LeetCode107 {

	public static void main(String[] args) {
		LeetCode107 leet = new LeetCode107();
		MyBinaryTree bt = new MyBinaryTree();
		bt.root = new BinaryTreeNode(3);
		bt.root.setLeft(new BinaryTreeNode(9));
		bt.root.setRight(new BinaryTreeNode(20));
		bt.root.getRight().setLeft(new BinaryTreeNode(15));
		bt.root.getRight().setRight(new BinaryTreeNode(7));
		
		leet.levelOrderBottom(bt.root);
		leet.averageOfLevels(bt.root);

	}
	
	
	    public List<List<Integer>> levelOrderBottom(BinaryTreeNode root) {
	        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
	        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
	        
	        if(root == null) return wrapList;
	        
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int levelNum = queue.size();
	            List<Integer> subList = new LinkedList<Integer>();
	            for(int i=0; i<levelNum; i++) {
	            	BinaryTreeNode temp = queue.poll();
	                if(temp.getLeft() != null) queue.offer(temp.getLeft());
	                if(temp.getRight() != null) queue.offer(temp.getRight());
	                subList.add(temp.getData());
	            }
	            wrapList.add(0, subList);
	        }
	        return wrapList;
	    }
	    
	    public List<Double> averageOfLevels(BinaryTreeNode root) {
	        List<Double> avg = new ArrayList<Double>();
	        Queue<BinaryTreeNode> q = new LinkedList<>();
	        
	        q.offer(root);
	        while(!q.isEmpty()){
	            int len = q.size();
	            int sum = 0;
	            System.out.println("length is:"  +len);
	            for(int i=0;i<len;i++){
	            	BinaryTreeNode temp = q.poll();
	                sum += temp.data;
	                if(temp.left != null) q.offer(temp.left);
	                if(temp.right != null) q.offer(temp.right);               
	            }
	            avg.add(sum/(len * 1.0));
	        }
	        
	        return avg;
	    }
	

}
