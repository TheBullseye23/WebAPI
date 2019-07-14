package com.hfad.samplewebapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LocationDetailsActivity extends AppCompatActivity {

    private  String dcategory;
    private  String dlocationSubtype;
    private  String dmonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        Intent intent = getIntent();
        dcategory=intent.getStringExtra("mcategory");
        dlocationSubtype=intent.getStringExtra("mlocationSubtype");
        dmonth=intent.getStringExtra("mmonth");

        EditText category = findViewById(R.id.etcategory);
        EditText month = findViewById(R.id.etmonth);
        EditText locationsubtype = findViewById(R.id.etlocationsubtype);

        category.setText(dcategory);
        month.setText(dmonth);
        locationsubtype.setText(dlocationSubtype);

    }
}
