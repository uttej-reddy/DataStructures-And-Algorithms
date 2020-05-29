package com.practice.graphs.algorithms.practice2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph2 {

	public static void main(String[] args) {
		
		Graph2 g1 = new Graph2(5);
		g1.addEdge(g1, 0, 4);
		g1.addEdge(g1, 0, 1);
		g1.addEdge(g1, 1, 2);
		g1.addEdge(g1, 1, 3);
		g1.addEdge(g1, 1, 4);
		g1.addEdge(g1, 2, 3);
		g1.addEdge(g1, 3, 4);
		System.out.println("GRAPH 1 " + "\n"  +g1.toString());
		
		g1.dfsI(0);
		
		g1.bfsI(0);
		
		Graph2 g2 = new Graph2(6);
		g2.addEdge(g2, 2, 3);
		g2.addEdge(g2, 3, 1);
		g2.addEdge(g2, 4, 0);
		g2.addEdge(g2, 4, 1);
		g2.addEdge(g2, 5, 2);
		g2.addEdge(g2, 5, 0);	
		System.out.println( "\n" + "GRAPH 2 " + "\n"   +g2.toString());
		g2.topoSort();
	}
	
	public int vertexCount;
	public List<Integer> vertices;
	public LinkedList<Integer>[] edges;
	
	public Graph2(int count) {
		this.vertexCount = count;
		this.vertices =  new ArrayList<Integer>();
		edges = new LinkedList[vertexCount];
		for(int i=0; i< vertexCount; i++) {
			vertices.add(i);
			edges[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(Graph2 gr, int src, int dest) {
		int i = vertices.indexOf(src);
		int j = vertices.indexOf(dest);
		
		if(i != -1 || j != -1)
			edges[i].addFirst(j);
	}
	
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		for(int i=0 ; i<edges.length; i++) {
			sb.append(i + "-->" + edges[i].toString() + "\n");
		}
		sb.append("\n");
		return sb.toString();
	}

	public void dfsI(int pos) {
		Set<Integer> set = new HashSet<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		s.push(pos);
		
		System.out.print("DFS of GRPAH is --> ");
		
		while(!s.isEmpty()) {
			if(!set.contains(s.peek())) {
				set.add(s.peek());
				System.out.print(s.peek() + " ");
				
			}
			int top = s.pop();
			Iterator<Integer> itr = edges[top].iterator();
			while(itr.hasNext()) {
				int n =  itr.next();
				if(!set.contains(n))
					s.push(n);
			}
	
		}
		
		System.out.println();
		
	}
	
	public void bfsI(int pos) {
		Set<Integer> set = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		System.out.print("BFS of GRAPH is --> ");
		q.add(pos);
		
		while(!q.isEmpty()) {
			if(!set.contains(q.peek())) {
				set.add(q.peek());
				System.out.print(q.peek() + " ");
			}		
			int first = q.poll();
			Iterator<Integer> itr = edges[first].iterator();
			while(itr.hasNext()) {
				int n = itr.next();
				if(!set.contains(n))
					q.add(n);
			}
			
		}
		
		System.out.println();
	}
	
	public void topoSort() {
		System.out.println("TOPOLOGICAL SORT OF GRAPH --> ");
		Set<Integer> set = new HashSet<Integer>();
		Stack<Integer>  s = new Stack<Integer>();
		for(int i=0; i<vertexCount; i++) {
			if(!set.contains(i))
				topoSortUtil(i, set, s);
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		
		System.out.println();
		
	}
	
	public void topoSortUtil(int pos, Set<Integer> set, Stack<Integer> s) {
		set.add(pos);
		
		Iterator<Integer> itr = edges[pos].iterator();
		while(itr.hasNext()) {
			int n = itr.next();
			if(!set.contains(n))
			topoSortUtil(n, set, s);
		}
		s.push(pos);
	}
	
}
