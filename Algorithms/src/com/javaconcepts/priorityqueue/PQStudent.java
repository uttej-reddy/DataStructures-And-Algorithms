package com.javaconcepts.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Student> pq = new PriorityQueue<Student>(new StudentComparator());
		
		pq.add(new Student("uttej", 4.0));
		pq.add(new Student("reddy", 3.5));
		pq.add(new Student("nikki", 3.9));
		pq.add(new Student("abhi", 3.95));
		pq.add(new Student("bunny", 3.0));
		
		Student[] pqA =  pq.toArray(new Student[0]);
		for(Student s :  pqA) {
		
			System.out.println("PQ is : " + s.getName()+ "-->" +s.getGpa());

		}	
		
		System.out.println(pq.poll().toString());
		
		Student[] pqA1 =  pq.toArray(new Student[0]);
		for(Student s :  pqA1) {
			
			System.out.println("PQ is : " + s.getName()+ "-->" +s.getGpa());

		}
	}

}

class Student{
	private String name;
	private double gpa;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getGpa() {
		return this.gpa;
	}
	
	public void setGpa(double cgpa) {
		this.gpa = cgpa;
	}
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name + "-->" + this.gpa);
		
		return sb.toString();
	}
}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1.getGpa()< o2.getGpa()) return -1;
		else if (o1.getGpa()>o2.getGpa()) return 1;
		
		return 0;
	}
	
	
}