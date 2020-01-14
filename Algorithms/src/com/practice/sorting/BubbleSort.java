package com.practice.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort bs = new BubbleSort();
		int[] array = {8,5,4,7,6,2,3};
		System.out.println("Before BUBBLE SORT");
		printArray(array);
		System.out.println("Before BUBBLE SORT");
		bs.sort(array);
		printArray(array);
	}
	
	public void sort(int[] arr){
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr [j+1] = temp;
				}
			}
		}
	}
	
	public static void printArray(int[] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
