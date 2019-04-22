package com.example.a17010304.gymnotify;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

public class PreWorkoutTutorials extends AppCompatActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_workout_tutorials);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Pre Workout Tutorials");
        wv = findViewById(R.id.wvPreWorkout);
        wv.setWebChromeClient(new WebChromeClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setBackgroundColor(Color.rgb(0,0,0));
        wv.loadData("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/brsunpE46P4\" frameborder=\"1\" allowfullscreen></iframe>", "text/html" , "utf-8");
    }
}
