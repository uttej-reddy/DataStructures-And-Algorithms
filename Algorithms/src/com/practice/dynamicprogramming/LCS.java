package com.practice.dynamicprogramming;

public class LCS {

	public static void main(String[] args) {
		
		LCS lcs = new LCS();
		String str1 = "ABCBDAB";
		String str2 = "BDCABA";
		System.out.println(lcs.longestCommonSubSeq(str1, str2));
		
		String[] words = {"dog","beaver","cat","fox","squirrel","parakeet"};
		System.out.println("MIN DISTANCE WORDS : " +solution(words, "squirrel", "beaver"));
	
		
		System.out.println("PALINDORMIC SEQ : " +lcs.longestPalindromicSubSeq("cbabdab"));	
		System.out.println("O(n) space palindromic subseq : " +lcs.longestPalindromeSubseq("bbbab"));
		
		String str3 =  "abcdfa";
		String str4 =  "zbcdf";
		System.out.println("Longest Common SubString : " +lcs.longestCommonSubString(str3, str4));
		
		System.out.println("Longest Palindrome SUbstring : " +lcs.longestPalindrome("babad"));
		System.out.println("No.of Palindrome SUbstring : " +lcs.countSubstrings("abc"));

	}
	
	public String longestPalindromicSubSeq(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		String rev = sb.reverse().toString();
		
		return longestCommonSubSeq(s, rev);
	}
	
	public String longestCommonSubSeq(String str1, String str2) {
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
	
	public int longestCommonSubString(String s1, String s2) {
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int max = Integer.MIN_VALUE;
		
		for(int i=1; i<dp.length; i++ ) {
			for(int j=1; j<dp[0].length; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 +  dp[i-1][j-1];
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		return max;
	}
	
	public int longestPalindromeSubseq(String s) {
		int[] dp = new int[s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			dp[i] = 1;
			int pre = 0;
			for (int j = i + 1; j < s.length(); j++) {
				int tmp = dp[j];
				if (s.charAt(i) == s.charAt(j)) {
					dp[j] = pre + 2;
				}
				else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
				pre = tmp;
			}
		}

		return dp[s.length() - 1];
	}
	
	public String longestPalindrome(String s) {
		  int n = s.length();
		  String res = null;
		    
		  boolean[][] dp = new boolean[n][n];
		    
		  for (int i = n - 1; i >= 0; i--) {
		    for (int j = i; j < n; j++) {
		      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
		            
		      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
		        res = s.substring(i, j + 1);
		      }
		    }
		  }
		    
		  return res;
		}
	
	 public  int countSubstrings(String s) {
	        int l = s.length();
	        
	        boolean dp[][] = new boolean[l][l];
	        int   count =  0; 
	        
	        for(int i=l-1; i>=0; i--){
	            for(int j=i;  j<l; j++){
	                if((s.charAt(i) == s.charAt(j)) && (j - i <=2  || dp[i+1][j-1]) ){
	                    dp[i][j] = true;
	                    count  ++;
	                }
	                    
	            }
	        }
	        
	        return count;
	    }
	
	public static long solution(String[] words, String word1, String word2) {
        if(words == null  || words.length == 0) return 0L;
        long d1 = -1 ; long d2 = -1;
        long min = Long.MAX_VALUE;
        
        for(int i=0; i<words.length; i++){
               if(words[i] == word1)
                   d1 = (long)i;
               if(words[i] == word2)
                   d2 = (long)i;
        }
        
        min = Math.min(min, Math.abs(d1-d2));
        
        return min;
    }

}
