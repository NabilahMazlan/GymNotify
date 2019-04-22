package com.example.a17010304.gymnotify;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;


public class WorkoutFragment extends Fragment {
    Button btnCustom, btnTdy;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.workout_fragment, container,  false);

        btnCustom = view.findViewById(R.id.buttonCustom);
        btnTdy = view.findViewById(R.id.buttonToday);


        btnCustom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Form.class);
                startActivity(intent);

            }
        });

        btnTdy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), TodayWorkout.class);
                startActivity(intent);

            }
        });


        return view;
    }


}

