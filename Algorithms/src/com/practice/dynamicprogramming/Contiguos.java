package com.practice.dynamicprogramming;

public class Contiguos {

	public static void main(String[] args) {
		
		
		
		int[] arr = new int[] {-2,-3,4,-1,-2,1,5,-3};
		String b ;
		int[] arr1 = new int[] {-2,11,-4,0,5,2,-2,1};
		int result = contiguosSumAlt(arr);
		int result1 = contiguosSumAlt(arr1);
		System.out.println("Non Contiguos Sum : " +result);
		System.out.println("Non Contiguos Sum : " +result1);
		
		int result3 = contiguosSumCont(arr);
		System.out.println("Contiguos sum : " +result3);
		
		String s = "ajc";
		String t = "axybkhcjs";
		System.out.println(isSubsequence(s, t));

	}
	
	/*https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
	 *
	 * REFER THIS
	 * */
	 
	public static int contiguosSumCont(int[] arr) {
		int[] M = new int[arr.length];
		M[0] = arr[0];
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			
			M[i] = Math.max(arr[i]+M[i-1], arr[i]);
			max = Math.max(M[i], max);
		}
		return max;
	}
	
	public static int contiguosSumAlt(int[] arr) {
		int[] CS = new int[arr.length];
		CS[0] = arr[0];
		CS[1] = arr[1];
		int sum = 0;
		for(int i=2; i<arr.length; i++) {
			sum = Math.max(arr[i], arr[i]+ CS[i-2]);
			CS[i] = Math.max(sum, CS[i-1]);
		}
		
		return CS[arr.length-1];
	}
	
	public static boolean isSubsequence(String s, String t) {
        int fromIndex = 0;
        for (char c : s.toCharArray()) {
            fromIndex = t.indexOf(c, fromIndex);
            if (fromIndex++ < 0) {
                return false;
            }
        }
        return true;
    }

}
