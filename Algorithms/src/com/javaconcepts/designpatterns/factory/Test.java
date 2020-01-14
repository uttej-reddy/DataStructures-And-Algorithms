package com.javaconcepts.designpatterns.factory;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first number");
		double num1 = sc.nextDouble();
		
		System.out.println("Enter second number");
		double num2 = sc.nextDouble();
		
		CalculateFactory factory = new CalculateFactory();
		Calculate obj = factory.getCalculation(sc.next());
		
		sc.close();
		
		obj.calculate(num1, num2);
	}

}
