package com.practice.string;

public class KMPStringMatching {

	public static void main(String[] args) {
		
		KMPStringMatching kmp = new KMPStringMatching();
		String s = "abxabcabcabyd";
		String p = "abcabyd";
		boolean result = kmp.match(s.toCharArray(), p.toCharArray());
		System.out.println("String are matched : " +result);
		

	}
	
	public int[] lps(char[] pattern) {
		
		int[] lp = new int[pattern.length];
		int j =0;
		int i = j+1;
		
		while(i < pattern.length) {
			
			if(pattern[i] == pattern[j]) {
				lp[i] = 1 + j ;
				i++;
				j++;
			}else {
				if(j != 0)
					j = lp[j-1];
				else
					lp[i] = 0;
					i++;
			}
		}
		
		return lp;
	}
	
	public boolean match(char[] string, char[] pattern) {
		int[] lps = lps(pattern);
		
		int i=0,j=0;
		
		while(i<string.length && j<pattern.length) {
			
			if(string[i] == pattern[j]) {
				i++;
				j++;
			}else {
				if(j != 0) {
					j = lps[j-1];
				}else {
					i++;
				}
			}
		}
		
		if(j == pattern.length)
			return true;
		
		return false;
		
	}

}
