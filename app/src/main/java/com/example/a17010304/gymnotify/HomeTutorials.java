package com.example.a17010304.gymnotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.Vector;

public class HomeTutorials extends AppCompatActivity {
    RecyclerView rv;
    Vector<TutorialsClass> vids = new Vector<TutorialsClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tutorials);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home Workout Tutorials");
        rv = findViewById(R.id.recyclerViewHome);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        vids.add( new TutorialsClass("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/IODxDxX7oi4\" frameborder=\"1\" allowfullscreen></iframe>", "Push Up"));
        vids.add( new TutorialsClass("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/NDuty1AUw_o\" frameborder=\"1\" allowfullscreen></iframe>", "Scissors Sit Up"));
        vids.add( new TutorialsClass("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/aclHkVaku9U\" frameborder=\"1\" allowfullscreen></iframe>", "Squats"));


        CustomTutorialsAdapter caTutorials = new CustomTutorialsAdapter(vids);
        rv.setAdapter(caTutorials);
    }
}
