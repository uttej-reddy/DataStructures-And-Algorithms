package com.leetcode.prep;

public class LeetCode221 {

	public static void main(String[] args) {
		
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		
		System.out.println("Max  square is : "+maximalSquare(matrix));

	}

	public static int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int max = Integer.MIN_VALUE;
        
        int[][] aux = new int[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 || j==0)
                    aux[i][j] = matrix[i][j];
                else{
                  if(matrix[i][j] == '1'){
                      aux[i][j] = Math.min(aux[i-1][j],Math.min(aux[i-1][j-1],aux[i][j-1]))+1;
                      max =  Math.max(max,aux[i][j]);
                  }
            }
        }
    }       
        return max *   max;
}
	public static int maximalSquareS(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
