package com.javaconcepts.comparator;

import java.util.Comparator;

public class LastDigitComp implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1%10>o2%10) return 9;
		if(o1%10<o2%10) return -9;
		return 0;
	}

}
