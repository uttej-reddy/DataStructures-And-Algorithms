package com.javaconcepts.threads;

class Counter{
	
	int count;
	
	// Both  threads are using method same time which creates issue if no  sync word.
	// If t1 is executing this t2 should not interfere and viceversa
	public synchronized void increment() {
		count++;
	}
}

public class ThreadSyncronizationDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Counter c =  new Counter();
			
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				for(int i=0; i<1000;  i++) {
					c.increment();
				}
			}
			
		}) ;
		
		Thread t2 =  new Thread(new Runnable() {

			public void run() {
				for(int i=0; i<1000; i++)
				c.increment();	
			}
			
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
		System.out.println("Counter is : " +c.count );
	}

}
