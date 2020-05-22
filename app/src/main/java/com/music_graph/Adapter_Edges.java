package com.music_graph;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Edges extends RecyclerView.Adapter<Adapter_Edges.MyViewHolder1>{

    public ArrayList<Edge> edges;
    private OnItemClickListener mListener;

    public Adapter_Edges(ArrayList<Edge> Edges) {
        this.edges = Edges;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setonItemClickListener(Adapter_Edges.OnItemClickListener listener)
    {
        mListener = listener;
    }

    @NonNull
    @Override
    public Adapter_Edges.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.edges_display_layout, parent, false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Edges.MyViewHolder1 holder, int position) {
        Edge edge = edges.get(position);
        holder.display(edge);
    }

    @Override
    public int getItemCount() {
        return edges.size();
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

        public void display(Edge edge) {

            NameNode.setText(edge.getEnd().getName());
            TypeNode.setText(edge.getRelation());

        }
    }

}



