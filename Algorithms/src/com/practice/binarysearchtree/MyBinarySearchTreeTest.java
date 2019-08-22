package com.practice.binarysearchtree;

public class MyBinarySearchTreeTest {

	public static void main(String[] args) {
		
		MyBinarySearchTree bst = new MyBinarySearchTree();
		
		/*
		 * bst.root = new BinarySearchTreeNode(50); bst.root.setLeft(new
		 * BinarySearchTreeNode(30)); bst.root.getLeft().setLeft(new
		 * BinarySearchTreeNode(20)); bst.root.getLeft().setRight(new
		 * BinarySearchTreeNode(40)); bst.root.setRight(new BinarySearchTreeNode(70));
		 * bst.root.getRight().setLeft(new BinarySearchTreeNode(60));
		 * bst.root.getRight().setRight(new BinarySearchTreeNode(80));
		 */
		 bst.root = bst.insertInBSTr(bst.root, 50);
		 bst.root = bst.insertInBSTr(bst.root, 30);
		bst.root = bst.insertInBSTi(bst.root, 40);
		bst.root = bst.insertInBSTi(bst.root, 20);
		
		System.out.println("ROot is : " +bst.root);
	
		BinarySearchTreeNode min = bst.findMin(bst.root);
		
		System.out.println("Min is " +min.getData());
	}

}
