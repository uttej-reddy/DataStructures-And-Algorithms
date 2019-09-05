package com.practice.sortingnew;


/*
 * This is from mycodeschool - most understandable implementation
 * 
 * */
public class QuickSort extends SortingHelper {

	public static void main(String[] args) {

		QuickSort qs = new QuickSort();
		
		int[] arr = new int[] {10,80,30,90,100,40,50,70};
		System.out.println("UNSORTED ARRAY");
		qs.printArray(arr);
		qs.quickSort(arr, 0, arr.length-1);
		System.out.println("ARRAY AFTER QUICKSORT");
		qs.printArray(arr);

	}
	
	public void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}		
	}

	public int partition(int[] arr, int low, int high) {
		int pIndex = low;
		int pivot = arr[high];
		int temp;
		
		for(int i=low; i<high; i++) {
			if(arr[i] < pivot) {
				temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				// i++;  no need of this, for loop takes care
				pIndex++;
			}
		}
		temp = arr[pIndex]; 
		/* arr[pIndex] = pivot; // here it should be arr[high] and not pivot. 
			pivot = temp;	     exchanging with pivot exchanges the assigned variable only 
		 */
		arr[pIndex] = arr[high];
		arr[high] = temp;
		
		return pIndex;
	}
	
}
