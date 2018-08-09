package com.example.android.newsapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportFragment  extends Fragment {

    private RecyclerView recyclerView;
    private List<Result> resultList;
    private  final String TAG = this.getClass().getSimpleName();
    private final String inquiry = "sport";
    private  final String fields = "all";
    private final String apiKey = "c44317fa-d253-468d-91fe-9ba1758ae5a3";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.news_list_layout, container, false);
        resultList = new ArrayList<>();

        recyclerView =  view.findViewById(R.id.news_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        NewsAdapter adapter = new NewsAdapter(resultList);
        recyclerView.setAdapter(adapter);
        App.getApi().getData(fields,inquiry,apiKey).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if(response.isSuccessful()) {
                    com.example.android.newsapp.Response res = response.body().getResponse();
                    List<Result> apiResults = res.getResults();
                    resultList.addAll(apiResults);
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getContext(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
