package com.practice.linkedlist;

import java.util.Map;

public class MyLoopedLinkedListTest {

	public static void main(String[] args) {
		
		MyLinkedList loopedList = new MyLinkedList();
		
		loopedList.insertFront(1);
		loopedList.insertFront(2);
		loopedList.insertFront(3);
		loopedList.insertFront(4);
		loopedList.insertFront(5);
		
		ListNode loopNode = loopedList.head.getNext();
		
		loopedList.head.getNext().getNext().getNext().getNext().setNext(loopNode);
		
		boolean hasLoop = loopedList.detectLoop(loopedList.head);	
		System.out.println("Has Loop " +hasLoop);
		
		Map<String, Object> map = loopedList.loopDetails(loopedList.head);
		System.out.println("Loop Length " +map.get("loopLength"));

	}

}
