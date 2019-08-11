package com.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class MyLinkedList {

	ListNode head;
	
	//insert in front
	public void insertFront(int n){
		ListNode temp = new ListNode(n);
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
		ListNode temp = new ListNode(n);
		ListNode iter = head;
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
	public void insertAfter(ListNode prev, int n){
		ListNode temp = new ListNode(n);
		ListNode iter = head;
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
	public ListNode deleteFront(){
		ListNode temp = null;
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
	public ListNode deleteEnd(){
		if(head == null) return null;
		if(head.next != null){
			ListNode p = head.next;
			ListNode q = head;
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
	public void deleteAfter(ListNode prev, int n){
	//	Node temp = new Node(n);
		ListNode iter = head;
		if(head == null ) return;
		if(iter.next  != null){
			if (iter.next == prev){
				ListNode temp = prev.next;
				prev.next = temp.next;
			}
			iter = iter.next;
		}
	}
	
	//remove elements
	public ListNode removeElements(int val) {
        ListNode iter = head;
        ListNode prev = null;
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
	public void printList(ListNode head){
		ListNode temp = head;
		StringBuilder sb = new StringBuilder();
		while(temp !=null){
			sb = sb.append(temp.data + "->");
			temp = temp.next;
		}
		System.out.println(sb);
	}
	
	public boolean hasCycle(ListNode head){
		if(head == null || head.next == null) return false;
		ListNode p = head;
		ListNode q = head.next;
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
	
	public ListNode reverseList(ListNode head){
		if( head == null || head.next == null) return head;
		ListNode rev = null;
		ListNode iter = head;
		while(iter.next != null){
			ListNode temp = iter.next;
			iter.next = rev;
			rev = iter;
			iter = temp;
		}
		iter.next = rev;
		return iter;
	}
	
	public int length(ListNode head){
		int i = 1;
		if(head == null) i = 0;
		ListNode iter = head;
		while(iter.next != null){
			iter = iter.next;
			i++;
		}
		return i;	
	}
	
	//isPalindrome with length
	public boolean isPalindrome(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		if(head == null || head.next == null) return true;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode reverse = reverseList(slow);
		ListNode l1 = head;
		ListNode l2 = reverse;
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
	
	public ListNode getMiddle(ListNode head, int mid){
		if (head == null)  return null;
		while(head!=null){
			
		}
		return null;
	}
	
	//rotate list - Leetcode modified version
	public ListNode rotateRight(ListNode head, int k) {
        int length = 1;
        if(head == null) length = 0;
        ListNode iter = head;
        ListNode iter2 = head;
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
	
	public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        if(fast!=null){
        	slow = slow.next;
        }
        ListNode midRev = reverseList(slow);
        
    }
	
	/*
	 * Note that we use a dummy head to simplify the code. 
	 * Without a dummy head, you would have to write extra conditional statements to initialize the head's value.
	 * */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        int value = 0;
        int actual = 0;
        
        while(l1 != null && l2 != null){
            value = l1.data + l2.data + carry;
            actual = value%10;
            carry = value/10;
            ListNode newNode = new ListNode(actual);
            curr.next =  newNode;
            curr = curr.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null) curr.next = l2;
        if(l2 == null) curr.next = l1;
        
        return dummy.next;
    }
	
	public boolean detectLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;	
		while(slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast) {
				return true;
			}
		}		
		return false;		
	}
	
	public Map<String,Object> loopDetails(ListNode head){
		Map<String,Object> map = new HashMap<String,Object>();
		ListNode slow = head;
		ListNode fast = head;
		boolean loopExists = false;
		while(slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast) {
				loopExists = true;
				break;
			}
		}
		
		int loopLength = 0;
		if(loopExists) {
			while(slow.getNext() != fast) {
				loopLength ++;
				slow=slow.getNext();
			}
			loopLength ++;
		}
		map.put("loopLength", +loopLength);
		
		return map;
		
	}
	
}
