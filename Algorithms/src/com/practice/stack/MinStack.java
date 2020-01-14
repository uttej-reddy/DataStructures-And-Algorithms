package com.practice.stack;

class MinNode{
	
	int val;
	int min;
	MinNode next;
	
	MinNode(int val,  int min){
		this.val = val;
		this.min = min;
	}
	
}

public class MinStack {
	
	MinNode head;

	public static void main(String[] args) {
		MinStack s =  new MinStack();
		s.push(-2);
		s.push(0);
		s.push(-3);

		System.out.println("TOp is : " +s.top());
		System.out.println("Min is : " +s.min());
		
		s.pop();
		

		System.out.println("TOp is : " +s.top());
		System.out.println("Min is : " +s.min());
		
		
	}

	public void push(int x) {
		if(head ==  null)
			head = new MinNode(x,x);
		else {
			MinNode node = new MinNode(x,Math.min(x, head.min));
			node.next = head;
			head = node;
		}
	}
	
	public void pop() {
		if(head !=  null)
		head = head.next;
	}
	
	public int min() {
		if(head != null) return head.min;
		return 0;
	}
	
	public int top() {
		if(head !=  null) return head.val;
		return 0;
	}
}
