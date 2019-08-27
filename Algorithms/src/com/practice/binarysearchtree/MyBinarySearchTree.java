package com.practice.binarysearchtree;


public class MyBinarySearchTree{
	
	BinarySearchTreeNode root;
	
	public BinarySearchTreeNode findR(BinarySearchTreeNode root, int data) {
		BinarySearchTreeNode result;
		if(root == null) result = null;
		else if (data < root.getData()) result = findR(root.getLeft(),data);
		else if (data > root.getData()) result = findR(root.getRight(),data);
		else result = root;
		return result;
	}
	
	public BinarySearchTreeNode findMin(BinarySearchTreeNode root) {
		if(root == null) return null;
		// if(root.getLeft() == null) return root; not required as last return statement is same as this.
		while(root.getLeft() !=null) {
			root = root.getLeft();
		}
		return root;
	}
	
	public BinarySearchTreeNode insertInBSTr(BinarySearchTreeNode root, int data) {
		if(root == null) { 
			root = new BinarySearchTreeNode(data);
			return root;
		}
		if(data <  root.getData()) root.setLeft(insertInBSTr(root.getLeft(), data));
		if(data > root.getData())  root.setRight(insertInBSTr(root.getRight(), data));
		
		return root;
	}
	
	public BinarySearchTreeNode insertInBSTi(BinarySearchTreeNode root, int data) {
		if(root == null) { 
			root = new BinarySearchTreeNode(data);
			return root;
		}
		BinarySearchTreeNode parent = null ; 
		BinarySearchTreeNode child = root;
		while(child != null) {
			parent = child ;
			if(data < child.getData()) child = child.getLeft();
			/* this is an example where instead of using elseif if we use if it breaks. Try it.
			*  ELseif only executes if if condition is not satisfied where as if is executed regardless and 
			*  because of which child is evaluated in below condition
			*/
			else if(data > child.getData()) child = child.getRight(); 
		}
		if(data < parent.getData()) parent.setLeft(new BinarySearchTreeNode(data));
		else if(data > parent.getData()) parent.setRight(new BinarySearchTreeNode(data));
 
		return root;
	}

	//Implement Delete
	
}
