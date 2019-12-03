package com.leetcode.prep;

public class LeetCode917 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LeetCode917 lc = new LeetCode917();
		String str = 
				"a-bC-dEf-ghIj";
		System.out.println(lc.reverseOnlyLetters(str));
	}
	
	public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length()-1;
        char[] rev = new char[S.length()];
        
        while(i != j && i<j){
            if( (S.charAt(i) < 65 ) || (S.charAt(i) > 122) || 
               (S.charAt(i) > 90 && S.charAt(i) < 97) ){
                rev[i] = S.charAt(i);
                i++;
            }
            else if( (S.charAt(j) < 65 ) || (S.charAt(j) > 122) || 
               (S.charAt(j) > 90 && S.charAt(j) < 97) ){
                rev[j] = S.charAt(j);
                j--;
            }
            else if(((S.charAt(j) >= 65 && S.charAt(j) <= 90) ||
                   (S.charAt(j) >= 97 && S.charAt(j) <= 122)) && 
                   ((S.charAt(i) >= 65 && S.charAt(i) <= 90) ||
                   (S.charAt(i) >= 97 && S.charAt(i) <= 122)))  {    
                rev[i] = S.charAt(j);
                rev[j] = S.charAt(i);
                i++;
                j--;
            }  
        }
        
        if(i == j){
            rev[i] = S.charAt(i);
        }
        
        return new String(rev);
    }

}
