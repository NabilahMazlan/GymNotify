package com.example.a17010304.gymnotify;

public class TutorialsClass {

    private String ytURl;
    private String gymWorkoutName;

    public TutorialsClass(String ytURl, String gymWorkoutName) {
        this.ytURl = ytURl;
        this.gymWorkoutName = gymWorkoutName;
    }

    public String getYtURl() {
        return ytURl;
    }

    public void setYtURl(String ytURl) {
        this.ytURl = ytURl;
    }

    public String getGymWorkoutName() {
        return gymWorkoutName;
    }

    public void setGymWorkoutName(String gymWorkoutName) {
        this.gymWorkoutName = gymWorkoutName;
    }
}
