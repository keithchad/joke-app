package com.chad.jokeapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.jokeapp.R;
import com.chad.jokeapp.data.viewmodel.JokeViewModel;

public class DailyJokeFragment extends Fragment {

    private TextView textDailyJoke;
    private SwipeRefreshLayout swipeRefreshLayout;

    private JokeViewModel jokeViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_joke, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view) {
        jokeViewModel = new ViewModelProvider(this).get(JokeViewModel.class);
        textDailyJoke = view.findViewById(R.id.textDailyJoke);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshHome);
        swipeRefreshLayout.setOnRefreshListener(this::getData);

        getData();
    }

    private void getData() {
        swipeRefreshLayout.setRefreshing(true);
        jokeViewModel.getJoke().observe(getViewLifecycleOwner(), joke -> {
            swipeRefreshLayout.setRefreshing(false);
            if (joke != null) {
                if (joke.getJoke() != null) {
                    textDailyJoke.setText(joke.getJoke());
                }
            }
        });
    }

}