package com.javaconcepts.designpatterns.factory;

public class Add implements Calculate {

	@Override
	public void calculate(double a, double b) {
		// TODO Auto-generated method stub
		System.out.println("a + b : " + a+b);
	}

}
