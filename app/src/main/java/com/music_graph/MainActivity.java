package com.music_graph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button bAddNode;
    private Button bAddRelation;
    private Button bParcoursLargeur;
    private Button bDisplayNodes;
    private Button bSearchNode;
    private Button bSaveGraph;
    private Button bLoadGraph;

    public static Graph graph;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (graph == null) {
            graph = new Graph();
        }


        graph.fillTypesNode();
        graph.fillTypesRelations();


        bAddNode = (Button) findViewById(R.id.add_node);
        bAddRelation = (Button) findViewById(R.id.add_relation);
        bParcoursLargeur = (Button) findViewById(R.id.parcours_larg);
        bDisplayNodes = (Button) findViewById(R.id.display_all_nodes);
        bSearchNode = (Button) findViewById(R.id.button_path_2_nodes);
        bLoadGraph = (Button) findViewById(R.id.load_graph);
        bSaveGraph = (Button) findViewById(R.id.save_graph);


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

        bSearchNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Path2Nodes.class));
            }
        });

        bSaveGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput("graph", Context.MODE_PRIVATE);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    // write object to file
                    oos.writeObject(graph);
                    // closing resources
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bLoadGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream is = openFileInput("graph");
                    ObjectInputStream ois = new ObjectInputStream(is);
                    graph = (Graph) ois.readObject();
                    ois.close();
                    is.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public static String getAppDir(Context c){
        return c.getApplicationInfo().dataDir;
    }
}
