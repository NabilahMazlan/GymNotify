package com.example.a17010304.gymnotify;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;

public class TutorialFragment extends Fragment {
    GridLayout gridLayout;
    CardView cvPre, cvGym, cvOutdoor, cvHome, cvPost;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tutorial_fragment, container,  false);
        gridLayout = view.findViewById(R.id.gridLayout);
        cvPre = view.findViewById(R.id.cardViewPre);
        cvPost = view.findViewById(R.id.cardViewPost);
        cvGym = view.findViewById(R.id.cardViewGym);
        cvOutdoor = view.findViewById(R.id.cardViewOutdoor);
        cvHome = view.findViewById(R.id.cardViewHome);



        cvPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PreWorkoutTutorials.class);
                startActivity(intent);
            }
        });

        cvGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommonGymTutorials.class);
                startActivity(intent);
            }
        });

        cvOutdoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OutdoorTutorials.class);
                startActivity(intent);
            }
        });

        cvPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PostWorkoutTutorials.class);
                startActivity(intent);
            }
        });

        cvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeTutorials.class);
                startActivity(intent);
            }
        });




        return view;

    }

}
