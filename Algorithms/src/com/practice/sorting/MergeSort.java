package com.practice.sorting;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void mergeSort(int[] array, int left, int right){
		if(left<right){
			int mid = (left+right)/2;
			mergeSort(array, left, mid);
			mergeSort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}
	
	private void merge(int[] array, int left, int mid, int right) {
		
		int n1 = mid-left+1;
		int n2 = right-mid;
		
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		
		for(int i=0;i<n1;i++)
			arr1[i] = array[left+i];
		for(int j=0;j<n2;j++)
			arr2[j] = array[mid+1+j];
		
		int i = 0,j =0;
		int k = left;
		
		while(i<n1 && j<n2){
			if(arr1[i] < arr2[j]){
				array[k] = arr1[i];
				i++;
			}else{
				array[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while(i<n1){
			array[k] = arr1[i];
			i++;
			k++;
			
		}
		while(j<n2){
			array[k] = arr2[j];
			j++;
			k++;
			
		}
		
	}
}
