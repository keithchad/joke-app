package com.chad.jokeapp.view.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        ImageView imageNoInternet = view.findViewById(R.id.imageNoInternet);
        TextView textNoInternet = view.findViewById(R.id.textNoInternet);
        TextView text = view.findViewById(R.id.text);
        textDailyJoke = view.findViewById(R.id.textDailyJoke);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshHome);
        swipeRefreshLayout.setOnRefreshListener(this::getData);

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            text.setVisibility(View.VISIBLE);
            textDailyJoke.setVisibility(View.VISIBLE);
            textNoInternet.setVisibility(View.GONE);
            imageNoInternet.setVisibility(View.GONE);
            getData();
        } else {
            text.setVisibility(View.GONE);
            textDailyJoke.setVisibility(View.GONE);
            textNoInternet.setVisibility(View.VISIBLE);
            imageNoInternet.setVisibility(View.VISIBLE);
        }
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