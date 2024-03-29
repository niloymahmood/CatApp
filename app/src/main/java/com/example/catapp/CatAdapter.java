package com.example.catapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class CatAdapter extends  RecyclerView.Adapter<CatAdapter.CatViewHolder>{

    private List<Cat> catstoadapt;


    public void setData(List <Cat> catstoadapt){
        this.catstoadapt = catstoadapt;

    }

    @NonNull
    @Override
    public CatAdapter.CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_menu, parent, false  );

        CatViewHolder catViewHolder = new CatViewHolder(view);
        return catViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.CatViewHolder holder, int position) {
    final Cat catAtPosition = catstoadapt.get(position);


    holder.nameTextView.setText(catAtPosition.getName());
    holder.view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context context = v.getContext();

            Intent intent = new Intent (context, CatDetailActivity.class);
            intent.putExtra("catId", catAtPosition.getId());
                    context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return catstoadapt.size();
    }


    public void filterList(ArrayList<Cat> filteredList){
        catstoadapt = filteredList;
        notifyDataSetChanged();

    }









    public static class CatViewHolder extends  RecyclerView.ViewHolder{
        public View view;
        public TextView nameTextView;

        public CatViewHolder(@NonNull View v) {
            super(v);
            view = v;
            nameTextView = v.findViewById(R.id.breedname);
        }
    }




}
