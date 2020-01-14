package com.practice.string;

public class PatternMatch {

	public static void main(String[] args) {
		
		PatternMatch pm = new PatternMatch();
		String s = "yxaylmzbm";
		String p = "*x?y*z*";
		System.out.println(pm.wildCardMatch(s, p));
		
		String s1 = "xaabyc";
		String p1 =  "xa*b.c";
	}
	
	public boolean wildCardMatch(String s, String p) {
		
		boolean[][] dp =  new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		
		for(int j = 1; j <= p.length(); j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }            
        }
		
		for(int i= 1; i< dp.length; i++) {
			for(int j=1; j< dp[0].length; j++) {
				if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
					dp[i][j] = dp[i-1][j-1];
				else if(p.charAt(j-1) == '*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}else {
					dp[i][j] = false;
				}
				
			}
		}
		
		return dp[dp.length-1][dp[0].length-1];
		
	}
	
	
	public boolean regularExpMatch(String s, String p) {
		
		boolean dp = 
		
	}

}
