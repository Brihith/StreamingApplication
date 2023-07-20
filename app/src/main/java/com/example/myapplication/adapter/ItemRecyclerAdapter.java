package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.MovieDetails;
import com.example.myapplication.R; // Make sure to import your project's R class
import com.example.myapplication.model.Categoryitem;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {

    Context context;
    List<Categoryitem> categoryitemList;

    public ItemRecyclerAdapter(Context context, List<Categoryitem> categoryitemList) {
        this.context = context;
        this.categoryitemList = categoryitemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_recycler_row_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Glide.with(context).load(categoryitemList.get(position).getImageUrl()).into(holder.itemImage);
        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MovieDetails.class);
                i.putExtra("movieID",categoryitemList.get(position).getId());
                i.putExtra("movieName",categoryitemList.get(position).getMovieName());
                i.putExtra("movieImageUrl",categoryitemList.get(position).getImageUrl());
                i.putExtra("movieFile",categoryitemList.get(position).getFileUrl());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryitemList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage=itemView.findViewById(R.id.item_image);
        }
    }
}