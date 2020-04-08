package com.example.music_graph;

import android.content.Context;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;


public class Node {
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






