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
		
		double median = medianOfTwoSortedArrays(a, b);
		
		System.out.println("MEDIAN is : " + median);
	}
	
	public static double medianOfTwoSortedArrays(int[] a, int[] b) {
		
		if(a.length > b.length)
			return medianOfTwoSortedArrays(b,a);
		
		int low = 0;
		int high = a.length;
		
		while(low <= high) {

			int px  = low + (high-low)/2;
			int py =  (a.length + b.length + 1 )/2 - px;
			
			int maxX = (px == 0)? Integer.MIN_VALUE : a[px-1];
			int minX = (px == a.length) ? Integer.MAX_VALUE : a[px];
			
			int maxY  = (py == 0) ? Integer.MIN_VALUE : b[py-1];
			int minY =  ( py == b.length) ? Integer.MAX_VALUE: b[py];
			
			if(maxX <= minY && maxY <= minX) {
				if((a.length +  b.length)%2 == 0)
					return (Math.max(maxX, maxY) + Math.min(minY, minX))/2.0;
				else
					return (double)Math.max(maxX,maxY);
			}else if(maxX > minY) {
				high = px - 1;
			}else {
				low = px + 1;
			}
				
		}
		
		return -1.0d;
	}

}
