package com.practice.binarytree;

import java.util.List;

public class MyBinaryTreeTest {

	public static void main(String[] args) {
		MyBinaryTree tree1 = new MyBinaryTree();
		tree1.root = new BinaryTreeNode(1);
		tree1.root.setLeft(new BinaryTreeNode(2));
		tree1.root.getLeft().setLeft(new BinaryTreeNode(4));
		tree1.root.getLeft().setRight(new BinaryTreeNode(5));
		tree1.root.setRight(new BinaryTreeNode(3));
		tree1.root.getRight().setLeft(new BinaryTreeNode(6));
		tree1.root.getRight().setRight(new BinaryTreeNode(7));
		tree1.root.getLeft().getRight().setLeft(new BinaryTreeNode(8));;
		
		System.out.println("Pre Order is :");
		tree1.preOrderR(tree1.root);
		System.out.println("\n In Order is :");
		tree1.inOrderR(tree1.root);
		System.out.println("\n Post Order is :");
		tree1.postOrderR(tree1.root);
		
		System.out.println("\n Iteraative Pre Order is :");
		List<Integer> preOrderI = tree1.preOrderI(tree1.root);
		System.out.println(preOrderI);
		
		System.out.println("\n Iteraative In Order is :");
		List<Integer> inOrderI = tree1.inOrderI(tree1.root);
		System.out.println(inOrderI);
		
		System.out.println("\n Max value in a tree is :" +tree1.max(tree1.root));
		
		System.out.println("\n Iteraative Post Order is :");
		tree1.postOrderI(tree1.root);
		
		System.out.println("\n Level Order is :");
		List<Integer> levelOrder = tree1.levelOrder(tree1.root);
		System.out.println(levelOrder);
		
		System.out.println("\n Reverse Level Order is :");
		List<Integer> reverselevelOrder = tree1.levelOrderReverse(tree1.root);
		System.out.println(reverselevelOrder);
		
		System.out.println("\n Size of tree is :" +tree1.sizeOfTree(tree1.root));
		System.out.println("\n Depth of tree is :" +tree1.depthOfTree(tree1.root));
		

		System.out.println("\n DEEPEST NODE of tree is :" +tree1.deepestNode(tree1.root).getData());
		
		
		
	}

}
