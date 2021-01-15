package com.chad.jokeapp.data.repository;

import com.chad.jokeapp.data.api.ApiClient;
import com.chad.jokeapp.data.api.ApiService;

public class JokeRepository {

    private ApiService apiService;

    private JokeRepository() {
        apiService = new ApiClient().getRetrofit().create(ApiService.class);
    }
}
