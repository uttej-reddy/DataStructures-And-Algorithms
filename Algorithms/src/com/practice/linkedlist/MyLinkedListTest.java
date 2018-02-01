package com.practice.linkedlist;

import com.practice.linkedlist.MyLinkedList.Node;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		
		ll.insertFront(10);
		ll.insertFront(5);
		ll.printList(ll.head);
		System.out.println("-----------");
		ll.insertEnd(5);
		ll.insertFront(2);
		ll.insertEnd(2);
		ll.insertFront(10);
		ll.insertEnd(10);
		//ll.insertFront(50);
		
		ll.printList(ll.head);
		Node reverse = ll.reverseList(ll.head);
		System.out.println("Reverse");
		ll.printList(reverse);
		System.out.println("length " +ll.length(reverse));
		
		/*change this implementation to return to correct head
		 * 
		boolean isPalindrome = ll.isPalindrome(reverse);
		System.out.println("Palindrome " +isPalindrome);
		
		*/
		Node rotateHead= ll.rotateRight(reverse, 2);
		System.out.println("Rotate List");
		ll.printList(rotateHead);
		
		MyLinkedList ll2 = new MyLinkedList();
		
		ll2.insertFront(7);
		ll2.insertFront(6);
		ll2.insertFront(5);
		ll2.insertFront(4);
		ll2.insertFront(3);
		ll2.insertFront(2);
		ll2.insertFront(1);
		ll2.printList(ll2.head);
		ll2.reorderList(ll2.head);
		/*ll.removeElements(10);
		ll.printList();*/
		/*Node deletedNode = ll.deleteFront();
		System.out.println("Deleted" + deletedNode.data);
		ll.printList();
		
		ll.insertAfter(ll.new Node(20), 30);
		
		Node deletedNodel = ll.deleteEnd();
		System.out.println("Deleted" + deletedNodel.data);
		ll.printList();

		Node deletedNode2 = ll.deleteFront();
		System.out.println("Deleted" + deletedNode2.data);
		ll.printList();
		
		Node deletedNode3 = ll.deleteEnd();
		System.out.println("Deleted" + deletedNode3.data);
		ll.printList();*/
		

	}

}
