package com.hfad.samplewebapi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.hfad.samplewebapi.R;
import com.hfad.samplewebapi.model.FORCES.ForcesData;
import com.hfad.samplewebapi.model.LOCATION.MF_location;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class recycleradapter extends RecyclerView.Adapter<recycleradapter.ViewHolder1>  {

    private List<ForcesData> forcesdata ;


    private  OnItemClickListener mListener;


    public interface OnItemClickListener{
            void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener =listener;
    }

    public recycleradapter ( List<ForcesData> forcesdata)
    {

        this.forcesdata=forcesdata;

    }


    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_forces,viewGroup,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder, int i) {
                        viewHolder.name.setText(forcesdata.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return forcesdata.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder
    {   TextView name;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position =getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }


    public void updateList(List<ForcesData> newList)
    {
        forcesdata = new ArrayList<>();
        forcesdata.addAll(newList);
        notifyDataSetChanged();
    }

}
