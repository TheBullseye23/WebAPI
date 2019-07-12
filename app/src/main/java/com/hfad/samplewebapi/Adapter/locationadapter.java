package com.hfad.samplewebapi.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hfad.samplewebapi.R;
import com.hfad.samplewebapi.model.LOCATION.MF_location;

import java.util.List;

public class locationadapter extends RecyclerView.Adapter<locationadapter.locationViewHolder> {

    private List<MF_location> locations;

    public locationadapter(List <MF_location> locations)
    {
        this.locations = locations;
    }


    @NonNull
    @Override
    public locationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_location,viewGroup,false);
        return new locationViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull locationViewHolder viewHolder, int i) {

        viewHolder.category.setText(locations.get(viewHolder.getAdapterPosition()).getCategory());
        viewHolder.locationtype.setText(locations.get(viewHolder.getAdapterPosition()).getLocationType());
        Log.d(" Category name "," " );
        Log.d(" Item no ", String.valueOf(i));

    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public class locationViewHolder extends RecyclerView.ViewHolder{

        TextView category;
        TextView locationtype;

       public locationViewHolder(View itemview)
        {
            super(itemview);
            category = itemview.findViewById(R.id.TVcategory);
            locationtype = itemview.findViewById(R.id.TVlocationtype);

        }

    }
}
