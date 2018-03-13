package com.practice.Queue;

import com.practice.linkedlist.ListNode;

public class MyQueue {
		
	public int length;
	public ListNode front, rear;
	
	public MyQueue(){
		length = 0;
		front = rear = null;
	}
	
	public boolean isEmpty(){
		if(length == 0) return true;
		else return false;
	}
	
	//attach at rear
	public void enqueue(int data){
		ListNode temp = new ListNode(data);
		if(front == null) front = rear = temp;
		else { 
		rear.next = temp;
		rear = temp;
		length++;
		}
	}
	
	
	//detach front
	public ListNode dequeue() throws Exception{
		ListNode temp = null;
		if( isEmpty()) throw new Exception("Empty");
		else {
			temp = front;
			front = front.next;
			length--;
		}
		return temp;
	}
	
	public void printQueue(){
		StringBuilder sb = new StringBuilder();
		ListNode curr = front;
		while(curr != null){
			sb.append(curr.data + "-");
			curr = curr.next;
		}
		System.out.println(sb);
	}
}
