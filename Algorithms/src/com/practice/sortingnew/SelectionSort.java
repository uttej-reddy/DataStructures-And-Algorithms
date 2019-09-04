package com.practice.sortingnew;

public class SelectionSort extends SortingHelper {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		int[] arr1 = new int[] {65,55,21,23,8,15};
		ss.printArray(arr1);
		ss.selectionSort(arr1);
		ss.printArray(arr1);

	}
	
	public void selectionSort(int[] arr) {
		int N = arr.length;
		
		for(int i=0; i<N-1; i++) {
			int min = i;
			for(int j = i+1; j<N; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

}
