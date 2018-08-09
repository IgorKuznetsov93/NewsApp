package com.example.android.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GuardianApi
{
    @GET("/search")
    Call<Example> getData(@Query("show-fields") String fields, @Query("q") String inquiry, @Query("api-key") String apiKey);
}

