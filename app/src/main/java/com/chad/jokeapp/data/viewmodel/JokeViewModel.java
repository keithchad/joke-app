package com.chad.jokeapp.data.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chad.jokeapp.data.model.Joke;
import com.chad.jokeapp.data.repository.JokeRepository;

public class JokeViewModel extends ViewModel {

    private JokeRepository jokeRepository;

    public JokeViewModel() {
        jokeRepository = new JokeRepository();
    }

    public MutableLiveData<Joke> getJoke() {
        return jokeRepository.getJoke();
    }
}
