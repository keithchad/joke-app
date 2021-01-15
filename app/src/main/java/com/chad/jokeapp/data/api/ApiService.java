package com.chad.jokeapp.data.api;

import com.chad.jokeapp.data.model.AllJokes;
import com.chad.jokeapp.data.model.Joke;
import com.chad.jokeapp.data.response.AllJokesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({"Accept: application/json"})
    @GET(".")
    Call<Joke> getJoke();

    @Headers({"Accept: application/json"})
    @GET("search")
    Call<AllJokesResponse> getAllJokes(@Query("current_page") int page, @Query("limit") int limit);

}
