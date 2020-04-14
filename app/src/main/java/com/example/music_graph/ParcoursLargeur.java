package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class ParcoursLargeur extends AppCompatActivity {

    private Spinner spinnerNode;
    private Button bParcours;
    private Button bRefresh;
    private int id = 0;
    private RecyclerView rv;
    private AdapteurRvParcoursLargeur MyAdapter;


    private ArrayList<NodeAndDistance> ListNode = new ArrayList<NodeAndDistance>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcours_largeur);

        spinnerNode = (Spinner) findViewById(R.id.spinner_node);
        bParcours = (Button) findViewById(R.id.button_parcours);
        rv = (RecyclerView) findViewById(R.id.rv_parcours);
        bRefresh = (Button) findViewById(R.id.button_refresh);


        ListNode.add(new NodeAndDistance(MainActivity.graph.getNodes().get(0), 0, MainActivity.graph.getNodes().get(0), " "));


        //Spinner Adapter
        ArrayAdapter<Node> adapter_n1 = new ArrayAdapter<Node>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, MainActivity.graph.getNodes());
        adapter_n1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinnerNode.setAdapter(adapter_n1);

        spinnerNode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Adapter RV
        rv.setLayoutManager(new LinearLayoutManager(ParcoursLargeur.this, LinearLayoutManager.VERTICAL, false));
        MyAdapter = new AdapteurRvParcoursLargeur(ListNode);
        rv.setAdapter(MyAdapter);


        //Listener Button
        bParcours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParcoursLargeurFonction();


            }
        });

        bRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rv.setLayoutManager(new LinearLayoutManager(ParcoursLargeur.this, LinearLayoutManager.VERTICAL, false));
                MyAdapter = new AdapteurRvParcoursLargeur(ListNode);
                rv.setAdapter(MyAdapter);
            }
        });
    }



    private void ParcoursLargeurFonction(){

        parcoursNoeuds(MainActivity.graph.getNodes().get(id), 1);
    }


    private void parcoursNoeuds(Node n, int distance){
        int nbVoisins = n.getNeighbours().size();
        for(int i = 0; i < nbVoisins; i++){
            if (nbVoisins > 0){
                
                ListNode.add(new NodeAndDistance(n.getNeighbours().get(i).getEnd(), distance, n, n.getNeighbours().get(i).getRelation()));
                parcoursNoeuds(n.getNeighbours().get(i).getEnd(), distance+1);
            }
        }
    }
}
