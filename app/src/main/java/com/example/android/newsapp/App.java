package com.example.android.newsapp;

import android.app.Application;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {


    private static GuardianApi guardianApi;
    private Retrofit retrofit;
    private  final String TAG = this.getClass().getSimpleName();

    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "до выполнени он креэйт в апп");
        retrofit = new Retrofit.Builder()
                .baseUrl("https://content.guardianapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        guardianApi = retrofit.create(GuardianApi.class);
        Log.i(TAG, "он креэйт в апп окончен");
    }

    public static GuardianApi getApi() {
        return guardianApi;
    }
}
