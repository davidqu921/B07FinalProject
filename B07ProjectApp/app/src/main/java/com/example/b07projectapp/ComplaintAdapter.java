package com.example.b07projectapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.MyViewHolder>{

    Context context;
    ArrayList<Complaint> comList;

    public ComplaintAdapter(Context context, ArrayList<Complaint> comList) {
        this.context = context;
        this.comList = comList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.complaint, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Complaint c = comList.get(position);
        holder.topic.setText(c.getTopic());
        holder.content.setText(c.getContent());
        holder.name.setText(c.getName());
        holder.time.setText(c.getTime());
    }

    @Override
    public int getItemCount() {
        return comList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView topic;
        TextView content;
        TextView name;
        TextView time;
        public MyViewHolder(@NonNull View complaintView){
            super(complaintView);
            topic = complaintView.findViewById(R.id.txtAbout);
            content = complaintView.findViewById(R.id.txtComplaintDescription);
            name = complaintView.findViewById(R.id.txtSubmitBy);
            time = complaintView.findViewById(R.id.txtComplainTime);
        }
    }
}
