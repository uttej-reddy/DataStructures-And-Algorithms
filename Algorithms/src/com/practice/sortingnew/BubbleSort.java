package com.practice.sortingnew;

public class BubbleSort extends SortingHelper {

	public static void main(String[] args) {

		BubbleSort bs = new BubbleSort();
		int[] arr1 = {1,2,3,4,5,6,7};
		System.out.println("Before Sort");
		bs.printArray(arr1);
		bs.bubbleSort(arr1);
		System.out.println("After Sort");
		bs.printArray(arr1);
		
		int[] arr2 = {1,2,3,4,5,6,7};
		System.out.println("Before Sort");
		bs.printArray(arr2);
		bs.bubbleSortSmart(arr2);
		System.out.println("After Sort");
		bs.printArray(arr2);

	}
	
	public void bubbleSort(int[] arr) {
		int N = arr.length;
		int inner = 0;
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				inner += 1;
				if (arr[j] > arr[j + 1]) {
					
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("Inner count" +inner);
	}

	public void bubbleSortSmart(int[] arr) {
		int N = arr.length;
		int inner = 0;
		boolean swapped = false;
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				inner +=1;
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped=true;
				}
			}
			if(!swapped) break;
		}

		System.out.println("Inner count" +inner);
	}
}
