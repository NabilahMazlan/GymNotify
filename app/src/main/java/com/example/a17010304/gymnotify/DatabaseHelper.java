package com.example.a17010304.gymnotify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String GYMNOTIFY = "gymnotify.db";

    //For creating body part table
    public static final String bodypart_table = "bodypart_data";
    public static final String bodypart_id = "bodypart_id";
    public static final String body_part = "body_part";

    //For creating workout table
    public static final String workout_table = "workout_data";
    public static final String workout_id = "workout_id";
    public static final String workout = "workout";


    //For creating view all workouts table
    public static final String view_workout_table = "view_workout_data";
    public static final String view_workout_id = "view_workout_id";
    public static final String view_workout_date = "view_workout_date";
    public static final String view_bodypart = "view_bodypart";
    public static final String view_workout = "view_workout";
    public static final String view_reps = "view_reps";





    public DatabaseHelper(Context context) {
        super(context, GYMNOTIFY, null, 3);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creating body part table
        String createBodyPartTable = "CREATE TABLE  " +  bodypart_table + "" +
                "(" + bodypart_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + body_part + " VARCHAR(5)); ";

        sqLiteDatabase.execSQL(createBodyPartTable);
        sqLiteDatabase.execSQL("INSERT INTO bodypart_data (body_part) VALUES ('Arms');");
        sqLiteDatabase.execSQL("INSERT INTO bodypart_data (body_part) VALUES ('Biceps');");
        sqLiteDatabase.execSQL("INSERT INTO bodypart_data (body_part) VALUES ('Calf');");
        sqLiteDatabase.execSQL("INSERT INTO bodypart_data (body_part) VALUES ('Chest');");


        //Creating workout table
        String createWorkoutTable = "CREATE TABLE " + workout_table
                + " ( " + workout_id +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + workout + " VARCHAR(5) , "
                +  " bodypartid INTEGER ,"
                + " FOREIGN KEY(bodypartid)  REFERENCES " +  bodypart_table + "(" + bodypart_id + ")" + ");";
        sqLiteDatabase.execSQL(createWorkoutTable);
        sqLiteDatabase.execSQL("INSERT INTO workout_data (workout, bodypartid) " +
                "VALUES ('Barbell Curl',( SELECT " + bodypart_id +" " +
                "FROM " + bodypart_table + " " +
                "WHERE " + body_part + "='Biceps')); ");
        sqLiteDatabase.execSQL("INSERT INTO workout_data (workout, bodypartid) " +
                "VALUES ('Pushup',( SELECT " + bodypart_id +" " +
                "FROM " + bodypart_table + " " +
                "WHERE " + body_part + "='Arms')); ");


        //Creating view all workout table
        String createViewWorkoutTable = "CREATE TABLE " + view_workout_table +
                " ( " + view_workout_id +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + view_workout_date + " TEXT , " + view_workout + " TEXT , " + view_bodypart + " TEXT , " + view_reps + " TEXT );" ;
        sqLiteDatabase.execSQL(createViewWorkoutTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + bodypart_table);
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + workout_table);
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + view_workout_table);


        onCreate(sqLiteDatabase);
    }

    //To add data to into body part table
    public boolean addDataBodyPart(String item1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValuesBodyPart = new ContentValues();
        contentValuesBodyPart.put(body_part, item1);

        long resultBodyPart = db.insert(bodypart_table, null, contentValuesBodyPart);

        //if date as inserted incorrectly it will return -1
        if (resultBodyPart == -1) {
            return false;
        } else {
            return true;
        }
    }

    //To add data to into workout table
    public boolean addDataWorkout(String item1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValuesWorkout = new ContentValues();
        contentValuesWorkout.put(workout, item1);

        long resultWorkout = db.insert(workout_table, null, contentValuesWorkout);

        //if date as inserted incorrectly it will return -1
        if (resultWorkout == -1) {
            return false;
        } else {
            return true;
        }
    }

    //To add data to into view all workout table
    public boolean addDataViewWorkout( String date, String bodypart, String workout, String reps) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValuesViewWorkout = new ContentValues();
        contentValuesViewWorkout.put(view_workout_date, date);
        contentValuesViewWorkout.put(view_bodypart, bodypart);
        contentValuesViewWorkout.put(view_workout, workout);
        contentValuesViewWorkout.put(view_reps, reps);

        long resultViewWorkout = db.insert(view_workout_table, null, contentValuesViewWorkout);

        //if date as inserted incorrectly it will return -1
        if (resultViewWorkout == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteData(int id, String date ){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + view_workout_table +
                " WHERE " + view_workout_id + " = '" + id + "'" +
                " AND " + view_workout_date + " = '" + date + "'";
        db.execSQL(query);

    }


    public Cursor getViewAllWorkoutID(String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query   = "SELECT " + view_workout_id + " FROM " + view_workout_table + " WHERE " + view_workout_date + " = '" + date + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //To display all items in body part table
    public Cursor getListContentsBP(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dataBP = db.rawQuery("SELECT * FROM " + bodypart_table, null);
        return dataBP;
    }

    //To display all items in workout table

    public Cursor getListContentsWorkout(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dataWorkout = db.rawQuery("SELECT * FROM " + workout_table, null);
        return dataWorkout;
    }

    //To display all items in view all workout table

    public Cursor getListContentsViewWorkout(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dataViewWorkout = db.rawQuery("SELECT * FROM " + view_workout_table, null);
        return dataViewWorkout;

    }

}
