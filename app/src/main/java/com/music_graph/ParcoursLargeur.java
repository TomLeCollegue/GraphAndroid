package com.music_graph;

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
    private int id_position = 0;
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


        //Spinner Adapter
        ArrayAdapter<Node> adapter_n1 = new ArrayAdapter<Node>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, MainActivity.graph.getNodes());
        adapter_n1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinnerNode.setAdapter(adapter_n1);

        spinnerNode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id_position = position;
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
                ListNode.clear();


                parcoursGraph(2,0);
                rv.setLayoutManager(new LinearLayoutManager(ParcoursLargeur.this, LinearLayoutManager.VERTICAL, false));
                MyAdapter = new AdapteurRvParcoursLargeur(ListNode);
                rv.setAdapter(MyAdapter);

            }
        });
    }



    private void parcoursGraph(int distance, int nbVoisinprecedant) {
        int compteurVoisins = 0;

        // Lors de l'initialisation
        if (ListNode.isEmpty()) {
            //on ajoute le noeud de base
            ListNode.add(new NodeAndDistance(MainActivity.graph.getNodes().get(id_position), 0, MainActivity.graph.getNodes().get(id_position), " "));

            //on ajoute tous ses voisins;
            for (int i = 0; i < MainActivity.graph.getNodes().get(id_position).getNeighbours().size(); i++) {
                //if ( !IsInList(MainActivity.graph.getNodes().get(id_position1).getNeighbours().get(i).getEnd()) ){
                ListNode.add(new NodeAndDistance(MainActivity.graph.getNodes().get(id_position).getNeighbours().get(i).getEnd(), 1, MainActivity.graph.getNodes().get(id_position), MainActivity.graph.getNodes().get(id_position).getNeighbours().get(i).getRelation()));
                compteurVoisins++;
                //}
            }
            nbVoisinprecedant = compteurVoisins;

        }
        compteurVoisins = 0;
        if (nbVoisinprecedant != 0) {
            int decalage = 0;
            for (int i = 0; i < nbVoisinprecedant; i++) {
                for (int j = 0; j < ListNode.get(ListNode.size() - 1 - (i+decalage)).getNode().getNeighbours().size(); j++) {
                    if (!IsInList(ListNode.get(ListNode.size() - 1 - (i+decalage)).getNode().getNeighbours().get(j).getEnd())) {
                        ListNode.add(new NodeAndDistance( ListNode.get(ListNode.size() -1 - (i+decalage)).getNode().getNeighbours().get(j).getEnd(), distance, ListNode.get(ListNode.size() - 1 - (i+decalage)).getNode(),  ListNode.get(ListNode.size() - 1 - (i+decalage)).getNode().getNeighbours().get(j).getRelation()));
                        compteurVoisins++;
                        decalage++;
                    }
                }
            }
        }
        if (compteurVoisins != 0){
            parcoursGraph(distance + 1 , compteurVoisins);
        }

    }





    private boolean IsInList(Node n){
        boolean Inlist = false;
        for (int i = 0; i < ListNode.size(); i++ ){
            if (ListNode.get(i).getNode().equals(n)){
                Inlist = true;
            }
        }
        return Inlist;
    }


}
