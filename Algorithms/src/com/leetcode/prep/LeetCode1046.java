package com.leetcode.prep;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.practice.binarytree.BinaryTreeNode;
import com.practice.binarytree.MyBinaryTree;

public class LeetCode1046 {

	public static void main(String[] args) {
		LeetCode1046 leet = new LeetCode1046();
		LastStone ls =  new LastStone();
		int res = ls.lastStoneWeight(new int[] {2,7,4,1,8,1});
		System.out.println("result : " +res);

	}
	
	
}

class LastStone {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new IntComparator());
        
        for(int stone : stones){
            pq.add(stone);
        }
        int x =0 , y =0;
        
        while(pq.size() > 1){
            if(!pq.isEmpty())
                 y = pq.poll();
            if(!pq.isEmpty())
                 x = pq.poll();
         if(y-x > 0){
            pq.add(y-x);
         }
         x=0;
         y=0;
        }
        return y-x;
        
    }
}

class IntComparator implements Comparator<Integer>{
    
    public int compare(Integer o1, Integer o2){
        
        if(o1 > o2) return -1;
        else if(o1 < o2) return 1;
        return 0;
    }
}

