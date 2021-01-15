package com.chad.jokeapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.chad.jokeapp.R;
import com.chad.jokeapp.view.adapter.ViewPagerAdapter;
import com.chad.jokeapp.view.fragment.DailyJokeFragment;
import com.chad.jokeapp.view.fragment.JokeListFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new DailyJokeFragment(), "JOKE");
        viewPagerAdapter.addFragment(new JokeListFragment(), "JOKES");
        viewPager.setAdapter(viewPagerAdapter);
    }
}