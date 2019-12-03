package com.leetcode.prep;

import java.util.HashMap;
import java.util.Map;

public class LRUCache  {
	
	int size;
	int capacity;
	DLLNode head, tail;
	Map<Integer, DLLNode> cache = new HashMap<Integer, DLLNode>();
	
	public LRUCache(int n) {
		this.size = 0;
		this.capacity = n;
		head = new DLLNode();
		tail = new DLLNode();
		
		head.next = tail;
		tail.prev = head;
	}


	public void addNode(DLLNode node) {
		
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
		node.prev = head;
	}
	
	public void removeNode(DLLNode node) {
		
		DLLNode next = node.next;
		DLLNode prev = node.prev;
		
		next.prev = prev;
		prev.next = next;
		
	}
	
	public DLLNode popTail() {
		
		DLLNode res = tail.prev;
		removeNode(res);
		return res;
		
	}
	
	public void moveToHead(DLLNode node) {
		removeNode(node);
		addNode(node);
	}
	
	public int get(int key) {
        
		DLLNode result = cache.get(key);
		
		if(result != null) {

			moveToHead(result);
			return result.value;
		}
		
		return -1;
    }
    
    public void put(int key, int value) {
        DLLNode node = cache.get(key);
        
        if(node == null) {
        	DLLNode newNode = new DLLNode();
        	newNode.key =  key;
        	newNode.value = value;
        	
        	cache.put(key,newNode);
        	addNode(newNode);
        	
        	size++;
        	
        	if(size > capacity) {
        		DLLNode pop = popTail();
        		cache.remove(pop.key);
        		size--;
        	}
        }else {
        	node.value = value;
        	moveToHead(node);
        }
    }
	

	public static void main(String[] args) {
		
		LRUCache lru = new LRUCache(2);
		lru.put(1,1);
		lru.put(2, 2);
		System.out.println(lru.get(1));
		lru.put(3, 3);

		System.out.println(lru.get(2));
	}
}

class DLLNode{
	
	int key;
	int value;
	DLLNode next;
	DLLNode prev;
	
}
