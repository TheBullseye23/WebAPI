package com.hfad.samplewebapi.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://data.police.uk/api/";

    public static Retrofit getRetrofitClient() {
        {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL).
                                addConverterFactory(GsonConverterFactory.create()).build();
            }

            return retrofit;
        }

    }

}
