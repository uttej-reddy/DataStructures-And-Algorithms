package com.javaconcepts.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class ComparatorDemo {

	public static void main(String[] args) {
		
		List<Integer> values = new ArrayList<Integer>();
		values.add(3);
		values.add(6);
		values.add(2);
		values.add(8);
		values.add(5);
		
		CompImpl comp =  new CompImpl();
		Collections.sort(values, comp);
		System.out.println(values);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(209);
		list.add(391);
		list.add(444);
		list.add(732);
		list.add(787);
		
		LastDigitComp ldComp = new LastDigitComp();
		
		Collections.sort(list,ldComp);
		System.out.println("Compare using last digits");
		System.out.println(list);
		
		List<Laptop> laptops = new ArrayList<Laptop>();
		laptops.add(new Laptop(8,800,"Acer"));
		laptops.add(new Laptop(16,1200, "Dell"));
		laptops.add(new Laptop(12, 1600, "Apple"));
		laptops.add(new Laptop(8,1000,"Chromebook"));
		
		Collections.sort(laptops,new LaptopComp());
		
		for(Laptop l : laptops) {
			System.out.println(l.getRam()+ " " + l.getName()+ " " +l.getPrice() );
		}
		
		

	}

}
