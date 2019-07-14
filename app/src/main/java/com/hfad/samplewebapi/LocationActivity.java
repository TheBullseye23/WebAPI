package com.hfad.samplewebapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hfad.samplewebapi.Adapter.locationadapter;
import com.hfad.samplewebapi.model.LOCATION.MF_location;
import com.hfad.samplewebapi.rest.InterfaceForce1;
import com.hfad.samplewebapi.rest.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LocationActivity extends AppCompatActivity  {
    private String mMonth;
    private String mlatitude;
    private String mLongitude;

    private static final String mcategory=null;
    private static final String mlocationSubtype=null;
    private static final String mmonth=null;

    private RecyclerView mrecyclerview;
    private RecyclerView.LayoutManager mlayoutmanager;
    private locationadapter mlocationadapter;
    private InterfaceForce1 mInterface;

    private List<MF_location> locations = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Intent intent =getIntent();
        mMonth =intent.getStringExtra("MONTH");
        mlatitude = intent.getStringExtra("LATITUDE");
        mLongitude = intent.getStringExtra("LONGITUDE");

        mrecyclerview = findViewById(R.id.rvlocation);
        mlayoutmanager = new LinearLayoutManager(this);
        mrecyclerview.setLayoutManager(mlayoutmanager);


        mInterface = RetrofitClient.getRetrofitClient().create(InterfaceForce1.class);

        Call<List<MF_location>> call = mInterface.getLocationData("crimes-at-location?date="+mMonth+"&lat="+mlatitude+"&lng="+mLongitude);

        call.enqueue(new Callback<List<MF_location>>() {
            @Override
            public void onResponse(Call<List<MF_location>> call, Response<List<MF_location>> response) {

                locations = response.body();
                mlocationadapter = new locationadapter(locations);
                mrecyclerview.setAdapter(mlocationadapter);


            }

            @Override
            public void onFailure(Call<List<MF_location>> call, Throwable t) {

            }
        });
    }


}

