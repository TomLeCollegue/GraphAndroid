package com.music_graph;

import java.io.Serializable;
import java.util.ArrayList;

public class Graph implements Serializable {
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private int numberOfNodes = 0;

    private ArrayList<String> typesNode = new ArrayList<String>();
    private ArrayList<String> typesRelations = new ArrayList<String>();

    public void fillTypesNode(){
        this.typesNode.clear();
        this.typesNode.add("Personne");
        this.typesNode.add("Morceau");
        this.typesNode.add("Album");
        this.typesNode.add("Genre");
        this.typesNode.add("Personne");
        this.typesNode.add("Groupe");
        this.typesNode.add("Ville");
        this.typesNode.add("Concert");
        this.typesNode.add("Année");
        this.typesNode.add("Lieu");


    }

    public void fillTypesRelations(){
        this.typesRelations.clear();
        this.typesRelations.add("aime ");
        this.typesRelations.add("fait parti de ");
        this.typesRelations.add("a composé ");
        this.typesRelations.add("a joué avec ");
        this.typesRelations.add("contient ");
        this.typesRelations.add("a fait un concert ");
        this.typesRelations.add("s'est deroulé à ");
        this.typesRelations.add("est connu par");
        this.typesRelations.add("fait parti de la bibliothèque de ");
        this.typesRelations.add("est ami avec");
    }

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


    public ArrayList<String> getTypesNode() {
        return typesNode;
    }

    public ArrayList<String> getTypesRelations() {
        return typesRelations;
    }


    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", numberOfNodes=" + numberOfNodes +
                '}';
    }
}
