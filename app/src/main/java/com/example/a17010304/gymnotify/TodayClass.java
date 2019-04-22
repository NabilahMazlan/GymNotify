package com.example.a17010304.gymnotify;

public class TodayClass {

    private String tdyWorkout;
    private String tdyReps;
    private String tdyBodyParts;

    public TodayClass(String tdyWorkout, String tdyReps, String tdyBodyParts) {
        this.tdyWorkout = tdyWorkout;
        this.tdyReps = tdyReps;
        this.tdyBodyParts = tdyBodyParts;
    }

    public String getTdyWorkout() {
        return tdyWorkout;
    }

    public void setTdyWorkout(String tdyWorkout) {
        this.tdyWorkout = tdyWorkout;
    }

    public String getTdyReps() {
        return tdyReps;
    }

    public void setTdyReps(String tdyReps) {
        this.tdyReps = tdyReps;
    }

    public String getTdyBodyParts() {
        return tdyBodyParts;
    }

    public void setTdyBodyParts(String tdyBodyParts) {
        this.tdyBodyParts = tdyBodyParts;
    }
}
