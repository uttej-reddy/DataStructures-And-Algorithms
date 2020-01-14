package com.javaconcepts.java8;

interface Func1{
	int operate(int a, int b);
}

interface Func2{
	void sayMessage(String msg);
}

public class LambdaDemo2 {

	public static void main(String[] args) {
	
		Func1 add = (a,b) -> a+b;
		Func1 mult = (a,b) -> a*b;
		
		System.out.println(add.operate(2, 3));
		System.out.println(mult.operate(2, 3));

	}

}
