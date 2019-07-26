package com.hfad.samplewebapi;


import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.hfad.samplewebapi.Adapter.locationadapter;
import com.hfad.samplewebapi.SQLite.SQliteDatabase;
import com.hfad.samplewebapi.model.LOCATION.MF_location;
import com.hfad.samplewebapi.rest.InterfaceForce1;
import com.hfad.samplewebapi.rest.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_SWIPE;
import static android.support.v7.widget.helper.ItemTouchHelper.Callback.makeMovementFlags;
import static android.support.v7.widget.helper.ItemTouchHelper.LEFT;
import static android.support.v7.widget.helper.ItemTouchHelper.RIGHT;

public class LocationActivity extends AppCompatActivity {
    private String mMonth;
    private String mlatitude;
    private String mLongitude;
    private SQliteDatabase mdatabase;


    private static final String mcategory = null;
    private static final String mlocationSubtype = null;
    private static final String mmonth = null;

    private RecyclerView mrecyclerview;
    private RecyclerView.LayoutManager mlayoutmanager;
    private locationadapter mlocationadapter;
    private InterfaceForce1 mInterface;

    private List<MF_location> locations = new ArrayList<>();
    private List<MF_location> favlocations = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        mdatabase = new SQliteDatabase(getApplicationContext());

        Intent intent = getIntent();
        mMonth = intent.getStringExtra("MONTH");
        mlatitude = intent.getStringExtra("LATITUDE");
        mLongitude = intent.getStringExtra("LONGITUDE");

        mrecyclerview = findViewById(R.id.rvlocation);
        mlayoutmanager = new LinearLayoutManager(this);
        mrecyclerview.setLayoutManager(mlayoutmanager);


        mInterface = RetrofitClient.getRetrofitClient().create(InterfaceForce1.class);

        Call<List<MF_location>> call = mInterface.getLocationData("crimes-at-location?date=" + mMonth + "&lat=" + mlatitude + "&lng=" + mLongitude);

        call.enqueue(new Callback<List<MF_location>>() {
            @Override
            public void onResponse(Call<List<MF_location>> call, Response<List<MF_location>> response) {

                locations = response.body();
                mlocationadapter = new locationadapter(locations);
                mrecyclerview.setAdapter(mlocationadapter);
                itemTouchhelper.attachToRecyclerView(mrecyclerview);
                mlocationadapter.setOnItemClickListener(new locationadapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View itemView, int position) {
                        Intent intent = new Intent(getApplicationContext(), LocationDetailsActivity.class);
                        intent.putExtra("mcategory", locations.get(position).getCategory());
                        intent.putExtra("mlocationtype", locations.get(position).getLocationType());
                        intent.putExtra("mmonth", locations.get(position).getMonth());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<MF_location>> call, Throwable t) {

            }
        });
    }


    ItemTouchHelper itemTouchhelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

        boolean swipeBack=false;

        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            int x = viewHolder.getAdapterPosition();
            String MONTH=locations.get(x).getMonth();
            String LOCATIONTYPE=locations.get(x).getLocationType();
            String CATEGORY=locations.get(x).getCategory();
            Integer ID=locations.get(x).getId();
            mdatabase.InsertData(LOCATIONTYPE,CATEGORY,MONTH,ID);
            Toast.makeText(getApplicationContext()," Added to Fav",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            if(actionState==ACTION_STATE_SWIPE)
            {
                setTouchListener(c,recyclerView, viewHolder,dX,dY,actionState,isCurrentlyActive);
            }
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        private void setTouchListener(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, final float dX, float dY, int actionState, boolean isCurrentlyActive)
        {
            recyclerView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    swipeBack = event.getAction() == MotionEvent.ACTION_CANCEL || event.getAction() == MotionEvent.ACTION_UP;
                    return false;
                }
            });
        }});


}









