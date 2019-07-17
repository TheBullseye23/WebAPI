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

public class locationadapter extends RecyclerView.Adapter<locationadapter.locationviewholder> {

    private List<MF_location> locations;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        public void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public locationadapter(List<MF_location> locations) {
        this.locations = locations;
    }

    @NonNull
    @Override
    public locationviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_location, viewGroup, false);
        return new locationviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull locationviewholder viewHolder, int i) {
        viewHolder.category.setText(locations.get(i).getCategory());
        viewHolder.locationtype.setText(locations.get(i).getLocationType());
        Log.d(" item no ", String.valueOf(i));
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public class locationviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView category;
        TextView locationtype;

        public locationviewholder(View itemview) {
            super(itemview);
            category = itemview.findViewById(R.id.tvCategory);
            locationtype = itemview.findViewById(R.id.tvlocationtype);
            itemview.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(itemView, position);
                }

            }
        }


    }
}
