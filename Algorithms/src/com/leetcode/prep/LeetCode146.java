package com.leetcode.prep;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode146 {

	public static void main(String[] args) {
		
		LRUCache lru = new LRUCache(2);
		lru.put(1, 1);
		lru.put(2,2);
		System.out.println(lru.get(1));       // returns 1
		lru.put(3, 3);    // evicts key 2
		System.out.println(lru.get(2));       // returns -1 (not found)
		lru.put(4, 4);    // evicts key 1
		System.out.println(lru.get(1));       // returns -1 (not found)
		System.out.println(lru.get(3));       // returns 3
		System.out.println(lru.get(4)); 

	}
	
	static class LRUCache {
	    
	    int capacity;
	    Queue<Integer> q = new LinkedList<Integer>();
	    Map<Integer,Integer> m = new HashMap<Integer,Integer>();

	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        int l = q.size();
	        while(l>0){
	            int pop = q.poll(); 
	            l--;
	            if(pop != key)
	                q.add(pop);              
	        }
	            q.add(key);
	        
	        if(m.containsKey(key))
	            return m.get(key);
	        else
	            return -1;
	    }
	    
	    public void put(int key, int value) {
	        if(m.size() < capacity)
	            m.put(key,value);
	        else{
	            int pop =  q.poll();
	            m.remove(pop);
	            m.put(key,value);
	        }
	        q.add(key);
	            
	    }
	}


}
