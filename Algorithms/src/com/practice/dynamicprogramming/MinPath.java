package com.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPath {

	public static void main(String[] args) {
		List<List<Integer>> tri  =  new ArrayList<>();
		List<Integer> l1  =  new ArrayList<Integer>();
		l1.add(2);
		List<Integer> l2  =  new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3  =  new ArrayList<Integer>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		tri.add(l1);
		tri.add(l2);
		tri.add(l3);
		System.out.println("Min Path Triangle : " +minimumTotal(tri) );
		

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
        
        int r = triangle.size();
        int[][] dp =  new int[r][r];
        dp[0][0] = triangle.get(0).get(0);
        
        for(int i=1; i<r; i++){
            for(int j=0; j<=i; j++){
                int cell = Integer.MAX_VALUE;
                if(j-1 >= 0)
                 cell = Math.min(cell, triangle.get(i).get(j) + dp[i-1][j-1]);
                
                if(j < i)
                    cell = Math.min(cell, triangle.get(i).get(j) + dp[i-1][j]);
                
                if(j+1 < i)
                    cell = Math.min(cell, triangle.get(i).get(j) + dp[i-1][j+1]);
                
                dp[i][j] =  cell;
            }
        }
        
        int min =  Integer.MAX_VALUE;
        for(int i : dp[r-1]){
            if(i < min)
                min  = i;
        }
        
        return min;
    }
}
