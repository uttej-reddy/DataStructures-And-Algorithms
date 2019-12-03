package com.leetcode.prep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class LeetCode347 {

	public static void main(String[] args) {
		LeetCode347 lc = new LeetCode347();
		Frequent fq = new Frequent();
		int[] arr = new int[] {1,1,1,2,3,3,3,3,4,4,4,4,4,5,5,5,5,5};
		List<Integer> l = fq.topKFrequentB(arr, 2);
		System.out.println(l.toString());

	}

}

class Frequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num :  nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new FreqComparator());
        for(Map.Entry<Integer, Integer> n : map.entrySet()){
        	pq.add(n);
        	if(pq.size()  > k)
        		pq.poll();
        }
        
        List<Integer> l = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
        	l.add(0,pq.poll().getKey());
        }
        
		return l;
        
    }
    
    public List<Integer> topKFrequentB(int[] nums, int k) {

    	List<Integer>[] bucket = new List[nums.length + 1];
    	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

    	for (int n : nums) {
    		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    	}

    	for (int key : frequencyMap.keySet()) {
    		int frequency = frequencyMap.get(key);
    		if (bucket[frequency] == null) {
    			bucket[frequency] = new ArrayList<>();
    		}
    		bucket[frequency].add(key);
    	}

    	List<Integer> res = new ArrayList<>();

    	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
    		if (bucket[pos] != null) {
    			res.addAll(bucket[pos]);
    		}
    	}
    	return res;
    }
}

class FreqComparator implements Comparator<Map.Entry<Integer, Integer>>{   
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
        if(o1.getValue()  < o2.getValue()) return -1;
        else if(o1.getValue()  > o2.getValue()) return 1;
        return 0;
    }
}
