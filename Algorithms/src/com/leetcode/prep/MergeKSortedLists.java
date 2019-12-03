package com.leetcode.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class ElementInsert{
	
	int value;
	int fromArray;
	
	public ElementInsert(int value, int fromArray) {
		this.value = value;
		this.fromArray = fromArray;
	}
	
}

public class MergeKSortedLists {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,3);
		List<Integer> list2 = Arrays.asList(1,4,5);
		List<Integer> list3 = Arrays.asList(2,6,7);
		
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		
		System.out.println(merge(lists).toString());

	}
	
	public static List<Integer> merge(List<List<Integer>> lists){
		
		List<Integer> res = new ArrayList<Integer>();
		
		Iterator<Integer> itr = res.iterator();
		
		List<Iterator<Integer>> itrs = new ArrayList<>();
		
		for(List<Integer> list : lists) {
			itrs.add(list.iterator());
		}
		
		
		PriorityQueue<ElementInsert> minHeap = new PriorityQueue<ElementInsert>(lists.size(), 
				new ElementComparator());
		
		for(int i=0; i<itrs.size(); i++) {
			if(itrs.get(i).hasNext())
			minHeap.add(new ElementInsert(itrs.get(i).next(), i));
		}
		
		while(!minHeap.isEmpty()) {
			ElementInsert pop = minHeap.poll();
			res.add(pop.value);
			
			if(itrs.get(pop.fromArray).hasNext())
				minHeap.add(new ElementInsert(itrs.get(pop.fromArray).next(), pop.fromArray));			
						
		}	
		
		return res;
		
	}
	
}

class ElementComparator implements Comparator<ElementInsert>{
	
	public int compare(ElementInsert o1, ElementInsert o2) {
		if(o1.value < o2.value) return -1;
		else if(o1.value > o2.value) return 1;
		
		return 0;
	}
}
