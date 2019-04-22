package com.example.a17010304.gymnotify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.Vector;

public class CommonGymTutorials extends AppCompatActivity {
    RecyclerView rv;
    Vector<TutorialsClass> vids = new Vector<TutorialsClass>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_gym_tutorials);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Common Gym Workout Tutorials");
        rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        vids.add( new TutorialsClass("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/vthMCtgVtFw\" frameborder=\"1\" allowfullscreen></iframe>", "Bench Press"));
        vids.add( new TutorialsClass("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/RQU8wZPbioA\" frameborder=\"1\" allowfullscreen></iframe>", "Barbell Row"));
        vids.add( new TutorialsClass("<iframe width=\"100%\" height=\"50%\" src=\"https://www.youtube.com/embed/kwG2ipFRgfo\" frameborder=\"1\" allowfullscreen></iframe>", "Barbell Bicep Curl"));

        CustomTutorialsAdapter caTutorials = new CustomTutorialsAdapter(vids);
        rv.setAdapter(caTutorials);

    }
}
