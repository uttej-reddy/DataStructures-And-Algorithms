package com.javaconcepts.threads;



public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
	
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("Hello");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.println("World");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		
		
		t1.start();
		Thread.sleep(10);
		t2.start();
		
		t1.join(); //joins t1 to main thread. It's like asking main to wait for t1 to complete
		t2.join(); //joins t2 to main thread. It's like asking main to wait for t2 to complete
		
		System.out.println("Bye");

	}

}
