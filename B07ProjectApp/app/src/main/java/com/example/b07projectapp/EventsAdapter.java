package com.example.b07projectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder>  {

    Context context;

    ArrayList<Event> list;

    RecyclerViewClickListener listener;

    public void setFilteredList(ArrayList<Event> filteredList){
        this.list = filteredList;
        notifyDataSetChanged();
    }

    public EventsAdapter(Context context, ArrayList<Event> list, RecyclerViewClickListener listener) {

        this.context = context;
        this.list = list;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Event event = list.get(position);
        holder.name.setText(event.title);
        holder.location.setText(event.location);
        holder.date.setText(event.date);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView name, location, date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            location =itemView.findViewById(R.id.location);
            date = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());
        }
    }
}
