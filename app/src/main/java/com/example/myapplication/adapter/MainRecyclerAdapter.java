package com.example.myapplication.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.AllCategory;
import com.example.myapplication.model.Categoryitem;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    Context context;
    List<AllCategory> allCategoryList;

    public MainRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.categoryName.setText(allCategoryList.get(position).getCategoryTitle());
        setItemRecycler(holder.itemRecycler,allCategoryList.get(position).getCategoryitemList());

    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        RecyclerView itemRecycler;


        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.Item_category);
            itemRecycler=itemView.findViewById(R.id.item_recycler);

        }
    }

    private void setItemRecycler(RecyclerView recyclerView, List<Categoryitem> categoryitemList){
            ItemRecyclerAdapter itemRecyclerAdapter=new ItemRecyclerAdapter(context,categoryitemList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context,recyclerView.HORIZONTAL,false));
            recyclerView.setAdapter(itemRecyclerAdapter);
        }


}



