package com.chad.jokeapp.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.chad.jokeapp.data.api.ApiClient;
import com.chad.jokeapp.data.api.ApiService;
import com.chad.jokeapp.data.model.Joke;
import com.chad.jokeapp.data.response.AllJokesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeRepository {

    private final ApiService apiService;

    public JokeRepository() {
        apiService = new ApiClient().getRetrofit().create(ApiService.class);
    }

    public MutableLiveData<Joke> getJoke() {
        MutableLiveData<Joke> data = new MutableLiveData<>();
        apiService.getJoke().enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(@NonNull Call<Joke> call, @NonNull Response<Joke> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Joke> call, @NonNull Throwable t) {
                Log.e("error", t.toString());
            }
        });
        return data;
    }

    public MutableLiveData<AllJokesResponse> getAllJokes(int page, int limit) {
        MutableLiveData<AllJokesResponse> data = new MutableLiveData<>();
        apiService.getAllJokes(page, limit).enqueue(new Callback<AllJokesResponse>() {
            @Override
            public void onResponse(@NonNull Call<AllJokesResponse> call, @NonNull Response<AllJokesResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<AllJokesResponse> call,@NonNull Throwable t) {
                Log.e("AllJOkesError", t.toString());
            }
        });
        return data;
    }
}
