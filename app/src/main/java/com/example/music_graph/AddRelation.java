package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddRelation extends AppCompatActivity {

    private Button bAddRelation;
    private Spinner spinnern1;
    private Spinner spinnern2;
    private EditText textRelation;
    private int idN1;
    private int idN2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_relation);

        bAddRelation = (Button) findViewById(R.id.button_add_relation);
        spinnern1 = (Spinner) findViewById(R.id.spinner_n1);
        spinnern2 = (Spinner) findViewById(R.id.spinner_n2);
        textRelation = (EditText) findViewById(R.id.edit_text_relation);


        //-------Adapter n1-------------
        ArrayAdapter<Node> adapter_n1 =
                new ArrayAdapter<Node>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, MainActivity.graph.getNodes());
        adapter_n1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinnern1.setAdapter(adapter_n1);

        //-------Adapter n2-------------
        ArrayAdapter<Node> adapter_n2 =
                new ArrayAdapter<Node>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, MainActivity.graph.getNodes());
        adapter_n2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinnern2.setAdapter(adapter_n2);

        //--------Listener spinner----------
        spinnern1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               idN1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnern2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idN2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });








        bAddRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEdge(idN1 ,idN2, textRelation.getText().toString());
                Toast.makeText(AddRelation.this,textRelation.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void createEdge(int n1, int n2, String relation){
        Edge edge = new Edge(MainActivity.graph.getNodes().get(n1),MainActivity.graph.getNodes().get(n2),relation);
        MainActivity.graph.getNodes().get(n1).AddEdge(edge);


    }
}
