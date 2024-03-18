package com.coding.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

	public boolean addVertex(String vertex) {
	    if(adjList.get(vertex) != null) return false;
	    
	    adjList.put(vertex, new ArrayList<String>());
	    return true;
	}

    public boolean addEdge(String vertex1, String vertex2) {
	    if(adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
	        adjList.get(vertex1).add(vertex2);
	        adjList.get(vertex2).add(vertex1);
	        return true;
	    }
	    return false;
	}

    public boolean removeEdge(String vertex1, String vertex2) {
	    if(adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
	        adjList.get(vertex1).remove(vertex2);
	        adjList.get(vertex2).remove(vertex1);
	        return true;
	    }
	    return false;
	}

    public boolean removeVertex(String vertex) {
	    if(adjList.get(vertex) != null) {
	        for(String neighbor: adjList.get(vertex)) {
	            adjList.get(neighbor).remove(vertex);
	        }
	        adjList.remove(vertex);
	        return true;
	    }
	    return false;
	}

}