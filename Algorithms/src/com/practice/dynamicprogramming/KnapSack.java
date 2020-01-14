package com.practice.dynamicprogramming;

public class KnapSack {

	public static void main(String[] args) {
		int W = 5;
		int[] wt = {2,4,3,5};
		int[] val = {30,70,50,60};
		int n =4;
		
		System.out.println("0/1 KNAPSACK : "  +knapSack(W, wt, val, n));
		
		int amount = 3;
		int[] coins = {2};
		//System.out.println("No of ways : " +change(amount, coins));
		
		int max = Integer.MAX_VALUE;
		int max1 = max + 1;
		
		System.out.println(max + "," + max1);
		
		System.out.println("MIN COINS : " +coinChangeMinCoins(coins,amount));

	}
	
	public static int knapSack(int W, int[] wt, int val[], int n) {
		
		int[][] dp = new int[n+1][W+1];
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(wt[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j] );
			}
		}
		
		
		
		return dp[dp.length-1][dp[0].length-1];
		
	}
	
	public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for(int i=1; i< dp.length; i++){
            dp[i][0] = 1;
            for(int j=1; j<dp[0].length; j++){
               
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                
            }
        }
        
        return dp[dp.length-1][dp[0].length];
    }

	 public static int coinChangeMinCoins(int[] coins, int amount) {
	        int[][] dp = new int[coins.length+1][amount+1];
	        dp[0][0] = 0;
	        for(int i=0; i<dp.length; i++){
	            for(int j=1; j<dp[0].length; j++){
	                    if(i == 0)
	                        dp[i][j] = Integer.MAX_VALUE;
	                    else{
	                        if(j < coins[i-1])
	                            dp[i][j] = dp[i-1][j];
	                        else{
	                            dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
	                        }
	                    }

	            }
	        }
	        
	        return (dp[coins.length][amount] != Integer.MAX_VALUE) ? dp[coins.length][amount] : -1;
	    }
}
