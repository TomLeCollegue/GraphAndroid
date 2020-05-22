package com.music_graph;

import java.io.Serializable;

public class NodeAndDistance implements Serializable {

    Node node;
    int distance;
    Node parent;
    String Relation;


    public NodeAndDistance(Node node, int distance, Node parent, String Relation) {
        this.node = node;
        this.distance = distance;
        this.parent = parent;
        this.Relation = Relation;
    }

    public Node getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    public Node getParent() {
        return parent;
    }

    public String getRelation() {
        return Relation;
    }
}
