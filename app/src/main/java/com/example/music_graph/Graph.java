package com.example.music_graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private int numberOfNodes = 0;


    public void createNode(Node node) {
        this.nodes.add(node);
        this.numberOfNodes++; // a node has been added
    }



    public int getNumberOfNodes() {
        return this.numberOfNodes;
    }



    public ArrayList<Node> getNodes() {
        return nodes;
    }


    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", numberOfNodes=" + numberOfNodes +
                '}';
    }
}
