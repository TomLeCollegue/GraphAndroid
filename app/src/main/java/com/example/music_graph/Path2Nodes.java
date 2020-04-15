package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Path2Nodes extends AppCompatActivity {

    private Spinner spinnerFirstNode;
    private Spinner spinnerSecondNode;
    private Button bSearchPath;
    private int id_position1;
    private int id_position2;
    private ArrayList<NodeAndDistance> ListNode = new ArrayList<NodeAndDistance>();
    private ArrayList<NodeAndDistance> ListPath = new ArrayList<NodeAndDistance>();
    private AdapteurRvParcoursLargeur MyAdapter;

    private boolean FindNode2 = false;
    private RecyclerView rv;

    private TextView boolPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path2_nodes);

        spinnerFirstNode = (Spinner) findViewById(R.id.spinner_first_node);
        spinnerSecondNode = (Spinner) findViewById(R.id.spinner_second_node);
        bSearchPath = (Button) findViewById(R.id.button_search_node);
        rv = (RecyclerView) findViewById(R.id.rv_path);

        boolPath = (TextView) findViewById(R.id.boolean_path);

        //Spinner 1
        ArrayAdapter<Node> adapter_n1 = new ArrayAdapter<Node>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, MainActivity.graph.getNodes());
        adapter_n1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinnerFirstNode.setAdapter(adapter_n1);

        spinnerFirstNode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id_position1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Spinner 2
        ArrayAdapter<Node> adapter_n2 = new ArrayAdapter<Node>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, MainActivity.graph.getNodes());
        adapter_n2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinnerSecondNode.setAdapter(adapter_n1);

        spinnerSecondNode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id_position2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Listener Button Search
        bSearchPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListNode.clear();
                ListPath.clear();
                FindNode2 = false;

                parcoursGraph(2, 0 );

                ListPath.clear();
                if(FindNode2 == true) {
                    boolPath.setText("Chemin Trouvé !");
                    ListPath.add(ListNode.get(ListNode.size() - 1));      // on ajoute a ListPath le dernier noeud de la ListNode
                    GeneratePath(ListPath.get(0).getParent(), ListNode.size() - 2);
                    ListPath.add(ListNode.get(0));
                }
                else{
                    boolPath.setText("Pas de Chemin Trouvé");
                }

                Collections.reverse(ListPath);
                rv.setLayoutManager(new LinearLayoutManager(Path2Nodes.this, LinearLayoutManager.VERTICAL, false));
                MyAdapter = new AdapteurRvParcoursLargeur(ListPath);
                rv.setAdapter(MyAdapter);
            }
        });
    }

    private void parcoursGraph(int distance, int nbVoisinprecedant) {
        int compteurVoisins = 0;

        // Lors de l'initialisation
        if (ListNode.isEmpty()) {
            //on ajoute le noeud de base
            ListNode.add(new NodeAndDistance(MainActivity.graph.getNodes().get(id_position1), 0, MainActivity.graph.getNodes().get(id_position1), " "));

            //on ajoute tous ses voisins;
            for (int i = 0; i < MainActivity.graph.getNodes().get(id_position1).getNeighbours().size(); i++) {
                //if ( !IsInList(MainActivity.graph.getNodes().get(id_position1).getNeighbours().get(i).getEnd()) ){
                if (!FindNode2){
                    ListNode.add(new NodeAndDistance(MainActivity.graph.getNodes().get(id_position1).getNeighbours().get(i).getEnd(), 1, MainActivity.graph.getNodes().get(id_position1), MainActivity.graph.getNodes().get(id_position1).getNeighbours().get(i).getRelation()));
                    compteurVoisins++;
                    if (ListNode.get(ListNode.size() - 1).getNode().equals(MainActivity.graph.getNodes().get(id_position2))) {
                        FindNode2 = true;
                    }
                }
            }
            nbVoisinprecedant = compteurVoisins;
            boolPath.setText("nombre de voisin : "+ nbVoisinprecedant);
        }
        if (!FindNode2) {
            compteurVoisins = 0;
            if (nbVoisinprecedant != 0) {

                for (int i = 0; i < nbVoisinprecedant + 1 + 1; i++) {
                    for (int j = 0; j < ListNode.get(ListNode.size() - 1 - i).getNode().getNeighbours().size(); j++) {
                        if (!FindNode2) {
                            if (!IsInList(ListNode.get(ListNode.size() - 1 - i).getNode().getNeighbours().get(j).getEnd())) {
                                ListNode.add(new NodeAndDistance(ListNode.get(ListNode.size() - 1 - i).getNode().getNeighbours().get(j).getEnd(), distance, ListNode.get(ListNode.size() - 1 - i).getNode(), " "));
                                compteurVoisins++;
                                i++;
                                boolPath.setText("nombre de voisin : " + compteurVoisins);
                                if (ListNode.get(ListNode.size() - 1).getNode().equals(MainActivity.graph.getNodes().get(id_position2))) {
                                    FindNode2 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (compteurVoisins != 0 && !FindNode2){
            parcoursGraph(distance + 1 , compteurVoisins);
        }

    }

    // regarde si un noeud est deja tombé dans le parcours
    private boolean IsInList(Node n){
        boolean Inlist = false;
        for (int i = 0; i < ListNode.size(); i++ ){
            if (ListNode.get(i).getNode().equals(n)){
                Inlist = true;
            }
        }
        return Inlist;
    }

    //genere le chemin correct
    private void GeneratePath(Node parent, int index){
        if ((ListNode.get(index).node.equals(parent)) && (index >= 1)){

            ListPath.add(ListNode.get(index));

            GeneratePath(ListNode.get(index).getParent(), index -1);
        }
        else if (index >= 1) {
            GeneratePath(parent, index-1);
        }
    }
    
}
