package com.example.b07projectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptParticipant  extends RecyclerView.Adapter<adaptParticipant.MyViewHolder> {
    private ArrayList<ParticipantName> nameList;
    public adaptParticipant(ArrayList<ParticipantName> nameList){
        this.nameList = nameList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView participant;

        public MyViewHolder(final View view){
            super(view);
            participant = view.findViewById(R.id.textView22);
        }
    }

    @NonNull
    @Override
    public adaptParticipant.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemz = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_admin_view_participants, parent, false);
        return new MyViewHolder(itemz);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptParticipant.MyViewHolder holder, int position) {
        String takePart = nameList.get(position).getName();
        holder.participant.setText((takePart));

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
