package com.example.mh.cb_sports_festival;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class IntroduceSlider extends AppCompatActivity {

    ViewPager viewPager;
    Slider adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new Slider(this);
        viewPager.setAdapter(adapter);
    }
}
