package com.practice.graphs;

import com.practice.graphs.adjlist.GraphAL;
import com.practice.graphs.adjmatrix.GraphAM;

public class GraphTest {

	public static void main(String[] args) {
		
		GraphAM gam = new GraphAM(4);	
		gam.addEdge(0, 1);
		gam.addEdge(0, 2);
		gam.addEdge(1, 3);
		gam.addEdge(2, 3);
		
		System.out.println("Graph Representation is ");
		System.out.println(gam.toString());

        GraphAL gal2 = new GraphAL(4); 
		gal2.addEdge(gal2, 0, 1);
		gal2.addEdge(gal2, 0, 2);
		gal2.addEdge(gal2, 1, 3);
		gal2.addEdge(gal2, 2, 3);
		
		System.out.println("Adjacency Representation of GAL is ");
		System.out.println(gal2.toString());
		
		GraphAL gal = new GraphAL(5); 
        gal.addEdge(gal, 0, 1); 
        gal.addEdge(gal, 0, 4); 
        gal.addEdge(gal, 1, 2); 
        gal.addEdge(gal, 1, 3); 
        gal.addEdge(gal, 1, 4); 
        gal.addEdge(gal, 2, 3); 
        gal.addEdge(gal, 3, 4);

		System.out.println("Adjacency Representation GAL1 is ");
		System.out.println(gal.toString());
        

	}

}
