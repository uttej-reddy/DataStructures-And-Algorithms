package com.practice.graphs.algorithms.practice2;

import java.util.ArrayList;
import java.util.LinkedList;

public class LeetCoe997 {
	
	public static void main(String[] args) {
		LeetCoe997 judge = new LeetCoe997();
		int[][] arr = {{1,2},{2,3}};
		int n = judge.findJudge(3, arr);
		System.out.println("JUDGE : " +n);
	}
	
	 public int findJudge(int N, int[][] trust) {
	        Graph g = new Graph(N);
	        for(int i=0; i< trust.length; i++){
	            g.addEdge(trust[i][0]-1, trust[i][1]-1);
	        }
	       
	        for(int j=0; j<g.edges.length; j++){
	            if(g.edges[j].size() == 0) {
	            	boolean isJudge = true;
	            	int judgeCand = j;
	            	for(int k=0; k<g.edges.length; k++) {
	            		LinkedList<Integer> edges = g.edges[k];
	            		if(!edges.contains(judgeCand)) {
	            			isJudge = false;
	            			break;
	            		}
	            	}
	            	
	            	if(isJudge)
	            		return j;
	            }
	        }
	        
	        return  -1;
	    }

}

class Graph{
    int vertexCount;
    LinkedList<Integer>[] edges;
    ArrayList<Integer> vertices;
    
    
    Graph(int n){
        this.vertexCount =  n;
        this.vertices = new ArrayList<>();
        this.edges  = new LinkedList[vertexCount];
        for(int i=0; i<vertexCount; i++){
            vertices.add(i);
            edges[i] =  new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int src, int dest){
        int i =  vertices.indexOf(src);
        int j  =  vertices.indexOf(dest);
        
        if(i != -1 &&   j  != -1)
            edges[i].addFirst(j);
    }
    
}
