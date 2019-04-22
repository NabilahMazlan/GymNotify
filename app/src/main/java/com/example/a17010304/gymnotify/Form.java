package com.example.a17010304.gymnotify;

import  android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Form extends AppCompatActivity {

    Button btnSubmit;
    EditText etDate, etReps;
    Spinner spnBodyParts, spnWorkout;

    DatePickerDialog.OnDateSetListener dateListner;
    final Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);



    ArrayAdapter<String> aaBodyParts;
    ArrayList<String> alBodyParts = new ArrayList<>();

    ArrayAdapter<String> aaWorkout;
    ArrayList<String> alWorkout = new ArrayList<>();
    DatabaseHelper myDB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_categories);
        btnSubmit = findViewById(R.id.buttonDone);
        etDate = findViewById(R.id.editTextDate);
        etReps = findViewById(R.id.editTextReps);
        spnBodyParts = findViewById(R.id.spinnerBodyParts);
        spnWorkout = findViewById(R.id.spinnerWorkout);
        myDB = new DatabaseHelper(this);

        spnWorkout.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        spnBodyParts.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);

        Cursor data =  myDB.getListContentsBP();
        Cursor dataWorkout =  myDB.getListContentsWorkout();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Custom Workout");


        //To display the body part table from DatabaseHelper
        while(data.moveToNext()){
            alBodyParts.add(data.getString(1));
            aaBodyParts = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,alBodyParts);
            spnBodyParts.setAdapter(aaBodyParts);
        }

        //To display the workout table from DatabaseHelper
        while(dataWorkout.moveToNext()){
            alWorkout.add(dataWorkout.getString(1));
            aaWorkout = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,alWorkout);

            spnWorkout.setAdapter(aaWorkout);
        }

        spnWorkout.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(255,64,129));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spnBodyParts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(255,64,129));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        //Insert data into ViewAllWorkout table in the Database Helper
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datetime = etDate.getText().toString();
                String bodypart = spnBodyParts.getSelectedItem().toString();
                String workout = spnWorkout.getSelectedItem().toString();
                String reps = etReps.getText().toString();

                if(etDate.length() != 0){
                    AddData(datetime,bodypart,workout,reps);
                    etDate.setText("");
                    etReps.setText("");

                }else{
                    Toast.makeText(Form.this, "Please enter something", Toast.LENGTH_SHORT).show();

                }

            }
        });

        //To show current date
        etDate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(
                        Form.this,dateListner  ,year, month,day
                );
                dialog.show();

            }
        });

        //To show how will the dates be displayed
        dateListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int newyear, int newmonth, int newday) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
                calendar.set(newyear,newmonth,newday);
                String dateString = dateFormat.format(calendar.getTime());

                SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
                Date date = new Date();
                String dayString = dayFormat.format(date);
                etDate.setText(dayString +", " +dateString);

            }
        };

    }



    //To add data from the spinners and edit text into the DatabaseHelper
    public void AddData(String datetime, String bodypart, String workout, String reps){
        boolean insertData = myDB.addDataViewWorkout(datetime,bodypart,workout,reps);

        if (insertData == true){
            Toast.makeText(this, "Data entered", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data not entered ", Toast.LENGTH_SHORT).show();

        }
    }

}
