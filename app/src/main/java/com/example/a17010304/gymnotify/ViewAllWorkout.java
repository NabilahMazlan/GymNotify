package com.example.a17010304.gymnotify;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAllWorkout extends AppCompatActivity {

    ListView lvWorkout;
    ArrayList<WorkoutItems> alShowWorkout;
    CustomAdapter caList;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_workout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("View All Workouts");
        lvWorkout = findViewById(R.id.listViewAllWorkout);
        myDB = new DatabaseHelper(this);




        Cursor data =  myDB.getListContentsViewWorkout();
        alShowWorkout = new ArrayList<>();

        for (data.move(0); data.moveToNext();data.isAfterLast()){
            String date = data.getString(1);
            String bodypart = data.getString(3);
            String workout = data.getString(2);
            String reps = data.getString(4);

            WorkoutItems item = new WorkoutItems(date, bodypart, workout,reps);
            alShowWorkout.add(item);
            caList = new CustomAdapter(ViewAllWorkout.this, alShowWorkout);

            lvWorkout.setAdapter(caList);
            caList.notifyDataSetChanged();
        }

        lvWorkout.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, final View view, final int position, long id) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ViewAllWorkout.this);
                dialogBuilder.setTitle("Delete?");
                dialogBuilder.setMessage("Are you sure you want to delete?");
                dialogBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                            String date = ((TextView) view.findViewById(R.id.textViewDate)).getText().toString();
                            Cursor dataDate = myDB.getViewAllWorkoutID(date);
                            int itemid = -1;
                            while (dataDate.moveToNext()){
                                itemid = dataDate.getInt(0);
                            }
                            if(itemid > -1){
                                myDB.deleteData(itemid,date);
                                alShowWorkout.remove(position);
                                caList.notifyDataSetChanged();
                                Toast.makeText(ViewAllWorkout.this, "Workout Deleted", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(ViewAllWorkout.this, "No such id with such date", Toast.LENGTH_SHORT).show();
                            }


                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();



                return true;
            }
        });







    }


}
