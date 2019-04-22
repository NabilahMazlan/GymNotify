package com.example.a17010304.gymnotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.Vector;

public class OutdoorTutorials extends AppCompatActivity {
    RecyclerView rv;
    Vector<TutorialsClass> vids = new Vector<TutorialsClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_tutorials);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Outdoor Workout Tutorials");
        rv = findViewById(R.id.recyclerViewOutdoor);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        vids.add( new TutorialsClass("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/eGo4IYlbE5g\" frameborder=\"1\" allowfullscreen></iframe>", "Pull-Ups"));
        vids.add( new TutorialsClass("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/2z8JmcrW-As\" frameborder=\"1\" allowfullscreen></iframe>", "Dips"));

        CustomTutorialsAdapter caTutorials = new CustomTutorialsAdapter(vids);
        rv.setAdapter(caTutorials);
    }
}
