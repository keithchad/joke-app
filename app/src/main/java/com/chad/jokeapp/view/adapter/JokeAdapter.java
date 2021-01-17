package com.chad.jokeapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.jokeapp.R;
import com.chad.jokeapp.data.model.AllJokes;

import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> {

    private final Context context;
    private final List<AllJokes> list;

    public JokeAdapter(Context context, List<AllJokes> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.joke_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AllJokes jokes = list.get(position);
        holder.textViewJoke.setText(jokes.getJoke());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textViewJoke;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewJoke = itemView.findViewById(R.id.textJoke);
        }
    }
}
