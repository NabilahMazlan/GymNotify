package com.example.a17010304.gymnotify;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context parent_context;
    ArrayList<WorkoutItems> workoutLists;

    public CustomAdapter(@NonNull  Context context, @NonNull ArrayList<WorkoutItems> objects){

        this.parent_context = context;
        workoutLists = objects;
    }



    @NonNull
    @Override
    public View getView(int position , @Nullable View convertView, @NonNull ViewGroup parent){
        WorkoutItems items = workoutLists.get(position);

        if (convertView ==  null) {
            LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list_view, null, true);
        }
            TextView tvBP = convertView.findViewById(R.id.textViewBP);
            TextView tvDate = convertView.findViewById(R.id.textViewDate);
            TextView tvWorkout = convertView.findViewById(R.id.textViewWorkout);
            TextView tvReps = convertView.findViewById(R.id.textViewReps);

            tvDate.setText(items.getDate());
            tvWorkout.setText(items.getWorkout());
            tvBP.setText(items.getBP());
            tvReps.setText(items.getReps());



        return convertView;


    }

    public int getCount(){
        return workoutLists.size();
    }

    public  Object getItem(int pos){
        return pos;
    }

    public long getItemId(int pos){
        return pos;
    }
}
