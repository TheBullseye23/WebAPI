package com.hfad.samplewebapi.rest;

import com.hfad.samplewebapi.model.ForcesData;
import com.hfad.samplewebapi.model.ForcesData2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfaceForce1 {


        @GET("forces/ ")
        Call<List<ForcesData>> getForcesData();

        @GET("/{forcename}")
        Call <ForcesData2> getForceData2(@Path("forcename") String forceName  );

}
