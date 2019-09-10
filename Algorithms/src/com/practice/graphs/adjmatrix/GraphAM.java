package com.practice.graphs.adjmatrix;

public class GraphAM {

	private boolean adjMatrix[][];
	private int vertexCount;
	
	public GraphAM(int vertices) {
		this.vertexCount = vertices;
		adjMatrix = new boolean[vertices][vertices];
	}
	
	public void addEdge(int i, int j) {
		if(  i<vertexCount && j<vertexCount) {
			adjMatrix[i][j] = true;
			adjMatrix[j][i] = true;	
		}
	}
	
	public void deleteEdge(int i, int j) {
		if(  i<vertexCount && j<vertexCount) {	
			adjMatrix[i][j]=false;
			adjMatrix[j][i]=false;
		}	
	}
	
	public boolean isEdge(int i, int j) {
		if( i<vertexCount && j<vertexCount) 
			return adjMatrix[i][j];
		else return false;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<vertexCount; i++) {
			for(boolean j : adjMatrix[i]) {
				sb.append((j?1:0) + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
