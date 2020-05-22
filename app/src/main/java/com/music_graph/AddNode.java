package com.music_graph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNode extends AppCompatActivity {

    private Button CreateNode;
    private EditText NameNode;
    private Spinner TypeNode;

    private int position_type;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_node);

        CreateNode = (Button) findViewById(R.id.button_ajout_noeud);
        NameNode = (EditText) findViewById(R.id.nom_noeud_text);
        TypeNode = (Spinner) findViewById(R.id.spinner_type);

        ArrayAdapter<String> adapter_type = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, MainActivity.graph.getTypesNode());
        TypeNode.setAdapter(adapter_type);

        TypeNode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position_type = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        CreateNode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNode((NameNode.getText().toString()), (MainActivity.graph.getTypesNode().get(position_type)));

                Toast.makeText(AddNode.this,NameNode.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createNode(String name, String type){
        Node node = new Node(name, type);
        MainActivity.graph.createNode(node);
    }


}
