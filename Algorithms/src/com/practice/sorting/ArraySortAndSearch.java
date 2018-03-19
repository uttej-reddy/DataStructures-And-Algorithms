package com.practice.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ArraySortAndSearch {

	public static void main(String[] args) {
		
		int[] array = new int[]{1,3,1,2,4,2,2,3,3,3};
		System.out.println(findElement(array));
		
		int[] A = new int[]{1,1,2,2,3,3,4,4,6};
		
		System.out.println(xor(A));
		System.out.println(removeDuplicates(A));
		
		int[] sum = new int[]{10,12,21,33,24};
		
		System.out.println(twoSumsK(sum, 22));

	}
	
	private static boolean twoSumsK(int[] array, int K){

		for(int i =0;i<array.length;i++){

			for(int j =i;j<array.length;j++){
				if(array[i] + array[j] == K){
					return true;
				}
			}
		}
		return false;
	}
	
	private static int xor(int[] array){
		int result = array[0];
		for(int i =1;i<array.length;i++){
			result ^= array[i];
		}
		return result;
	}

	private static int findElement(int[] array){
		int counter,max = 1;
		int maxCounter = 1;
		Map<Integer,Integer> map = new HashMap();
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i])){
				counter = map.get(array[i])+1;
				map.put(array[i], counter);
				if(maxCounter<counter){
					maxCounter = counter;
					max = array[i];
				}
			}else{
				map.put(array[i], 1);
			}
		}
		
		return max;
	}
	
	private static int removeDuplicates(int[] A){
		int len = A.length;
		int i =0;
		if(len <=1)
			return len;
		for(int j =1; j<len; j++){
			if(A[j] != A[i])
				A[++i] = A[j];
		}
		return i+1;
	}
}
