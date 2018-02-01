package com.practice.linkedlist;

public class MyLinkedList {

	Node head;
	
	public class Node{
		int data;
		Node next;
		
		//constructor
		public Node(int data){
			this.data = data;
		}
		
		public int getData(){
			return data;
		}
		
		public void setData(int data){
			this.data = data;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node next){
			this.next = next;
		}	
	}
	
	//insert in front
	public void insertFront(int n){
		Node temp = new Node(n);
		if(head==null){
			head = temp;
		}else{
			temp.next = head;
			head = temp;
		}
	}
	
	//insert in end
	// remember to create temp node iter - V imp
	public void insertEnd(int n){
		Node temp = new Node(n);
		Node iter = head;
		if(head==null){
			head = temp;
		}else{
			while(iter.next != null){
				iter = iter.next;
			}
			iter.next = temp;
		}
	}
	
	//insert at particular position
	// this is VAGUE
	public void insertAfter(Node prev, int n){
		Node temp = new Node(n);
		Node iter = head;
		if(head == null) head = temp;
		if(iter.next!=null){
				while(iter.next!=null){
					if(iter.next.data == prev.data){
					temp.next = iter.next.next;
					iter.next.next = temp;
				}
				iter = iter.next;
				}
		}else{
			head.next = temp;
		}
	}
	
	//delete in front
	public Node deleteFront(){
		Node temp = null;
		if(head == null) temp = null;
		else if(head.next != null){
			temp = head;
			head = head.next;
		}else{
			temp = head;
		}
		return temp;
	}
	
	//delete at end
	//two pointer's one to head and one to head.next - V IMP
	public Node deleteEnd(){
		if(head == null) return null;
		if(head.next != null){
			Node p = head.next;
			Node q = head;
			while(p.next != null){
				p =p.next;
				q = q.next;
			}
			q.next = null;
			return p;
		}else{
			return head;
		}
	}
	
	
	//delete at particular position
	public void deleteAfter(Node prev, int n){
	//	Node temp = new Node(n);
		Node iter = head;
		if(head == null ) return;
		if(iter.next  != null){
			if (iter.next == prev){
				Node temp = prev.next;
				prev.next = temp.next;
			}
			iter = iter.next;
		}
	}
	
	//remove elements
	public Node removeElements(int val) {
        Node iter = head;
        Node prev = null;
        if(head == null) return null;
        while(iter != null && iter.data == val){
        	head = iter.next;
        }
        while(iter != null && iter.data != val){
        	if(iter.next.data == val) iter.next = iter.next.next;
            else iter = iter.next;
        }
		return head;
    }
	
	//print 
	public void printList(Node head){
		Node temp = head;
		StringBuilder sb = new StringBuilder();
		while(temp !=null){
			sb = sb.append(temp.data + "->");
			temp = temp.next;
		}
		System.out.println(sb);
	}
	
	public boolean hasCycle(Node head){
		if(head == null || head.next == null) return false;
		Node p = head;
		Node q = head.next;
		while(p !=null && q != null){
			if(p == q){
				return true;
			}else{
				p = p.next;
				q.next = q.next.next;
			}
		}
		return false;
	}
	
	public Node reverseList(Node head){
		if( head == null || head.next == null) return head;
		Node rev = null;
		Node iter = head;
		while(iter.next != null){
			Node temp = iter.next;
			iter.next = rev;
			rev = iter;
			iter = temp;
		}
		iter.next = rev;
		return iter;
	}
	
	public int length(Node head){
		int i = 1;
		if(head == null) i = 0;
		Node iter = head;
		while(iter.next != null){
			iter = iter.next;
			i++;
		}
		return i;	
	}
	
	//isPalindrome with length
	public boolean isPalindrome(Node head){
		Node slow = head;
		Node fast = head;
		if(head == null || head.next == null) return true;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node reverse = reverseList(slow);
		Node l1 = head;
		Node l2 = reverse;
		int i = 0;
		while(l1!= null && l2 != null){
			if(l1.data != l2.data) return false;
			else {
				l1 = l1.next;
				l2 = l2.next;
				i++;
			}
		}
		return true;
	}
	
	public Node getMiddle(Node head, int mid){
		if (head == null)  return null;
		while(head!=null){
			
		}
		return null;
	}
	
	//rotate list - Leetcode modified version
	public Node rotateRight(Node head, int k) {
        int length = 1;
        if(head == null) length = 0;
        Node iter = head;
        Node iter2 = head;
            while(iter.next != null){
                iter =iter.next;
                length++;
            }
        
        if(length-k > 0){
            for(int i =1; i<length-k; i++){
                iter2 = iter2.next;
            }
            iter.next = head;
            head = iter2.next;
            iter2.next = null;
        }
        
        return head;
    }
	
	public void reorderList(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        if(fast!=null){
        	slow = slow.next;
        }
        Node midRev = reverseList(slow);
        
    }
	
	/*
	 * Note that we use a dummy head to simplify the code. 
	 * Without a dummy head, you would have to write extra conditional statements to initialize the head's value.
	 * */
	public Node addTwoNumbers(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        int value = 0;
        int actual = 0;
        
        while(l1 != null && l2 != null){
            value = l1.data + l2.data + carry;
            actual = value%10;
            carry = value/10;
            Node newNode = new Node(actual);
            curr.next =  newNode;
            curr = curr.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null) curr.next = l2;
        if(l2 == null) curr.next = l1;
        
        return dummy.next;
    }
	
	
	
}
