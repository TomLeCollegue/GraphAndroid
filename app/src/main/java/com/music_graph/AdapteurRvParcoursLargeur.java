package com.music_graph;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdapteurRvParcoursLargeur extends RecyclerView.Adapter<AdapteurRvParcoursLargeur.MyViewHolder1>{

    public ArrayList<NodeAndDistance> nodesAndDistances;


    public AdapteurRvParcoursLargeur(ArrayList<NodeAndDistance> NodesAndDistance) {
        this.nodesAndDistances = NodesAndDistance;
    }



    @NonNull
    @Override
    public AdapteurRvParcoursLargeur.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.parcours_rv_adapter, parent, false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapteurRvParcoursLargeur.MyViewHolder1 holder, int position) {
        NodeAndDistance nodeAndDistance = nodesAndDistances.get(position);
        holder.display(nodeAndDistance);
    }

    @Override
    public int getItemCount() {
        return nodesAndDistances.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView NameNode;
        private final TextView DistanceNode;
        private final TextView ParentNode;
        private final TextView RelationNode;

        public MyViewHolder1(@NonNull final View itemView) {
            super(itemView);

            NameNode = itemView.findViewById(R.id.text_name_node);
            DistanceNode = itemView.findViewById(R.id.text_distance_node);
            ParentNode = itemView.findViewById(R.id.text_name_parent);
            RelationNode = itemView.findViewById(R.id.text_relation_node);


        }

        public void display(NodeAndDistance node) {

            NameNode.setText(node.getNode().getName());
            DistanceNode.setText("distance : " + node.getDistance());
            ParentNode.setText(node.getParent().getName());
            RelationNode.setText(node.getRelation());


        }
    }

}

