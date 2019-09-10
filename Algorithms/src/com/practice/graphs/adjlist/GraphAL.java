package com.practice.graphs.adjlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphAL {
	private List<Integer> vertices;
	private LinkedList<Integer>[] edges;
	private int vertexCount;
	
	public GraphAL(int count) {
		this.vertexCount=count;
		vertices = new ArrayList<Integer>();
		edges = new LinkedList[vertexCount];
		for(int i=0; i<vertexCount;i++) {
			vertices.add(i);
			edges[i] = new LinkedList<Integer>();
		}		
	}
	
	public void addEdge(GraphAL graph, int src, int dest) {
		int i = vertices.indexOf(src);
		int j = vertices.indexOf(dest);
		
		if( i !=-1 || j!=-1) {
			graph.edges[i].addFirst(j);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<edges.length; i++) {
			sb.append(i + " => " + edges[i].toString() + "\n");
		}
		
		return sb.toString();
	}
	
}
