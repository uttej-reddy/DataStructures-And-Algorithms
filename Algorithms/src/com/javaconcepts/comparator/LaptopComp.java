package com.javaconcepts.comparator;

import java.util.Comparator;

public class LaptopComp implements Comparator<Laptop> {

	@Override
	public int compare(Laptop o1, Laptop o2) {
		
		int ramCompare = o2.getRam() - o1.getRam();
		int nameCompare = o1.getName().compareTo(o2.getName());
		
		if(ramCompare == 0) {
			return (nameCompare == 0) ? ramCompare : nameCompare;
		}else {
			return ramCompare;
		}
	}



	/*@Override
	public int compare(Laptop o1, Laptop o2) {
		if(o1.getRam() < o2.getRam()) return 1;
		if (o1.getRam()  > o2.getRam()) return -1;
		
		return 0;
	}*/

}
