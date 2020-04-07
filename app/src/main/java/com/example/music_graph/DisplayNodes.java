package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class DisplayNodes extends AppCompatActivity {
    private RecyclerView rcNodes;
    private ArrayList<Node> nodes = new ArrayList<Node>();

    private Node testNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_nodes);

        nodes = MainActivity.graph.getNodes();

        testNode = nodes.get(0);




        rcNodes = (RecyclerView) findViewById(R.id.recycler_view_nodes);
        rcNodes.setLayoutManager(new LinearLayoutManager(DisplayNodes.this, LinearLayoutManager.VERTICAL, false));
        Adapter_Nodes MyAdapter = new Adapter_Nodes(nodes);
        rcNodes.setAdapter(MyAdapter);

    }
}
