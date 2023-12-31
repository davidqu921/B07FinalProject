package com.example.b07projectapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminAnnouncementAdapter extends RecyclerView.Adapter<AdminAnnouncementAdapter.MyViewHolder>{

    private static Context context;
    private static ArrayList<Announcement> list;



    public AdminAnnouncementAdapter(Context context, ArrayList<Announcement> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.announcement_ad, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Announcement a = list.get(position);
        holder.title.setText(a.getTitle());
        holder.time.setText(a.getTime());
        holder.name.setText(a.getName());
        holder.content.setText(a.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView time;
        TextView name;

        TextView content;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            time = itemView.findViewById(R.id.txtTimePosted);
            name = itemView.findViewById(R.id.txtPostedBy);
            content = itemView.findViewById(R.id.txtContentAnnounce);


            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Announcement a = list.get(position);
                        String name = a.getName();
                        String title = a.getTitle();
                        String content = a.getContent();
                        String time = a.getTime();

                        Intent intent = new Intent(context, AnnouncementDetailAdmin.class);
                        intent.putExtra("title", title);
                        intent.putExtra("name", name);
                        intent.putExtra("time", time);
                        intent.putExtra("content", content);
                        context.startActivity(intent);
                    }
                }
            });
        }

    }

}
