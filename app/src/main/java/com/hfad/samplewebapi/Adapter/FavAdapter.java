package com.hfad.samplewebapi.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hfad.samplewebapi.R;
import com.hfad.samplewebapi.SQLite.SQliteDatabase;
import com.hfad.samplewebapi.model.FavData;
import com.hfad.samplewebapi.model.LOCATION.MF_location;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewholder> {

    private String category=null;
    private String locationtype=null;
    private String month=null;
    private List<FavData> mFavData;
    Context context;

    public FavAdapter(List<FavData> mFavData,Context context) {
        this.mFavData = mFavData;
        this.context=context;
    }

    @NonNull
    @Override
    public FavViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fav, viewGroup, false);
        return new FavViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewholder viewHolder, int i) {
        viewHolder.elocationtype.setText(mFavData.get(i).getLocationtype());
        viewHolder.emonth.setText(mFavData.get(i).getMonth());
        viewHolder.ecategory.setText(mFavData.get(i).getCategory());
        viewHolder.eid.setText(String.valueOf(mFavData.get(i).getFavid()));

    }

    @Override
    public int getItemCount() {
        return mFavData.size();
    }

    public class FavViewholder extends RecyclerView.ViewHolder {

        TextView emonth;
        TextView ecategory;
        TextView elocationtype;
        TextView eid;
        LinearLayout mLinearLayout;

        public FavViewholder(@NonNull View itemView) {
            super(itemView);
            mLinearLayout=itemView.findViewById(R.id.itemlayout);
            emonth = itemView.findViewById(R.id.favMonth);
            ecategory = itemView.findViewById(R.id.favCategory);
            elocationtype = itemView.findViewById(R.id.favLocationType);
            eid=itemView.findViewById(R.id.favid);
            mLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }


    }


}
