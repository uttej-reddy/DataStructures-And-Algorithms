package com.practice.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "abccbadb";
		System.out.println("LengthOfLongestSubstring : " +lengthOfLongestSubstringSliding(s));

	}
	
	public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) 
                	ans = Math.max(ans, j - i);
                else
                	break;
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
         for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    
    
        public static int lengthOfLongestSubstringSliding(String s) {
        	int n =  s.length();
        	
        	int i=0,j=0;
        	Set<Character> set = new HashSet<>();
        	int len =0;
        	
        	while(i<n &&  j<n) {
        		if(!set.contains(s.charAt(j))) {
        			set.add(s.charAt(j));
        			j++;
        			len =  Math.max(len, j-i);
        		
        		}else {
        			set.remove(s.charAt(i));
        			i++;
        		}
        	}
        	
        	return len;
        	
        }
    

}
