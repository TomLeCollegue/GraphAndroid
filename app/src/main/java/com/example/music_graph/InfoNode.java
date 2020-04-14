package com.example.music_graph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoNode extends AppCompatActivity implements Adapter_Edges.OnItemClickListener {

    private RecyclerView rvInfo;
    private ArrayList<Edge> nodesVoisins = new ArrayList<Edge>();
    int positionNode;

    private TextView NameNode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_node);

        NameNode = (TextView) findViewById(R.id.name_node);
        Intent receivedIntent = getIntent();
        positionNode = receivedIntent.getIntExtra("noeud", 0);

        nodesVoisins = MainActivity.graph.getNodes().get(positionNode).getNeighbours();

        NameNode.setText(MainActivity.graph.getNodes().get(positionNode).toString());
        rvInfo = (RecyclerView) findViewById(R.id.rv);
        rvInfo.setLayoutManager(new LinearLayoutManager(InfoNode.this, LinearLayoutManager.VERTICAL, false));
        Adapter_Edges MyAdapter = new Adapter_Edges(nodesVoisins);
        rvInfo.setAdapter(MyAdapter);
        MyAdapter.setonItemClickListener(InfoNode.this);


    }

    public void onItemClick(int position) {

        int id = MainActivity.graph.getNodes().get(0).getNeighbours().get(position).getEnd().getNodeId();
        Intent intent = new Intent(InfoNode.this, InfoNode.class);
        intent.putExtra("noeud", id);
        finish();
        startActivity(intent);
    }
}
