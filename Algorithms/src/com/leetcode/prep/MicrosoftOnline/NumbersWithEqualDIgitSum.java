package com.leetcode.prep.MicrosoftOnline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;import java.util.Map;

public class NumbersWithEqualDIgitSum {

	public static void main(String[] args) {
		int[] nums = {51,60,42};
		int result = sum(nums);
		
		System.out.println("MAXIMUM is : " +result);

	}

	public static int sum(int[] nums) {
		
		int max = -1;
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();		
		
		for(int num :  nums) {
			int sum = 0;
			int temp = num;
			while(temp > 0) {
				sum += temp%10;
				temp /= 10;
			}
			
			if(!map.containsKey(sum)) {
				ArrayList<Integer> l = new ArrayList<>();
				l.add(num);
				map.put(sum, l);
			}else {
				ArrayList<Integer> l  = map.get(sum); 
				if(num > l.get(0)) {
					l.add(0,num);
					
				}else {
					l.add(num);
				}
				map.put(sum, l);
			}
		}
		
		for(Map.Entry<Integer,ArrayList<Integer>> e : map.entrySet()) {
			int sum = e.getValue().get(0) + e.getValue().get(1);
			max = Math.max(max, sum);
		}
		
		return max;
	}
}
