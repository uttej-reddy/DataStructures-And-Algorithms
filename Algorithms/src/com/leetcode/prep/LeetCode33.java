package com.leetcode.prep;

import java.util.Arrays;

public class LeetCode33 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7};
		int[] nums1 = {2,1};
		int r = search(nums1, 2);
		System.out.println(r);

	}
	
	public static int search(int[] nums, int target) {
        if(nums == null ||  nums.length == 0) return -1;
        int l = 0;
        int h = nums.length-1;
        int m = -1;
        int pivot = -1;
        
        if(nums[l]<nums[h]) {
        	return binarySearch(nums, target, l, h);
        }
        
        while(l<=h){
            m = l + (h-l)/2;
            if(nums[m]>nums[m+1]){
               pivot = m+1; 
               break;
            }else{
                if(nums[m] >= nums[l])
                    l = m+1;
                else
                    h = m-1;
            }
        }
        
        int result = -1;
        if(pivot != -1){
            if(target >= nums[pivot] && target <=nums[nums.length-1]){
                result = binarySearch(nums,target,pivot,nums.length-1);
            }else{
                result = binarySearch(nums,target,0,pivot-1);
            }
            return result;
        }
        
    return pivot;
        
    }
    
    public static int binarySearch(int[] nums, int target,  int l, int h){  
       int m= -1;
    	while(l<=h){
            m = l + (h-l)/2;
            if(nums[m] == target) return m;
            else if(nums[m] > target)
                h = m-1;
            else
                l = m+1;
        }
        return -1;
    }
}
