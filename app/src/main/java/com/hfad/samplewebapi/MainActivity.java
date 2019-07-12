package com.hfad.samplewebapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void  GetForces(View view){
        Intent intent = new Intent(this,ForcesActivity.class);
        startActivity(intent);
    }

    public void GetLocation(View view){
        Intent intent = new Intent (this,getLocationActivity.class);
        startActivity(intent);
    }


}
