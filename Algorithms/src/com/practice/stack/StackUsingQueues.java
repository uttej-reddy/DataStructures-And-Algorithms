package com.practice.stack;

import java.util.LinkedList;
import java.util.Queue;


public class StackUsingQueues {
	
	Queue<Integer> queue = new LinkedList<Integer>();
	

    /** Push element x onto stack. */
    public void push(int x) {
    	queue.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       top();
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
    	 for(int i =1 ; i<queue.size(); i++){
         	queue.add(queue.poll());
         }
    	 return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return(queue.isEmpty());
    }
}
