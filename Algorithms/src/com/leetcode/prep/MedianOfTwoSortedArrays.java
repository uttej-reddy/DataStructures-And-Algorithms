package com.leetcode.prep;


/*  Tushar Roy youtube link
 * 
 * https://youtu.be/LPFhl65R7ww?t=1409
 * 
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = {1,3,5,9,13,15};
		int[] b = {16,17,23,25,29,30};
		
		double median = medianOfTwoSortedArrays(b, a);
		
		System.out.println("MEDIAN is : " + median);
	}
	
	public static double medianOfTwoSortedArrays(int[] nums1, int[] nums2) {
	       int x = nums1.length;
	        int y =  nums2.length;
	        
	        if(x>y)
	            return medianOfTwoSortedArrays(nums2,nums1);
	        
	        int low  = 0;
	        int high  = x;
	        
	        while(low <= high){
	            int px = (low+high)/2;
	            int py = (x+y+1)/2  -  px;
	            
	            int maxX = (px == 0)?Integer.MIN_VALUE : nums1[px-1];
	            int minX = (px == x)? Integer.MAX_VALUE : nums1[px] ;
	            int maxY = (py == 0) ?Integer.MIN_VALUE :  nums2[py-1] ;
	            int minY = (py == y) ?   Integer.MAX_VALUE : nums2[py];
	            
	            if(maxX < minY && maxY < minX){
	                if((x+y)%2 == 0)
	                    return (Math.max(maxX,maxY)+Math.min(minX,minY))/2.0;
	                else
	                    return Math.max(maxX,maxY)/1.0;
	            }else if(maxY > minX){
	                low = px+1;
	            }else{
	                high = px-1;
	            }
	        }
	        
	        return -1.0d;
	    }

}
