package com.hfad.samplewebapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;


import com.hfad.samplewebapi.Adapter.recycleradapter;
import com.hfad.samplewebapi.model.FORCES.ForcesData;
import com.hfad.samplewebapi.rest.InterfaceForce1;
import com.hfad.samplewebapi.rest.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForcesActivity extends AppCompatActivity implements recycleradapter.OnItemClickListener {

    public static final String forcename=null;

    private RecyclerView recyclerView;
    private List<ForcesData> forcesData;
    private recycleradapter mrecycleradapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private InterfaceForce1 mInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forces);

        recyclerView = findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);

        mInterface = RetrofitClient.getRetrofitClient().create(InterfaceForce1.class);

        Call<List<ForcesData>> call = mInterface.getForcesData();
        call.enqueue(new Callback<List<ForcesData>>() {
            @Override
            public void onResponse(Call<List<ForcesData>> call, Response<List<ForcesData>> response) {

                forcesData = response.body();
                mrecycleradapter = new recycleradapter(forcesData);
                recyclerView.setAdapter(mrecycleradapter);
                mrecycleradapter.setOnItemClickListener(ForcesActivity.this);

            }

            @Override
            public void onFailure(Call<List<ForcesData>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.forcesdata_menu,menu);

        MenuItem searchItem=menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            mrecycleradapter.getFilter().filter(s);
            return false;
        }
    });

        return true;
    }

    @Override
    public void onItemClick(int position) {
            Intent intent = new Intent(this,SpecialForcesActivity.class);
            ForcesData clickeditem = forcesData.get(position);
            intent.putExtra(forcename,clickeditem.getId());
            startActivity(intent);
    }
}


