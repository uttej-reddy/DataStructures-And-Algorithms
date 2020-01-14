package com.leetcode.prep;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	
	int capacity;
    Queue<Integer> q;
    int sum ;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.capacity = size;
        this.q = new LinkedList<>();
        this.sum =  0;
    }
    
    public double Next(int val) {
        if(q.size() < capacity){
        	q.add(val);
            sum += val;
            return sum/(double)(q.size());
        }else{
            sum -= q.poll();
            q.add(val);
            sum += val;
            return sum/(double)(capacity);
        }
    }
    
	public static void main(String[] args) {
			MovingAverage ma = new MovingAverage(3);
			System.out.println(ma.Next(1));
			System.out.println(ma.Next(10));
			System.out.println(ma.Next(3));
			System.out.println(ma.Next(5));

	}

}


