package com.practice.heap;

import java.util.Arrays;

public class MaxHeap2 {

	public int[] heap;
	public int count ;
	public int capacity;
	
	public MaxHeap2(int n) {
		this.capacity = n;
		this.count = 0;
		heap = new int[n];
	}
	
	public int Parent(int pos) {
		int parent = (pos-1)/2;
		return parent;
	}
	
	public int LeftChild(int pos) {
		 int left = 2 * pos + 1;
		 if(left >= this.count) return -1;
		 return left;
	}
	
	public int RightChild(int pos) {
		int right = 2 * pos + 2;

		 if(right >= this.count) return -1;
		return right;
	}
	
	public void PercolateDown(int pos) {
		int l,r,max;
		max = pos;
		l = LeftChild(pos);
		r = RightChild(pos);
		
		if(l != -1 && this.heap[l] > this.heap[pos]) {
			max = l;
		}
		if(r != -1 && this.heap[r] > this.heap[max]) {
			max = r;
		}
		if(max != pos) {
			int temp = this.heap[pos];
			this.heap[pos] = this.heap[max];
			this.heap[max] = temp;
			PercolateDown(max);
		}
	}
	
	public void Insert(int num) {
		if(this.count ==  this.capacity)
			ResizeHeap();
		this.count++;
		int i = this.count-1;
		while(i > 0 && num > this.heap[(i-1)/2]) {
			this.heap[i] = this.heap[(i-1)/2];
			i = (i-1)/2;
		}
		this.heap[i] = num;
		
	}
	
	private void ResizeHeap() {
		this.heap = Arrays.copyOf(this.heap, this.capacity*2);
		this.capacity = this.capacity*2;
		
	}

	public int Delete() {
		if(this.count == 0) return -1;
		int pop = this.heap[0];
		this.heap[0] = this.heap[this.count-1];
		this.count--;
		PercolateDown(0);
		return pop;
	}
	
	public int Maximum() {
		if(this.count == 0) return -1;
		return this.heap[0];
	}
	
	public static void main(String[] args) {
		MaxHeap2 mh = new MaxHeap2(5);
		mh.Insert(17);
		mh.Insert(90);
		mh.Insert(3);
		mh.Insert(100);
		mh.Insert(84);
		mh.printHeap();
		
		mh.Insert(95);
		mh.printHeap();
		mh.Insert(200);
		mh.Insert(150);
		mh.Insert(175);
		mh.Insert(125);
		mh.Insert(80);
		mh.printHeap();
		
		mh.Delete();
		mh.printHeap();
		mh.Delete();
		mh.printHeap();
	}
	
	public void printHeap() {
		for(int i=0; i<this.count; i++) {
			System.out.print(this.heap[i] + ",");
		}
		System.out.println();
	}
}
