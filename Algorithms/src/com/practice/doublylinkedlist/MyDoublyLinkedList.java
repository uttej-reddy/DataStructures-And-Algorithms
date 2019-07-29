package com.practice.doublylinkedlist;

public class MyDoublyLinkedList {
	
	 DLLNode head;
	 DLLNode tail;
	int length = 0;
	
	//Initializing
	public MyDoublyLinkedList() {
		this.head = this.tail = null;
		this.length = 0;
	}
	
	public int getLength() {
		return length;
	}
	
	public boolean isEmpty() {		
		return (getLength() <= 0);
	}
	
	//insert at beginning
	public void insertAtBeginning(int data) {
		DLLNode node = new DLLNode(data);
		if(isEmpty()) { head = tail = node;}
		else {
		node.setNext(head);
		head.setPrev(node);
		head = node ;
		}
		length++;
	}
	
	//insert at end
	public void insertAtEnd(int data) {
		DLLNode node = new DLLNode(data);
		if(isEmpty()) {
			head = tail = node;
			length++;
			return;
		}
		if (head != null) {
			if(head.getNext() == null) {
				node.setPrev(head);
				head.setNext(node);		
			} else {
				DLLNode temp = head;
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				node.setPrev(temp);
				temp.setNext(node);
			}
			length++;
			return;
		}	
	}
	
	//insert in middle 
	// TODO
	
	//delete at beginning
	public  DLLNode deleteAtBeginning() {
		DLLNode result = null;
		if(head == null) result=head= null; 
		
		if(head != null) {
			if(head.getNext() == null) {
				result = head = null;
			}
			else {
				DLLNode temp = head;
				head = head.getNext();
				temp.setNext(null);
				head.setPrev(null);
				result = temp;	
			}
			length--;
		}
		return result;
	}
	
	//delete at the end
	public DLLNode deleteAtEnd() {
		DLLNode result = null;
		if(head == null) result= head = null;
		
		if(head != null) {
			if(head.getNext() == null) {
				result = head = null;
			}else {
			DLLNode temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.getPrev().setNext(null);
			temp.setPrev(null);
			result = temp;
		}

			length--;
		}
		return result;
		
	}
	
	public void printList(DLLNode head) {
		DLLNode temp = head;
		StringBuilder sb = new StringBuilder();
		while(temp != null) {
			 sb = sb.append(temp.getData() + "->");
			 temp = temp.getNext();
		}
		System.out.println(sb);
	}

}
