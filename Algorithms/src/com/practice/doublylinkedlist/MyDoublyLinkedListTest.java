package com.practice.doublylinkedlist;

public class MyDoublyLinkedListTest {

	public static void main(String[] args) {
		
		MyDoublyLinkedList myDll = new MyDoublyLinkedList();
		
		myDll.insertAtBeginning(3);
		myDll.insertAtBeginning(2);
		myDll.insertAtBeginning(1);
		myDll.insertAtEnd(4);
		myDll.insertAtEnd(5);
		
		myDll.printList(myDll.head);
		System.out.println("Length of DLL is : " +myDll.getLength());
		
		myDll.deleteAtBeginning();
		myDll.deleteAtBeginning();
		myDll.deleteAtEnd();
		myDll.deleteAtEnd();
		myDll.deleteAtEnd();

		myDll.deleteAtBeginning();
		myDll.printList(myDll.head);
		System.out.println("Length of DLL after deletion is : " +myDll.getLength());

	}

}
