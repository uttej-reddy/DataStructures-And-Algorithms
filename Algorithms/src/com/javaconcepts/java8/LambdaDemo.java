package com.javaconcepts.java8;

interface A{
	
	void show();
}

public class LambdaDemo {

	public static void main(String[] args) {
		
		A obj1 ;
		obj1 = new A() {
			public void show() {
				System.out.println("From Anonymous Obj");
			}
		};
		
		A  obj2;
		obj2 = () -> {
			System.out.println("From Lambda");
		};
		
		obj1.show();		
		obj2.show();

	}

}
