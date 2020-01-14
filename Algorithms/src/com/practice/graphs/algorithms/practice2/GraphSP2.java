package com.practice.graphs.algorithms.practice2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSP2 {

	public static void main(String[] args) {
		GraphSP2 spg = new GraphSP2(7);
		spg.addEdge(spg, 0, 1);
		spg.addEdge(spg, 0, 3);
		spg.addEdge(spg, 1, 2);
		spg.addEdge(spg, 3, 5);
		spg.addEdge(spg, 3, 4);
		spg.addEdge(spg, 4, 5);
		spg.addEdge(spg, 4, 6);
		spg.addEdge(spg, 5, 6);
		System.out.println(spg.toString());
		
		List<Integer> result = spg.shortestPathUnWeightedGraph(spg, 0, 6);
		System.out.println("SHORTEST PATH is -->" +result.toString());
		
		int i = 1, j = 10; 
		do 
		{
		    if(i++ > --j) /* Line 4 */
		    {
		        continue; 
		    } 
		} while (i < 5); 
		System.out.println("i = " + i + "and j = " + j); /* Line 9 */
	}
	
	int vertexCount;
	List<Integer> vertices;
	LinkedList<Integer>[] edges;
	
	public GraphSP2(int count) {
		this.vertexCount = count;
		this.vertices = new ArrayList<Integer>();
		this.edges = new LinkedList[count];
		for(int i=0; i<edges.length; i++) {
			vertices.add(i);
			edges[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(GraphSP2 g, int src, int dest) {
		int i = vertices.indexOf(src);
		int j = vertices.indexOf(dest);
		
		if( i != -1 && j != -1)
			edges[i].addFirst(j);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GraphSP2 is --> " + "\n");
		for(int i=0; i<edges.length; i++) {
			sb.append(i + "-->" + edges[i].toString() + "\n");
		}
		return sb.toString();
	}
	
	public List<Integer> shortestPathUnWeightedGraph(GraphSP2 g, int src, int dest) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] distance = new int[vertexCount];
		for(int i=0; i<vertexCount; i++) {
			distance[i] = -1;
		}
		distance[src] = 0;
		
		int[] path = new int[vertexCount];
		q.add(src);	
		while(!q.isEmpty()) {
			int pop = q.poll();
			Iterator<Integer> itr = edges[pop].iterator();
			while(itr.hasNext()) {
				int n = itr.next();
				if(distance[n] == -1) {
					distance[n] = distance[pop] + 1;
					
					path[n] = pop;
					q.add(n);
				}
			}
		}
		
		int i = dest;
		List<Integer> res = new ArrayList<Integer>();
		while(i != src) {
			res.add(0,i);
			i = path[i];
		}
		res.add(0, i);
		
		return res;
		
	}
}
