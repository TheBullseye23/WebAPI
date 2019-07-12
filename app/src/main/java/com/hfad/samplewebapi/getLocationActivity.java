package com.hfad.samplewebapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class getLocationActivity extends AppCompatActivity {

    EditText e1;
    EditText e2;
    EditText e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        e1=findViewById(R.id.MONTH);
        e2=findViewById(R.id.LATITUDE);
        e3=findViewById(R.id.LONGITUDE);

    }

    public void gotoLocation(View v){

        Intent intent = new Intent(this,LocationActivity.class);
        intent.putExtra("MONTH",e1.getText().toString());
        intent.putExtra("LATITUDE",e2.getText().toString());
        intent.putExtra("LONGITUDE",e3.getText().toString());
        startActivity(intent);
    }
}
