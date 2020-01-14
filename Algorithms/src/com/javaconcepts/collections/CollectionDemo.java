package com.javaconcepts.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionDemo {

	public static void main(String[] args) {
		
		Map<String,Integer> m = new HashMap<String,Integer>();
		
		List<Integer>  l =   new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		
		
		Iterator<Integer> itr = l.iterator();
		for(int i=0; i<l.size();i++) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		
		
		
		m.put("Uttej", 10);
		m.put("Reddy", 20);
		m.put("Nikitha", 30);
		m.put("Guduru", 40);
		
		List<Integer> i = new ArrayList<Integer>(m.values());
		
		
		
		for(Map.Entry<String, Integer> entry : m.entrySet()) {
			System.out.println(" Key : " +entry.getKey() + "\t" + "Value : " +entry.getValue());
		}
		
		//m.forEach((k,v) -> System.out.println("Key = " +k + ", Value = " + v));
		
		System.out.println("----------------------------");
		
		Map<Employee,String> result = getMap();
		
		for(Map.Entry<Employee, String> entry : result.entrySet()) {
			System.out.print("Key : " + entry.getKey().toString() + "\t");
			System.out.println("Value : " + entry.getValue());
		}
		
		System.out.println(" ########## " + result.get(new Employee("101","1990")));
		
		LinkedList<String> link = new LinkedList<String>(Arrays.asList("A","B"));
		System.out.println(link.toString());

	}
	
	public static Map<Employee,String> getMap(){
		Map<Employee,String> m = new HashMap<Employee,String>();
		
		Employee e1 = new Employee("101", "1990");
		Employee e2 = new Employee("102", "2000");
		Employee e3 = new Employee("103", "2010");
		
		m.put(e1,"Uttej");
		m.put(e2,"Reddy");
		m.put(e3,"Nikki");
		
		return m;
	}

}

class Employee{
	private String id;
	private String dob;
	
	Employee(String id,String dob){
		this.id=id;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", dob=" + dob + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
