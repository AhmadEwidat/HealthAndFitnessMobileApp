package com.example.assignment;


import java.util.ArrayList;
import java.util.List;

//temp class because we do not have ready data base
public class ExercisesMockup {

    private List<Exercise> exerciseList;

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public ExercisesMockup() {
        exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("Running", 100, 3));
        exerciseList.add(new Exercise("Cycling", 80, 3));
        exerciseList.add(new Exercise("Swimming", 120, 4));
        exerciseList.add(new Exercise("Jump Rope", 90, 3));
        exerciseList.add(new Exercise("Yoga", 50, 2));
        exerciseList.add(new Exercise("Weightlifting", 150, 4));
        exerciseList.add(new Exercise("Hiking", 200, 5));
        exerciseList.add(new Exercise("Dancing", 75, 2));
        exerciseList.add(new Exercise("Boxing", 110, 3));
        exerciseList.add(new Exercise("Pilates", 65, 4));
    }


    public List<Exercise> getExerciseList() {
        return exerciseList;
    }
}
