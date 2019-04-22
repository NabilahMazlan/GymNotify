package com.example.a17010304.gymnotify;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddingToSpinners extends AppCompatActivity {
    Spinner spnAdd;
    EditText etAdd;
    Button btnAdd;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_to_spinners);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Add Workouts and Body Parts");
        spnAdd = findViewById(R.id.spinner);
        etAdd = findViewById(R.id.editTextAdding);
        btnAdd = findViewById(R.id.buttonAddItems);
        myDB = new DatabaseHelper(this);


        spnAdd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(255,64,129));

                switch (position){
                    case 0:
                        etAdd.setHint("Add Body Parts");
                        break;
                    case 1:
                        etAdd.setHint("Add Workout");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etAdd.getHint().equals("Add Body Parts")){
                    AddBodyPartsData(etAdd.getText().toString().trim());
                    etAdd.setText("");
                }else if(etAdd.getHint().equals("Add Workout")){
                    AddWorkoutData(etAdd.getText().toString().trim());
                    etAdd.setText("");
                }
            }
        });

    }

    public void AddBodyPartsData(String bodyParts){
        boolean insertData = myDB.addDataBodyPart(bodyParts);

        if (insertData == true){
            Toast.makeText(this, "Data entered", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data not entered ", Toast.LENGTH_SHORT).show();

        }
    }

    public void AddWorkoutData(String workout){
        boolean insertData = myDB.addDataWorkout(workout);

        if (insertData == true){
            Toast.makeText(this, "Data entered", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data not entered ", Toast.LENGTH_SHORT).show();

        }
    }
}
