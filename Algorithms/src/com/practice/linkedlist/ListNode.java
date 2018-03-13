package com.practice.linkedlist;


public class ListNode{
	public int data;
	public ListNode next;
	
	//constructor
	public ListNode(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public ListNode getNext(){
		return next;
	}
	
	public void setNext(ListNode next){
		this.next = next;
	}	
}
