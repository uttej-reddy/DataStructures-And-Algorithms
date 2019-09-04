package com.practice.sortingnew;

/**
 * DO AGAIN
 */
public class InsertionSort extends SortingHelper {

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] arr = new int[]{65,25,12,22,11};
		is.printArray(arr);
		is.insertionSort1(arr);
		System.out.println("SORTED WAY1");
		is.printArray(arr);	

		is.insertionSort2(arr);
		System.out.println("SORTED WAY2");
		is.printArray(arr);	
	}
	
	public void insertionSort1(int[] arr) {
		int N = arr.length;
		
		for(int i = 1; i < N; i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j] > key) {
				//not this // arr[i] = arr[j]; 
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	public void insertionSort2(int[] arr) {
		int N = arr.length;
		
		for(int i = 1; i < N; i++) {
			for(int j = i; j>0; j--) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}

}
