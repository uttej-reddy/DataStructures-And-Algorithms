package com.practice.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		int[] arr = new int[]{65,25,12,22,11};
		ss.printArray(arr);
		ss.sort(arr);
		System.out.println("SORTED");
		ss.printArray(arr);
	}
	
	/**
	 *  
	 * */
	public void sort(int[] array){
		int i,j;
		for(i=0; i<array.length-1;i++){
			int min = i;
			for(j=i+1; j<array.length;j++){
				if(array[j] < array[min]){
					min = j;
				}
			}
			/*after the inner loop i.e j is run till end 
			min will have reference to minimum value
			 * swap element at min with element at i
			 */
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
			
	}
	
	public void printArray(int[] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
