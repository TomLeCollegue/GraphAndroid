package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class AddNode extends AppCompatActivity {

    private Button CreateNode;
    private EditText NameNode;
    private EditText TypeNode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_node);

        CreateNode = (Button) findViewById(R.id.button_ajout_noeud);
        NameNode = (EditText) findViewById(R.id.nom_noeud_text);
        TypeNode = (EditText) findViewById(R.id.type_noeud_text);

        CreateNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNode((NameNode.getText().toString()), (TypeNode.getText().toString()));

                Toast.makeText(AddNode.this,NameNode.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createNode(String name, String type){
        Node node = new Node(name, type);
        MainActivity.graph.createNode(node);
    }


}
