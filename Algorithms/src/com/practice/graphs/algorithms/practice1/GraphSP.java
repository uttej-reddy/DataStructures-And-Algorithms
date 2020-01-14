package com.practice.graphs.algorithms.practice1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/*
 * Similar to https://ide.geeksforgeeks.org/T1MrYVDvkc
 * */
public class GraphSP {

	public static void main(String[] args) {
		GraphSP spg = new GraphSP(7);
		spg.addEdge(spg, 0, 1);
		spg.addEdge(spg, 0, 3);
		spg.addEdge(spg, 1, 2);
		spg.addEdge(spg, 3, 5);
		spg.addEdge(spg, 3, 4);
		spg.addEdge(spg, 4, 5);
		spg.addEdge(spg, 4, 6);
		spg.addEdge(spg, 5, 6);
		
		System.out.println("SHORTEST PATH GRAPH IS :");
		System.out.println(spg.toString());
		
		spg.shortestDistTable(spg, 0, 6, 7);
		
		
	}
	
	private int vertexCount;
	private List<Integer> vertices;
	private LinkedList<Integer>[] edges;
	
	private GraphSP(int vertexCount) {
		this.vertexCount = vertexCount;
		vertices = new ArrayList<Integer>();
		edges = new LinkedList[vertexCount];
		for(int i=0;i<vertexCount;i++) {
			vertices.add(i);
			edges[i] = new LinkedList<Integer>();
		}
	}
	
	private void addEdge(GraphSP graph, int src, int dest) {
		 int i = vertices.indexOf(src);
		 int j = vertices.indexOf(dest);
		 
		 edges[i].addLast(j);
	}
	 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<edges.length;i++) {
			sb.append("Vertex : " + i + "==>" + edges[i].toString() + "\n");
		}
		return sb.toString();
	}
	
	public void shortestDistTable( GraphSP graph, int src, int dest, int vertexCount) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		int[] distance = new int[vertexCount];
		for(int i=0; i<vertexCount; i++)
			distance[i] = -1;
		distance[src] = 0;
		int[] previous = new int[vertexCount];
		
		while(!queue.isEmpty()) {
			int first = queue.poll();
			
			Iterator<Integer> itr = edges[first].listIterator();
			while(itr.hasNext()) {
				int n = itr.next();
				if(distance[n] == -1){
					distance[n] = distance[first] + 1;
					previous[n] = first;
					queue.add(n);
				}
			}
		}
		
		int i = dest;
		while(i!=src) {
			System.out.print(i + " ");
			i = previous[i];
		}
		System.out.println(i);
		
	}

}
