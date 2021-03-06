package com.music_graph;

import java.io.Serializable;

public class Edge implements Serializable {
    private Node start;
    private Node end;
    private String relation;
    private int id;

    public int getId() {
        return this.id;
    }

    public Node getStart()
    {
        return this.start;
    }

    public int getIdOfStartNode() {
        return this.start.getNodeId();
    }

    public Node getEnd() {
        return this.end;
    }
    public int getIdOfEndNode() {
        return this.end.getNodeId();
    }

    public String getRelation() {
        return this.relation;
    }

    public Edge(Node start, Node end, String relation) {
        this.start = start;
        this.end = end;
        this.relation = relation;
    }

}

