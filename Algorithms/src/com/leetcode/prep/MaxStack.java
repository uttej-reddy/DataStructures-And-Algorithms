package com.leetcode.prep;

public class MaxStack {

	class Node{
		int val;
		int max;
		Node next;
		
		Node(int x, int y){
			this.val = x;
			this.max = y;
			next = null;
			
		}
	}
	Node head;
	
	public void push(int n) {
		if(head == null)
			head = new Node(n, n);
		else {
			Node newNode = new Node(n,Math.max(head.max, n));
			newNode.next  =   head;
			head =  newNode;
		}
	}
	
	public int pop() {
		if(head != null) {
			head = head.next;
			return head.val;
		}			 
		return -1;
	}
	
	public int top() {
		if(head != null)
			return head.val;
		return -1;
	}
	
	public int peekMax() {
		if(head != null)
			return head.max;
		return -1;
	}
	
	public int popMax() {
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
