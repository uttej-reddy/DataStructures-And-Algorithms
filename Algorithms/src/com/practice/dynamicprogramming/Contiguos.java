package com.practice.dynamicprogramming;

public class Contiguos {

	public static void main(String[] args) {
		int[] arr = new int[] {-2,-3,4,-1,-2,1,5,-3};
		int[] arr1 = new int[] {-2,11,-4,0,5,2,-2,1};
		int result = contiguosSumAlt(arr);
		int result1 = contiguosSumAlt(arr1);
		System.out.println("Non Contiguos Sum : " +result);
		System.out.println("Non Contiguos Sum : " +result1);
		
		int result3 = contiguosSumCont(arr1);
		System.out.println("Contiguos sum : " +result3);

	}
	
	public static int contiguosSumCont(int[] arr) {
		int[] M = new int[arr.length];
		M[0] = arr[0];
		int  sum = 0;
		for(int i=1;i<arr.length;i++) {
			sum =  arr[i]+M[i-1];
			M[i] = Math.max(sum, arr[i]);
		}
		return M[arr.length-1];
	}
	
	public static int contiguosSumAlt(int[] arr) {
		int[] CS = new int[arr.length];
		CS[0] = arr[0];
		CS[1] = arr[1];
		int sum = 0;
		for(int i=2; i<arr.length; i++) {
			sum = Math.max(arr[i], arr[i]+ CS[i-2]);
			CS[i] = Math.max(sum, CS[i-1]);
		}
		
		return CS[arr.length-1];
	}

}
