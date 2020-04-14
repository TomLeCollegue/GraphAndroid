package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bAddNode;
    private Button bAddRelation;
    private Button bParcoursLargeur;
    private Button bDisplayNodes;
    public static Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graph = new Graph();

        graph.fillTypesNode();
        graph.fillTypesRelations();


        bAddNode = (Button) findViewById(R.id.add_node);
        bAddRelation = (Button) findViewById(R.id.add_relation);
        bParcoursLargeur = (Button) findViewById(R.id.parcours_larg);
        bDisplayNodes = (Button) findViewById(R.id.display_all_nodes);

        bAddNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddNode.class));
            }
        });
        bAddRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddRelation.class));
            }
        });
        bParcoursLargeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ParcoursLargeur.class));
            }
        });

        bDisplayNodes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DisplayNodes.class));
            }
        });

    }

    public void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
