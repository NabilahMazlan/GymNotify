package com.example.a17010304.gymnotify;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TodayWorkout extends AppCompatActivity {

    ListView lvTdy;
    TextView tv;
    ArrayList<TodayClass> alShowTdy;
    TodayCustomAdapter caList;
    DatabaseHelper myDB;
    Date d = Calendar.getInstance().getTime();

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
    String dFormat = sdf.format(d);

    SimpleDateFormat sdfDay = new SimpleDateFormat("EEEE");
    String dayFormat = sdfDay.format(d);
    String dayDate = dayFormat + ", " + dFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_workout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Today's Workout");

        lvTdy = findViewById(R.id.listViewToday);
        tv = findViewById(R.id.textViewToday);
        myDB = new DatabaseHelper(this);



        final Cursor data =  myDB.getListContentsViewWorkout();
        alShowTdy = new ArrayList<>();


        tv.setText("Today: " + dayDate);


        while (data.moveToNext()){
            if(dayDate.equals(data.getString(1))){
                String workout = data.getString(2);
                String reps = data.getString(4);
                String bodyparts = data.getString(3);
                TodayClass item = new TodayClass(workout,reps,bodyparts);
                alShowTdy.add(item);
                caList = new TodayCustomAdapter(TodayWorkout.this, alShowTdy);
                lvTdy.setAdapter(caList);

                caList.notifyDataSetChanged();
            }


        }
        lvTdy.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(TodayWorkout.this);
                dialogBuilder.setTitle("Delete?");
                dialogBuilder.setMessage("Are you sure you want to delete?");
                dialogBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Cursor dataDate = myDB.getViewAllWorkoutID(dayDate);

                        int itemid = -1;
                        while (dataDate.moveToNext()){
                        itemid = dataDate.getInt(0);
                        }
                        if(itemid > -1){
                            myDB.deleteData(itemid,dayDate);
                            alShowTdy.remove(position);
                            caList.notifyDataSetChanged();
                            Toast.makeText(TodayWorkout.this, "Workout Deleted", Toast.LENGTH_SHORT).show();
                        }else{
                        Toast.makeText(TodayWorkout.this, "No such id with such date", Toast.LENGTH_SHORT).show();
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
