package com.practice.heap;

import com.practice.sortingnew.SortingHelper;

public class HeapSort extends SortingHelper {


	public static void main(String[] args) {
		
		HeapSort hs = new HeapSort();
		int[] hsa = new int[] {12,11,13,5,6,7,14};
		System.out.println("Original Array");
		hs.printArray(hsa);
		
		int[] res = hs.heapSort(hsa);
		System.out.println("HEAP  SORTED ARRAY");
		hs.printArray(res);

	}
	
	public int[] heapSort(int[] arr) {
		int n = arr.length;
		//int[] result = new int[n];
		
		
		for(int i=n/2-1; i>=0; i--) {
			Heapify(arr, n, i);
		}
		System.out.println("Heapified Array");
		printArray(arr);
		
		for(int j = n-1 ;  j>=0; j--) {
			int pop = arr[0]; 
			arr[0] = arr[j];
			arr[j] = pop;
			Heapify(arr, j, 0);
		}
		return arr;
	}
	
	/*
	 * Heapify max assignment is important
	 * Give a look for if loops */
	public void Heapify(int[] arr,int length, int pos) {
		int l = (2*pos + 1 >= length) ? -1 : 2*pos + 1 ;
		int r = (2*pos + 2 >= length) ? -1 : 2*pos + 2 ;
		int max = pos;
		
		if(l != -1 && arr[l] > arr[pos]) {
			max = l;
		}
		if(r != -1 && arr[r] > arr[max]) {
			max = r;
		}
		if(max != pos) {
			int temp = arr[pos];
			arr[pos] = arr[max];
			arr[max] = temp;
			Heapify(arr,length, max);
		}
	}
	

}
