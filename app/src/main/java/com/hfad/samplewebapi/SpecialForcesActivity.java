package com.hfad.samplewebapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hfad.samplewebapi.model.FORCES.ForcesData2;
import com.hfad.samplewebapi.model.FORCES.ForcesData3;
import com.hfad.samplewebapi.rest.InterfaceForce1;
import com.hfad.samplewebapi.rest.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hfad.samplewebapi.ForcesActivity.forcename;

public class SpecialForcesActivity extends AppCompatActivity {

    private static String name;
    private InterfaceForce1 kInterface;
    private ForcesData3 mSpecialforce;
    private ForcesData2 mForceData2;
    public String desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_forces);

        Intent intent = getIntent();
        String name = intent.getStringExtra(forcename);

        kInterface= RetrofitClient.getRetrofitClient().create(InterfaceForce1.class);

        Call <ForcesData3> call = kInterface.getSpecialForces("forces/"+name);
        call.enqueue(new Callback<ForcesData3>() {
            @Override
            public void onResponse(Call<ForcesData3> call, Response<ForcesData3> response) {
                mSpecialforce = response.body();
                TextView description=findViewById(R.id.description);
                TextView name = findViewById(R.id.sfname);
                TextView sfurl = findViewById(R.id.urlsf);

                desc= (String) mSpecialforce.getDescription();

                description.setText(desc);
                name.setText(mSpecialforce.getName());
                sfurl.setText(mSpecialforce.getUrl());

            }

            @Override
            public void onFailure(Call<ForcesData3> call, Throwable t) {

            }
        });


        }




    }

