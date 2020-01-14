package com.javaconcepts.comparator;

public class Laptop {
	private int ram;
	private int price;
	private String name;
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Laptop(int ram, int price, String name) {
		this.ram = ram;
		this.price = price;
		this.name = name;
	}
	
	
	
	
}
