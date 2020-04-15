package com.example.music_graph;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Graph implements Serializable {
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private int numberOfNodes = 0;

    private ArrayList<String> typesNode = new ArrayList<String>();
    private ArrayList<String> typesRelations = new ArrayList<String>();

    public void fillTypesNode(){
        this.typesNode.clear();
        this.typesNode.add("Personne");
        this.typesNode.add("Musique");
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
        this.typesRelations.add("Aime ");
        this.typesRelations.add("Appartient à ");
        this.typesRelations.add("a composé ");
        this.typesRelations.add("a joué avec ");
        this.typesRelations.add("fait parti ");
        this.typesRelations.add("a fait un concert ");
        this.typesRelations.add("Lieu ");

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
