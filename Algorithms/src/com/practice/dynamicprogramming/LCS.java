package com.practice.dynamicprogramming;

public class LCS {

	public static void main(String[] args) {
		
		LCS lcs = new LCS();
		String str1 = "ABCBDAB";
		String str2 = "BDCABA";
		System.out.println(lcs.longestCommonSub(str1, str2));

	}
	
	public String longestCommonSub(String str1, String str2) {
		int row = str1.length();
		int col = str2.length();
		
		int[][] lcs = new int[row+1][col+1];
		
		
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=col; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					lcs[i][j] = 1 + lcs[i-1][j-1];
				}else {
					lcs[i][j]  = Math.max(lcs[i-1][j],lcs[i][j-1]);
				}
			}
		}
		
		int result = lcs[row][col];
		StringBuilder sb =  new StringBuilder();
		
		while(row>0 && col>0) {
			if(str1.charAt(row-1) ==  str2.charAt(col-1)) {
				sb.append(str1.charAt(row-1));
				row--;
				col--;
			}else if(lcs[row-1][col] > lcs[row][col-1]) {
				row--;
			}else {
				col--;
			}
		}
		
		return sb.reverse().toString();
	}

}
