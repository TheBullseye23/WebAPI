package com.hfad.samplewebapi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hfad.samplewebapi.Adapter.FavAdapter;
import com.hfad.samplewebapi.SQLite.SQliteDatabase;
import com.hfad.samplewebapi.model.FavData;
import com.hfad.samplewebapi.model.LOCATION.MF_location;

import java.util.ArrayList;
import java.util.List;

public class FavouritesActivity extends AppCompatActivity {

    private RecyclerView mrecyclerview;
    private RecyclerView.LayoutManager mlayoutmanager;
    private FavAdapter mFavAdapter;
    SQliteDatabase sqldatabase;
    List<FavData> mListFavData=new ArrayList<>();

    Cursor mcursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        mrecyclerview=findViewById(R.id.RVfav);
        mlayoutmanager= new LinearLayoutManager(this);
        mrecyclerview.setLayoutManager(mlayoutmanager);
        mrecyclerview.setHasFixedSize(true);
        sqldatabase=new SQliteDatabase(this);
        mListFavData=sqldatabase.getData();
        mFavAdapter=new FavAdapter(mListFavData,this);
        mrecyclerview.setAdapter(mFavAdapter);


    }
}





