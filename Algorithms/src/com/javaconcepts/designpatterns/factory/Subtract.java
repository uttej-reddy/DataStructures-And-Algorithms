package com.javaconcepts.designpatterns.factory;

public class Subtract implements Calculate {

	@Override
	public void calculate(double a, double b) {
		System.out.println("a - b is : " + (a-b));
	}

}
