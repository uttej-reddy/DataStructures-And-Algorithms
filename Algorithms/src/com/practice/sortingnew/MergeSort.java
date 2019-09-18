package com.practice.sortingnew;

public class MergeSort extends SortingHelper {

	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		int[]arr = new int[] {38,27,43,3,9,82,10,15};
		System.out.println("Before MergeSort");
		ms.printArray(arr);
		ms.mergeSort(arr, 0, arr.length-1);
		System.out.println("After MergeSort");
		ms.printArray(arr);

	}
	
	public void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
		
	}
	
	public void merge(int[] arr, int left, int mid, int right) {
		
		int n1 = mid - left +1;
		int n2 = right - mid;
		
		int[] L = new int[n1]; int[] R = new int[n2];
		
		for(int i=0; i<n1; i++) {
			L[i] = arr[i+left];
		}
		
		for(int j=0; j<n2; j++) {
			R[j] = arr[j+mid+1];
		}
		
		int i=0 , j = 0; int k = left;
		
		while ( i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
				k++;
			}else {
				arr[k] = R[j];
				j++;
				k++;
			}	
		}
		
		while(i<n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		
		
	}

}
