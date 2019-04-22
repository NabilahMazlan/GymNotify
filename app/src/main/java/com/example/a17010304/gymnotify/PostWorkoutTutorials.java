package com.example.a17010304.gymnotify;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class PostWorkoutTutorials extends AppCompatActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_workout_tutorials);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Post Workout Tutorials");
        wv = findViewById(R.id.wvPostWorkout);
        wv.setWebChromeClient(new WebChromeClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setBackgroundColor(Color.rgb(0,0,0));
        wv.loadData("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/yOxDeD4sPcE\" frameborder=\"1\" allowfullscreen></iframe>", "text/html" , "utf-8");
    }
}
