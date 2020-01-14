package com.javaconcepts.threads;

class Uttej implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Uttej");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void test() {
		
	}
	
}

class Reddy implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Reddy");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

public class ThreadRunnableDemo {

	public static void main(String[] args) {
		
		Runnable o1 = new Uttej();
		Runnable o2 = new Reddy();
		
		//o1.test();
		
		Thread t1 = new Thread(o1);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new Thread(o2);
		
		t1.start();
		t2.start();

	}

}
