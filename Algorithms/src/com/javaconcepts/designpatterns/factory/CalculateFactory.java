package com.javaconcepts.designpatterns.factory;

public class CalculateFactory {
		
	public Calculate getCalculation(String type) {
		
		Calculate obj  = null;
		
		if(type.equalsIgnoreCase("add")) {
			obj = new Add();
		}else if (type.equalsIgnoreCase("subtract")) {
			obj = new Subtract();
		}else if (type.equalsIgnoreCase("divide")) {
			obj = new Divide();
		}else {
			System.out.println("Invalid input type");
		}
		
		return obj;
		
	}
}
