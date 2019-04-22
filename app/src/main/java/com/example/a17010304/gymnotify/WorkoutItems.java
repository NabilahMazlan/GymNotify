package com.example.a17010304.gymnotify;

public class WorkoutItems {

    private String date;
    private String bodyparts;
    private String workout;
    private String reps;


    public WorkoutItems(String date, String bodyparts, String workout, String reps) {
        this.date = date;
        this.bodyparts = bodyparts;
        this.workout = workout;
        this.reps = reps;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBP() {
        return bodyparts;
    }

    public void setBP(String bodyparts) {
        this.bodyparts = bodyparts;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

}
