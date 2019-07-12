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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationActivity extends AppCompatActivity {

    private String mMONTH;
    private String mLATITUDE;
    private String mLONGITUDE;


    private RecyclerView lrecyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private locationadapter mlocationadapter;
    private List<MF_location> locations;

    private InterfaceForce1 linterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Intent intent = getIntent();
        mMONTH =intent.getStringExtra("MONTH");
        mLATITUDE = intent.getStringExtra("LATITUDE");
        mLONGITUDE = intent.getStringExtra("LONGITUDE");

        lrecyclerview = findViewById(R.id.RVlocation);
        mLayoutManager = new LinearLayoutManager(this);
        lrecyclerview.setLayoutManager(mLayoutManager);

        linterface = RetrofitClient.getRetrofitClient().create(InterfaceForce1.class);

        Call <List<MF_location>> call = linterface.getLocationData("crimes-at-location?date="+mMONTH+"&lat="+mLATITUDE+"&lng="+mLONGITUDE);

        call.enqueue(new Callback<List<MF_location>>() {
            @Override
            public void onResponse(Call<List<MF_location>> call, Response<List<MF_location>> response) {
                locations = response.body();
                mlocationadapter = new locationadapter(locations);
                lrecyclerview.setAdapter(mlocationadapter);
                mlocationadapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<MF_location>> call, Throwable t) {

            }
        });






    }
}
