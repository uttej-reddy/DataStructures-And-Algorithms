package com.leetcode.prep;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int[] row : mat) 
  
            // converting each row as string 
            // and then printing in a separate line 
            System.out.println(Arrays.toString(row)); 
    } 
  
    public static void main(String args[]) throws IOException 
    { 
    	Solution sol = new Solution();
        int mat[][] = { { 1, 1, 0 }, 
                        { 1, 0, 1 }, 
                        { 0, 0, 0 } }; 
        print2D(mat); 
        sol.flipAndInvertImage(mat);
        System.out.println();
        print2D(mat);
        
        int[] A = new int[]{3,1,2,4};
        System.out.println(Arrays.toString(A));
        int[] res = sol.sortArrayByParity(A);
        System.out.println(Arrays.toString(res));
        
        String s = "((())())(())";
        String resS = sol.removeOuterParentheses(s);
        System.out.println();
        System.out.println(resS.toString());
        
        System.out.println();
        //System.out.println(sol.calPoints(new String[] {"5","2","C","D","+"}));
        
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(sol.searchMatrix(matrix, 11));
        
        

        
    }
	
	public int[][] flipAndInvertImage(int[][] A) {
        
        for(int i=0;i<A.length;i++){
            if(A[i].length % 2 == 0){
                for(int j=0; j<A[i].length/2; j++){
                    int temp = A[i][j];
                    A[i][j]  = (A[i][A[i].length-1-j]==0)?1:0;
                    A[i][A[i].length-1-j]= (temp == 0)?1:0;
                 }
            }
            else{
                int j=0;
                 for( j=0; j<A[i].length/2; j++){
                    int temp = A[i][j];
                    A[i][j]  = (A[i][A[i].length-1-j]==0)?1:0;
                    A[i][A[i].length-1-j]= (temp == 0)?1:0;
                 }
                    A[i][j] = (A[i][j]==0)?1:0;
            }
                
        }
        
        return A;
    }
	
	public int[] sortArrayByParity(int[] A) {
        int[] parity = new int[A.length];
        int j =0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2 == 0){
                parity[j] = A[i];
                j++;
            }    
        }
         for(int i=0;i<A.length;i++){
            if(A[i]%2 == 1){
                parity[j] = A[i];
                j++;
            }    
        }
        
        
        return parity;
    }

	public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
	
	public int calPoints(String[] ops) {
        Stack<String> s1 = new Stack<String>();
        int sum=0; 
        
        for(String s : ops){
           
            if("C".equalsIgnoreCase(s)){
            	int num = Integer.parseInt(s1.pop());
                sum  = sum - num;
            } 
            if("D".equalsIgnoreCase(s)){
                int num = 2*Integer.parseInt(s1.peek());
                s1.push(String.valueOf(num));
                sum = sum + num;
            }
            if("+".equalsIgnoreCase(s)){
                int top1 = Integer.parseInt(s1.pop());
                int top2 = Integer.parseInt(s1.pop());
                int top = top1+top2;
                sum =  sum + top;
                s1.push(String.valueOf(top2));
                s1.push(String.valueOf(top1));
                s1.push(String.valueOf(top));
                
            }else{
                int num = Integer.parseInt(s);
                sum = sum + num;
                
                s1.push(s);
            
            }
            
        }
        
        return sum;
    }
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0  ||  matrix[0].length ==  0) return false;
        
        int r = matrix.length;
        int c = matrix[0].length;
        int midR = -1;
        int lowR = 0;
        int highR = r-1;
        
        int midC = -1;
        int lowC = 0;
        int highC = c-1;
        
        while(lowR <= highR){
            midR = (lowR + highR)/2;
            if(target < matrix[midR][0])
                highR = midR-1;
            else if( target > matrix[midR][0])
                lowR = midR +  1;
            else
                return true;
        }
        if (highR > -1) {
	        while(lowC  <=  highC ){
	            midC = (lowC + highC)/2;
	            if(target < matrix[highR][midC])
	                highC = midC - 1;
	            else if(target > matrix[highR][midC])
	                lowC = midC +  1;
	            else 
	                return true;
	            
	        }
        }
        
        return  false;
    }
}
