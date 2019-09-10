package com.practice.graphs.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	private int vertexCount;
	private List<Integer> vertices;
	private LinkedList<Integer>[] edges;
	
	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		vertices = new ArrayList<Integer>();
		edges = new LinkedList[vertexCount];
		for(int i=0;i<vertexCount;i++) {
			vertices.add(i);
			edges[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(Graph graph, int src, int dest) {
		int i = vertices.indexOf(src);
		int j = vertices.indexOf(dest);
		
		if(i!=-1 || j!=-1) {
			graph.edges[i].addFirst(j);
		}		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("Graph is :");
		for(int i=0;i<edges.length;i++) {
			sb.append(i + "-->" + edges[i].toString() + "\n");
		}
		return sb.toString();
	}

	public void dfsR() {
		
		boolean[] visited = new boolean[vertexCount];
		System.out.println("Recursive DFS of graph ");
		for(int i=0; i<vertexCount; i++) {
			if(!visited[i])
				dfsUtilR(i,visited);
		}
		System.out.println();
	}
	
	public void dfsUtilR(int v, boolean[] visited) {
		
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> i = edges[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n])
				dfsUtilR(n,visited);
		}
		
	}
	
	public void dfsI(int v) {		
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println("Iterative DFS of graph");
		dfsUtilI(v,set);
		System.out.println();
		
	}
	
	private void dfsUtilI(int v, HashSet<Integer> set) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(v);
		
		while(!s.isEmpty()) {
			if (!set.contains(s.peek())) {

				System.out.print(s.peek() + " ");
				set.add(s.peek());
			}
			int top = s.pop();
			
			Iterator<Integer> i = edges[top].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!set.contains(n)) {
					s.push(n);
				}

			}
		}	
		
	}
	
	public void bfsI(int v) {
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println("BFS Iterative is :");
		bfsUtilI(v,set);
		System.out.println();
	}

	private void bfsUtilI(int v, HashSet<Integer> set) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		
		while(!queue.isEmpty()) {
		if(!set.contains(queue.peek())) {
			set.add(queue.peek());
			System.out.print(queue.peek() + " ");
		}
		
		int num = queue.poll();
		
		Iterator<Integer> itr = edges[num].listIterator();
		while(itr.hasNext()) {
			int n = itr.next();
			queue.add(n);
		}
		
		}
	}

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<vertexCount; i++) {
			if(!set.contains(i))
			topologicalSortUtil(i,set,stack);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	
	private void topologicalSortUtil(int i, HashSet<Integer> set, Stack<Integer> stack) {
		
		set.add(i);
		
		Iterator<Integer> itr = edges[i].listIterator();
		while(itr.hasNext()) {
			int n = itr.next();
			if(!set.contains(n))
				topologicalSortUtil(n, set, stack);
		}
		
		stack.add(i);
		
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(g, 0, 1);
		g.addEdge(g, 0, 4);
		g.addEdge(g, 1, 4);
		g.addEdge(g, 1, 3);
		g.addEdge(g, 1, 2);
		g.addEdge(g, 2, 3);
		g.addEdge(g, 3, 4);
		
		System.out.println(g.toString());
		
		//dfs recursive
		g.dfsR();
		
		//dfs iterative
		g.dfsI(0);
		g.dfsI(1);
		
		//bfs iterative
		g.bfsI(0);
		
		Graph topoG = new Graph(6);
		topoG.addEdge(topoG, 2, 3);
		topoG.addEdge(topoG, 3, 1);
		topoG.addEdge(topoG, 4, 0);
		topoG.addEdge(topoG, 4, 1);
		topoG.addEdge(topoG, 5, 0);
		topoG.addEdge(topoG, 5, 2);
		
		System.out.println("\n" + "Graph before topo sort \n" + topoG.toString());
		
		topoG.topologicalSort();
	}
	
}
