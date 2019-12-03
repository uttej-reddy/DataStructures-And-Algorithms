package com.leetcode.prep;

import com.practice.binarytree.BinaryTreeNode;
import com.practice.binarytree.MyBinaryTree;

public class LeetCode101 {

	public static void main(String[] args) {
		LeetCode101 leet = new LeetCode101();
		MyBinaryTree bt = new MyBinaryTree();
		bt.root = new BinaryTreeNode(1);
		bt.root.setLeft(new BinaryTreeNode(2));
		bt.root.setRight(new BinaryTreeNode(2));
		bt.root.getRight().setRight(new BinaryTreeNode(3));
		bt.root.getLeft().setRight(new BinaryTreeNode(3));
		
		System.out.println(leet.isSymmetric(bt.root));

	}
	
	public boolean isSymmetric(BinaryTreeNode root) {
        if(root == null) return true;
        else{
        	BinaryTreeNode inv =  inverseOfBT(root);
           boolean res = isSameTree(root, inv);
           return res;
        }
        
    }
    
    public BinaryTreeNode inverseOfBT(BinaryTreeNode root){
        if(root == null)  return null;
        else{
        	BinaryTreeNode temp = inverseOfBT(root.left);
            root.left = inverseOfBT(root.right);
            root.right = temp;   
        return root;
        }
    }
    
    public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q){
        if(p == null && q == null) return true;
        if(p!=null && q!=null && p.data == q.data)
            return true && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        return false;
    }

}
