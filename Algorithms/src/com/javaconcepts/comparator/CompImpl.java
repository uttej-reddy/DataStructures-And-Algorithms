package com.javaconcepts.comparator;

import java.util.Comparator;

public class CompImpl  implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		
		if(o1 > o2) 
			return 1; // 1 is to swap
		if(o1 <  o2) 
			return -1; // -1 is not to swap
		
		return 0;
	}

}
