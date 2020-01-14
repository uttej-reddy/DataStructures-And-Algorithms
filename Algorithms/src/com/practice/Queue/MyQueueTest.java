package com.practice.Queue;

import com.practice.linkedlist.ListNode;
import com.practice.stack.MyStack;

public class MyQueueTest {

	public static void main(String[] args) throws Exception {
		
		MyQueue queue1 = new MyQueue();
		
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		
		
		queue1.printQueue();
		
		ListNode detach = queue1.dequeue();
		System.out.println("detached " +detach.data);
		
		queue1.printQueue();
		
		MyQueueTest my = new MyQueueTest();
		QueueUsingStack qus1 = my.new QueueUsingStack();
		
		
		qus1.enqueue(1);
		qus1.enqueue(2);
		
		qus1.dequeue();
		
		qus1.enqueue(3);
		System.out.println("Done");
		
	}
	
	public class QueueUsingStack{
		MyStack stack1 = new MyStack();
		MyStack stack2 = new MyStack();
		
	
		
		public void enqueue(int data){
			stack1.push(data);
		}
		
		public ListNode dequeue(){
			if(stack2.isEmpty()){
				while(!stack1.isEmpty()){
					stack2.push(stack1.pop().data);
				}
			}
			return stack2.pop();
		}
	}

}
