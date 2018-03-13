package com.practice.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		MyStackTest my = new MyStackTest();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.printStack(stack.top);
		
		System.out.println("Top is : " + stack.peek());
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printStack(stack.top);
		
		String parenthesis = "()[](([]))";
		System.out.println("Is valid parenthesis " +my.isValid(parenthesis));
		
		//my.test();
		int[] nextGreaterElement = my.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
		System.out.println("Array  -- >" +Arrays.toString(nextGreaterElement));
	}
	
    public boolean isValid(String parenthesis) {
    	MyStack parenthesisStack = new MyStack();
    	for (char c : parenthesis.toCharArray()) {
			if( c == '(') parenthesisStack.push(')');
			else if( c == '{') parenthesisStack.push('}');
			else if (c == '[') parenthesisStack.push(']'); 
			else{
				
				if (parenthesisStack.length == 0 || parenthesisStack.pop().data != (int)c) return false;
			}
		}
       return parenthesisStack.isEmpty();
    }
	
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums2){
        	if(!stack.isEmpty()){
        		while(!stack.isEmpty() && stack.peek()< num){ 
        			map.put(stack.pop(), num);
        		}
           	}
        	stack.push(num);
        }
        
        int[] result = new int[nums1.length];
        for(int i =0 ; i < nums1.length; i++){
        	if(map.containsKey(nums1[i]))
        	result[i] = map.get(nums1[i]);
        	else
        	result[i] = -1;
        }
        
        return result;
        
    }
    
	public void test(){
		Map<Integer, Integer> map = new HashMap<>();
		char[] cArray = new char[5];
		cArray[0] = 'c' ; 
		cArray[1] = 'a' ; 
		cArray[2] = 't' ;
		System.out.println(cArray);
	}

}
