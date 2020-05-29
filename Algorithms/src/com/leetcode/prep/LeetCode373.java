package com.leetcode.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode373 {

	public static void main(String[] args) {
		
		LeetCode373 lc = new LeetCode373();
		int[] nums1 = {1,2,11};
		int[] nums2 = {2,4,6};
		List<List<Integer>> result = lc.kSmallestPairs(nums1, nums2, 3);
		System.out.println(result);
		

	}
	
public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0  || nums2.length == 0 || k==0) return res;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        int count = 0;
        
        for(int i=0; i<nums1.length && i<k; i++)
            pq.add(new Node(i,0,nums1[i]+nums2[0]));
        
        while(!pq.isEmpty()){
            if(count++ == k) 
                break;
            else{
                Node pop = pq.poll();
                res.add(Arrays.asList(nums1[pop.x],nums2[pop.y]));
                int yco =   pop.y + 1;
                if(yco < nums2.length){
                    System.out.println("y co-ord " + yco);
                    pq.add(new Node(pop.x, yco, nums1[pop.x]+nums2[yco]));
                }
            }
        }
    
    return res;
    
    }
    


class Node{
        int x;
        int y;
        int val;
        
        public Node(int pos1, int pos2, int val){
            this.x = pos1;
            this.y = pos2;
            this.val = val;
        }
    }
    
    class NodeComparator implements Comparator<Node>{
        
        public int compare(Node a, Node b){
            return a.val-b.val;
        }
    }

}
