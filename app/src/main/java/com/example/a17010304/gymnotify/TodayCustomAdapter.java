package com.example.a17010304.gymnotify;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TodayCustomAdapter extends BaseAdapter {

    Context parent_context;
    ArrayList<TodayClass> tdyLists;

    public TodayCustomAdapter(@NonNull Context context, @NonNull ArrayList<TodayClass> objects){

        this.parent_context = context;
        tdyLists = objects;
    }
    @Override
    public int getCount() {
        return tdyLists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        TodayClass items = tdyLists.get(position);
        if (convertview ==  null) {
            LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.custom_today_list_view, null);
        }
        TextView tvTdyWorkout = convertview.findViewById(R.id.textViewTodayWorkout);
        TextView tvTdyReps = convertview.findViewById(R.id.textViewTodayReps);
        TextView tvTdyBodyParts = convertview.findViewById(R.id.textViewTodayBodyParts);

        tvTdyWorkout.setText(items.getTdyWorkout());
        tvTdyReps.setText(items.getTdyReps());
        tvTdyBodyParts.setText(items.getTdyBodyParts());


        return convertview;
    }
}
