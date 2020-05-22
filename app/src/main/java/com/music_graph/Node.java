package com.music_graph;

import java.io.Serializable;
import java.util.ArrayList;


public class Node implements Serializable {
    private int id;
    private String name;
    private String type;
    private ArrayList<Edge> neighbours = new ArrayList<Edge>();

    public int getNodeId() {
        return this.id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Node(String name, String type) {
        this.name = name;
        this.type = type;
        this.id = MainActivity.graph.getNumberOfNodes();
    }

    public void AddEdge(Edge e){
        neighbours.add(e);
    }

    public ArrayList<Edge> getNeighbours() {
        return neighbours;
    }

    @Override
    public String toString() {
        return name;
    }
}






