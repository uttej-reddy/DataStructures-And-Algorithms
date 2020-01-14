package com.leetcode.prep;

public class Leetcode377 {

	public static void main(String[] args) {
		int nums[] = {1,2,3};
		int target = 4;
		int count = (Integer) null;
		System.out.println("count " +count);
		System.out.println("NO OF COMBINATIONS : " +combinationSum4C(nums, target));
	}

	 public static int combinationSum4(int[] nums, int target) {
	        
	        int[][] dp = new int[target+1][nums.length +1];
	        dp[0][0] = 1;
	        
	        for(int i=0; i<dp.length; i++){
	            for(int j=1; j<dp[0].length; j++){
	                if(i==0)
	                    dp[i][j] = 1;
	                if(i - nums[j-1] >= 0)
	                    dp[i][j] += dp[i - nums[j-1]][j];
	            }
	        }
	        
	        return dp[target][nums.length];
	    }
	 
	 public static int combinationSum4C(int[] nums, int target) {
		    int[] comb = new int[target + 1];
		    comb[0] = 1;
		    for (int i = 1; i < comb.length; i++) {
		        for (int j = 0; j < nums.length; j++) {
		            if (i - nums[j] >= 0) {
		                comb[i] += comb[i - nums[j]];
		            }
		        }
		    }
		    return comb[target];
		}
}
