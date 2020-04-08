package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class DisplayNodes extends AppCompatActivity {
    private RecyclerView rcNodes;
    private ArrayList<Node> nodes = new ArrayList<Node>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_nodes);

        nodes = MainActivity.graph.getNodes();

        rcNodes = (RecyclerView) findViewById(R.id.recycler_view_nodes);
        rcNodes.setLayoutManager(new LinearLayoutManager(DisplayNodes.this, LinearLayoutManager.VERTICAL, false));
        Adapter_Nodes MyAdapter = new Adapter_Nodes(nodes);
        rcNodes.setAdapter(MyAdapter);


        MyAdapter.setonItemClickListener(DisplayNodes.this);

    }

    public void onItemClick(int position) {
        Intent intent = new Intent(DisplayNodes.this, InfoNode.class);
        intent.putExtra("noeud", position);
        startActivity(intent);
        finish();
    }
}
