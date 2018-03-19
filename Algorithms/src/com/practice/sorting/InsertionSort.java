package com.practice.sorting;

import java.util.HashSet;
import java.util.Hashtable;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] arr = new int[]{65,25,12,22,11};
		is.printArray(arr);
		is.sort1(arr);
		System.out.println("SORTED WAY1");
		is.printArray(arr);	
		int[] arr2 = new int[]{8,5,1,3,9,4};
		is.sort2(arr2);
		System.out.println("SORTED WAY2");
		is.printArray(arr2);
		
	}
	
	/**
	 *  
	 * */
	public void sort1(int[] array){
		int i,j;
		for(i=1;i<array.length;i++){
			int temp = array[i];
			j = i-1;
			while(j>=0 && temp<array[j]){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
	
	public void sort2(int[] array){
		int i,j;
		for(i=1;i<array.length;i++){
			for(j=i;j>0;j--){
				if(array[j] < array[j-1]){
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				}
			}
		}
	}
	
	public void printArray(int[] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
