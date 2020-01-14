package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrack {

	
	public List<List<Integer>> subsets(int[] arr){
		
		List<List<Integer>> result = new ArrayList();
		List<Integer> tempList = new ArrayList();
		subsetsBackTrack(arr,result, tempList, 0);
		return result;
		
	}
	

	private void subsetsBackTrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {
		result.add(new ArrayList<Integer>(tempList));
		for(int i=start; i<nums.length; i++) {
			tempList.add(nums[i]);
			subsetsBackTrack(nums, result, tempList, i+1);
			tempList.remove(tempList.size()-1);
		}
	}
	

	private List<List<Integer>> subsetsDup(int[] arr) {
		List<List<Integer>> result = new ArrayList();
		List<Integer> tempList = new ArrayList<>();
		Arrays.sort(arr);
		subsetsDupBacktrack(arr, result, tempList, 0);
		return result;
	}


	private void subsetsDupBacktrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, int start) {
		result.add(new ArrayList(tempList));
		for(int i=start; i< nums.length; i++) {
			if(i > start && nums[i] == nums[i-1]) continue;
			tempList.add(nums[i]);
			subsetsDupBacktrack(nums, result, tempList, i+1);
			tempList.remove(tempList.size()-1);
		}
	}


	public static void main(String[] args) {
		BackTrack bt = new BackTrack();
		
		List<List<Integer>> l1 = bt.subsets(new int[]{1,2,3});
		System.out.println(l1);
		
		List<List<Integer>> l4 = bt.subsetsDup(new int[]{4,4,4,1,4});
		System.out.println(l4);
		
		//List<List<Integer>> l2 = bt.permute(new int[]{1,2,3});
		//System.out.println(l2);
		
		//List<List<Integer>> l3 = bt.combinationSum(new int[]{2,3,5}, 8);
		//System.out.println(l3);
		
	}


	

}
