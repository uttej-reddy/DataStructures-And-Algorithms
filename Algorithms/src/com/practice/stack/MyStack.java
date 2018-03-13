package com.practice.stack;

import java.util.Stack;

import com.practice.linkedlist.ListNode;

public class MyStack {

	ListNode top;
	int length = 0;

	public void push(int val){
		ListNode stack = new ListNode(val);
		stack.next = top ;
		top = stack;
		length++;
	}
	
	public ListNode pop(){
		if(top != null){
		ListNode temp = top;
		top = top.next;
		length--;
		return temp;
		}
		return null;
	}
	
	public boolean isEmpty(){
		if(top == null) return true;
		else return false;
	}
	
	public int peek(){
		return top.data;
	}
	
	public void printStack(ListNode node){
		StringBuilder sb = new StringBuilder();
		while(node != null){
			sb.append(node.data + "-");
			node = node.next;
		}
		System.out.println(sb);
	}
}
