package com.javaconcepts.strings;

public class StringTest {

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
		String s1 = "flower";
		String s2 = "flow";
		System.out.println("INDEX : " +s2.indexOf(s1));
		
		System.out.println("Random : " +Math.random()*10 );
		
		char one = '1'; char two = '2';
		int onee = (int)one;
		System.out.println(one + two);
		System.out.println(onee);
		
		if(one+two == 99) {
			System.out.println(true);
		}
		
		System.out.println("ADD STRINGS : " +addStrings("1245", "355"));
		
		char[] charArr = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		char[] charArr1 = {'a','b','c','d','e','f','g','g','g','g','g','g','g','g','g','g','a','b','c'};
		System.out.println("Compressed :" +compress(charArr1) );
		
		System.out.println("DECODE WAYS : " +numDecodings("2206"));
		System.out.println(s1.substring(1,2));
		
	}

	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
	
	 public static String addStrings(String num1, String num2) {
	        
	        int  l1 = num1.length();
	        int l2 = num2.length();
	        StringBuilder sb = new StringBuilder();
	        
	        int i=l1-1,j=l2-1;
	        int carry = 0;
	        int sum =0;
	        
	        while(i >= 0 && j >= 0){
	            int a = num1.charAt(i) - '0';
	            int b = num2.charAt(j) - '0';
	            sum = (a+b+carry)%10;
	            sb.append(sum);
	            carry = (a+b+carry)/10;
	            i--;
	            j--;     
	        }
	        
	        while(i >= 0){
	            int a = num1.charAt(i) - '0';
	            sum = (a+carry)%10;
	            sb.append(sum);
	            carry = (a+carry)/10;
	            i--;
	        }
	        
	        while(j >= 0){
	            int a = num2.charAt(j) - '0';
	             sum = (a+carry)%10;
	            sb.append(sum);
	            carry = (a+carry)/10;
	            j--;
	        }
	        
	        sb.append(carry);
	        
	        return sb.reverse().toString();
	        
	 }
	 
	 public static int compress(char[] chars) {
        if(chars == null  || chars.length <= 1) return chars.length;
	        int count = 1;
	        char comp = chars[0] ;
	        int j=1;
	        for(int i=1; i<chars.length; i++){
	            if(comp == chars[i])
	                count++;
	            else{
                    if(count > 1){
                        for(char c : String.valueOf(count).toCharArray())
                            chars[j++] = c;

                        count = 1;
                        chars[j++] = chars[i];
                        comp = chars[i];
                    }else{
                    	 chars[j++] = chars[i];
                         comp = chars[i];
                    }
	            }
	                
	        }
	        if(count  > 1) {
		        for(char c : String.valueOf(count).toCharArray())
	        		chars[j++] = c;
	        }
	        return j;
	    }
	 
	 public static int numDecodings(String s) {
	        if(s == null || s.length() == 0) {
	            return 0;
	        }
	        int n = s.length();
	        int[] dp = new int[n+1];
	        dp[0] = 1;
	        dp[1] = s.charAt(0) != '0' ? 1 : 0;
	        for(int i = 2; i <= n; i++) {
	            int first = Integer.valueOf(s.substring(i-1, i));
	            int second = Integer.valueOf(s.substring(i-2, i));
	            if(first >= 1 && first <= 9) {
	               dp[i] += dp[i-1];  
	            }
	            if(second >= 10 && second <= 26) {
	                dp[i] += dp[i-2];
	            }
	        }
	        return dp[n];
	    }
}
