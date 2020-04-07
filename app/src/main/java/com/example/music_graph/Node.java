package com.example.music_graph;

import android.content.Context;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;


public class Node {
    private int id;
    private String name;
    private ArrayList<Edge> neighbours = new ArrayList<Edge>();

    public int getNodeId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void addNeighbours (Edge e) {
        if(neighbours.contains(e)) {
            System.out.println("error");
        }
        else{
            neighbours.add(e);
        }
    }

    public Node(int id, String name, ArrayList<Edge> neighbours) {
        this.id = id;
        this.name = name;
        this.neighbours = neighbours;
    }

    public Node(String name) {
        this.name = name;
        this.id = MainActivity.graph.getNumberOfNodes();
    }

    @Override
    public String toString() {
        return name;
    }
}






