package com.mipl.myapplication.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mipl.myapplication.R;
import com.mipl.myapplication.model.Data;



import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{



     List<Data> list;
    Context context;


    public MyListAdapter(Context context,List<Data> list) {
        this.list = list;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_list, parent, false);
        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

//        holder.imageView.setImageResource(list.get(position).getPoster());
        holder.tv_name.setText(list.get(position).getTitle());
//        holder.tv_date.setText(list.get(position).getYear());
        Glide.with(context).load(list.get(position).getPoster()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


//    public void setModels(List<Data> list){
////        list.clear();
////        list.size();
//        notifyDataSetChanged();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView imageView;
        AppCompatTextView tv_name,tv_date;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.moviePosterImageView);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_date=itemView.findViewById(R.id.tv_date);




        }
    }


}
