package com.chad.jokeapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.jokeapp.R;
import com.chad.jokeapp.data.model.AllJokes;
import com.chad.jokeapp.data.viewmodel.JokeViewModel;
import com.chad.jokeapp.view.adapter.JokeAdapter;

import java.util.ArrayList;
import java.util.List;

public class JokeListFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private JokeAdapter jokeAdapter;
    private JokeViewModel jokeViewModel;
    private List<AllJokes> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_list, container, false);
        initialize(view);
        swipeRefreshLayout.setRefreshing(true);
        return view;
    }

    private void initialize(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewHome);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshHome);

        list = new ArrayList<>();
        jokeAdapter = new JokeAdapter(getContext(), list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(jokeAdapter);

        jokeViewModel = new ViewModelProvider(this).get(JokeViewModel.class);
        swipeRefreshLayout.setOnRefreshListener(this::getAllJokes);

        getAllJokes();
    }

    private void getAllJokes() {
        jokeViewModel.getAllJokes(1, 30).observe(getViewLifecycleOwner(), allJokesResponse -> {
            if (allJokesResponse != null) {
                if (allJokesResponse.getAllJokes() != null) {
                    list.addAll(allJokesResponse.getAllJokes());
                    jokeAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}