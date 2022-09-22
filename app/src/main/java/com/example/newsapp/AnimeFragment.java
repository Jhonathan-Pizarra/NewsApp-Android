package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeFragment extends Fragment {

    String api = "a0df378c04fd4346a4c91fec207e33be";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "us";
    private RecyclerView recyclerView4anime;
    private String category = "anime";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.musicfragment, null);

        recyclerView4anime = vista.findViewById(R.id.recyclerview4anime);
        modelClassArrayList = new ArrayList<>();
        recyclerView4anime.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerView4anime.setAdapter(adapter);

        findNews();

        return vista;
    }

    private void findNews() {

        ApiUtilities.getApiInterface()
                .getCategoryNews(country, category, 100, api)
                .enqueue(new Callback<mainNews>() {
                    @Override
                    public void onResponse(Call<mainNews> call, Response<mainNews> response) {

                    }

                    @Override
                    public void onFailure(Call<mainNews> call, Throwable t) {

                    }
                });

    }
}
