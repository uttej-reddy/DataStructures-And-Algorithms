package com.practice.sorting;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		
		int[] arr = new int[] {10,80,30,90,40,50,70};
		System.out.println("UNSORTED ARRAY");
		qs.printArray(arr);
		qs.quickSort(arr, 0, arr.length-1);
		System.out.println("ARRAY AFTER QUICKSORT");
		qs.printArray(arr);

	}
	
	public void quickSort(int[] array, int low, int high){
		if(low<high){
			int pI = partition(array,low,high);
			quickSort(array, low, pI-1);
			quickSort(array, pI+1, high);
		}
	}

	/* Also be careful with index and array assignments
	 * */
	private int partition(int[] array, int low, int high) {		
		int pIndex = low;
		int pivot = array[high];
		int temp ;
		
		//remember low and high not array.length
		for(int i=low; i<high;i++){
			if(array[i]<pivot){
				temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				
				pIndex++;
			}
		}
		temp = array[high];
		array[high] = array[pIndex];
		array[pIndex] = temp;
		return pIndex;
	}

	private void printArray(int[] array){
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
