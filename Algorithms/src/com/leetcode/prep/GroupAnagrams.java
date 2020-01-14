package com.leetcode.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	 public List<List<String>> groupAnagrams(String[] strs) {
	        Map<String,List<String>> map = new HashMap<>();
	        
	        for(String str : strs){
	            char[] ca = str.toCharArray();
	            int[] alpha = new int[26];
	            for(char c : ca){
	                alpha[c - 'a']++; 
	            }
	            StringBuilder sb = new StringBuilder();
	            sb.append("#");
	            for(int i=0; i<alpha.length; i++){
	                sb.append(alpha[i] + "#");
	            }
	            if(!map.containsKey(sb))
	                map.put(sb.toString(),new ArrayList<String>());
	            map.get(sb.toString()).add(str);
	            
	            Arrays.fill(alpha,0);
	            
	        }
	        
	        return new ArrayList<>(map.values());
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
