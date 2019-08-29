package com.practice.heap;

import java.util.Arrays;

public class MaxHeap {

	public int[] heap;
	public int count ;
	public int capacity;
	
	public MaxHeap(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		heap = new int[capacity];
	}
	
	public int Parent(int pos) {
		if(pos<=0 || pos>=count)
		return -1;
		
		return pos-1/2;
		
	}

	public int LeftChild(int pos) {
		int left = 2*pos + 1;
		if(left >= count)
			return -1;
		return left;
	}
	
	public int RightChild(int pos) {
		int right = 2*pos+2;
		if(right >= count) return -1;
		return right;
	}
	
	public int GetMaximum() {
		if(this.count == 0) return -1;
		return this.heap[0];
	}
	
	public void PercolateDown(int pos) {
		int l,r,max;
		l = LeftChild(pos);
		r = RightChild(pos);
		if(this.heap[l] > this.heap[pos])
			max = l;
		if(this.heap[r] > this.heap[pos])
			max = r;
		else max = pos;
		if(max!=pos) {
			int temp = this.heap[pos];
			this.heap[pos] = this.heap[max];
			this.heap[max] = temp;
		}
		PercolateDown(max);
	}
	
	public int Delete() {
		if(this.count == 0 ) return -1;
		int popped = this.heap[0];
		this.heap[0] = this.heap[this.count-1];
		this.count--;
		PercolateDown(this.heap[0]);
		return popped;
	}
	
	public void Insert(int data) {
		if(this.count == this.capacity)
			ResizeHeap();
		this.count++;
		int i = this.count - 1;
		while(i>0 && data > this.heap[(i-1)/2]) {
			heap[i] = heap[(i-1)/2];
			i = (i-1)/2;
		}
		this.heap[i] = data;
		
	}

	private void ResizeHeap() {
		this.heap = Arrays.copyOf(heap, this.capacity*2);
	}
	
	public static void main(String[] arg) 
    { 
        System.out.println("The Max Heap is "); 
        MaxHeap maxHeap = new MaxHeap(5); 
        maxHeap.Insert(5); 
        maxHeap.Insert(3); 
        maxHeap.Insert(17); 
        maxHeap.Insert(10); 
        maxHeap.Insert(84);
        maxHeap.Insert(90);
        maxHeap.Insert(100);
        
        int[] result = maxHeap.heap;
        for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "->");
		}
  
    } 
}
