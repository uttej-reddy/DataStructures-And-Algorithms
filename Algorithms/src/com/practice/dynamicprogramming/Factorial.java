package com.practice.dynamicprogramming;

import java.util.ArrayList;

public class Factorial {

	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>(2);
		a.add(1);
		a.add(1);
		a.add(1);
		
		
		
		int result = fact(5);
		System.out.println(result);

	}
	
	public static int fact(int n) {
		int[] F = new int[n+1];
		F[0] = 1; F[1]=1;
		int i;
		for(i=2; i<n+1; i++) {
			F[i] = i*F[i-1];
		}
		
		return F[i-1];
	}

}
