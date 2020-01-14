package com.javaconcepts.priorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PQExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<String> pQueue = new PriorityQueue<String>();
		
		pQueue.add("C++");
		pQueue.add("C");
		pQueue.add("Java");
		pQueue.add("Python");
		
		System.out.println("Head Value is : " +pQueue.peek());
		pQueue.poll();
		System.out.println("Head Value is : " +pQueue.peek());	
		
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(new IntComparator());
		
		pq1.add(2);
		pq1.add(4);
		pq1.add(1);
		pq1.add(8);
		pq1.add(10);
		
		
		System.out.println("COmparator is : " +pq1.comparator());
		System.out.println("PQ values are :" +pq1);
		
		pq1.poll();
		System.out.println("PQ values are : " +pq1 );
		
	}
	
	

}


class IntComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		
		if(o1 > o2) return 1;
		else if(o1 < o2) return -1;
		return 0;
	}
	
}


