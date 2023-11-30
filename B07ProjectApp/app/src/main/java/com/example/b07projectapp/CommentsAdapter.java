package com.example.b07projectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder>  {
    Context context;
    ArrayList<Comment> list;


    public CommentsAdapter(Context context, ArrayList<Comment> list) {

        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.comment,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Comment c = list.get(position);
        holder.participantName.setText(c.getUser());
        holder.eventComment.setText(c.getComment());
        holder.participantRating.setRating(c.getRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView participantName, eventComment;

        RatingBar participantRating;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            participantName = itemView.findViewById(R.id.participantName);
            eventComment =itemView.findViewById(R.id.EventComment);
            participantRating = itemView.findViewById(R.id.ratingBar2);
        }

    }
}
