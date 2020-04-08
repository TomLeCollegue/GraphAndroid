package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class InfoNode extends AppCompatActivity {

    private RecyclerView rvInfo;
    private ArrayList<Edge> nodesVoisins = new ArrayList<Edge>();
    int positionNode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_node);

        Intent receivedIntent = getIntent();
        positionNode = receivedIntent.getIntExtra("noeud", 0);

        nodesVoisins = MainActivity.graph.getNodes().get(positionNode).getNeighbours();

        rvInfo = (RecyclerView) findViewById(R.id.rv);
        rvInfo.setLayoutManager(new LinearLayoutManager(InfoNode.this, LinearLayoutManager.VERTICAL, false));
        Adapter_Edges MyAdapter = new Adapter_Edges(nodesVoisins);
        rvInfo.setAdapter(MyAdapter);


    }
}
