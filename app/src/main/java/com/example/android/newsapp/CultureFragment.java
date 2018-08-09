package com.example.android.newsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class CultureFragment extends Fragment {

    private RecyclerView recyclerView;
    private String sportUrl = "https://content.guardianapis.com/search?show-fields=all&q=sport&api-key=c44317fa-d253-468d-91fe-9ba1758ae5a3";
    private List<Result> resultList;
    private  final String TAG = this.getClass().getSimpleName();
    private String inquiry = "culture";
    private String fields = "all";
    private String apiKey = "c44317fa-d253-468d-91fe-9ba1758ae5a3";


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
        Log.i(TAG,"перед началом запроса");
        App.getApi().getData(fields,inquiry,apiKey).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, retrofit2.Response<Example> response) {

                if(response.isSuccessful()) {
                    com.example.android.newsapp.Response res = response.body().getResponse();
                    List<Result> apiResults = res.getResults();
                    resultList.addAll(apiResults);
                    Log.i(TAG, "начинаем добавление информации");
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
