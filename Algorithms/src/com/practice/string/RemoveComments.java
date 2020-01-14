package com.practice.string;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
	
	public List<String> removeComments(String[] source) {
        
        boolean block = false;
        List<String> res = new ArrayList<>();
        StringBuilder sb =  new StringBuilder();
        
        for(String s : source){
            for(int i=0; i<s.length(); i++){
                if(block){
                    if(s.charAt(i) == '*' &&  i<s.length() -1  && s.charAt(i+1) == '/') {
                    	block = false;
                    	i++;
                    }
                 }else{
                    if(s.charAt(i)  == '/' && i < s.length()-1 &&  s.charAt(i+1) == '/')
                    	break;
                    else  if(s.charAt(i) == '/' && i < s.length()-1 && s.charAt(i+1) == '*') {
                    	block = true;
                    	i++;
                    }else {
                    	sb.append(s.charAt(i));
                    }
                    	
                }
            }
            
            if(!block && sb.length() > 0) {
            	res.add(sb.toString());
            	sb  =  new StringBuilder();
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		
		RemoveComments rc   =  new RemoveComments();
		String[ ] str =  {"a/*comment", "line", "more_comment*/b"};
		System.out.println(rc.removeComments(str));

	}

}
