package com.hfad.samplewebapi.rest;

import com.hfad.samplewebapi.model.FORCES.ForcesData;
import com.hfad.samplewebapi.model.FORCES.ForcesData2;
import com.hfad.samplewebapi.model.FORCES.ForcesData3;
import com.hfad.samplewebapi.model.LOCATION.MF_location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface InterfaceForce1 {


        @GET("forces")
        Call<List<ForcesData>> getForcesData();

        @GET
        Call <ForcesData3> getSpecialForces(@Url String Url );

        @GET
        Call <List<MF_location>> getLocationData(@Url  String Url );


}
