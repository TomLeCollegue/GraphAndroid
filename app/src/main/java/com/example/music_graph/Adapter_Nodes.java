package com.example.music_graph;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class Adapter_Nodes extends RecyclerView.Adapter<Adapter_Nodes.MyViewHolder1>{

    public ArrayList<Node> nodes;
    private OnItemClickListener mListener;

    public Adapter_Nodes(ArrayList<Node> Nodes) {
        this.nodes = Nodes;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setonItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }


    @NonNull
    @Override
    public Adapter_Nodes.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.nodes_display_layout, parent, false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Nodes.MyViewHolder1 holder, int position) {
        Node node = nodes.get(position);
        holder.display(node);
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView NameNode;
        private final TextView TypeNode;


        public MyViewHolder1(@NonNull final View itemView) {
            super(itemView);

            NameNode = itemView.findViewById(R.id.Name_nodes);
            TypeNode = itemView.findViewById(R.id.type_node);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

        public void display(Node node) {

            NameNode.setText(node.getName());
            TypeNode.setText(node.getType());

        }
    }

}



