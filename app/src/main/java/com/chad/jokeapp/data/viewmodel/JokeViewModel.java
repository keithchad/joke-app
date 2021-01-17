package com.chad.jokeapp.data.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chad.jokeapp.data.model.Joke;
import com.chad.jokeapp.data.repository.JokeRepository;
import com.chad.jokeapp.data.response.AllJokesResponse;

public class JokeViewModel extends ViewModel {

    private final JokeRepository jokeRepository;

    public JokeViewModel() {
        jokeRepository = new JokeRepository();
    }

    public MutableLiveData<Joke> getJoke() {
        return jokeRepository.getJoke();
    }

    public MutableLiveData<AllJokesResponse> getAllJokes(int page, int limit) {
        return jokeRepository.getAllJokes(page, limit);
    }
}
