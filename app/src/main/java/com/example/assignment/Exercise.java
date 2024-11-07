package com.example.assignment;

//to build exercises we need in exercise page
public class Exercise {
    private String name;
    private double NumberOfCaloriesPerRound;
    private int numberOfRounds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumberOfCaloriesPerRound() {
        return NumberOfCaloriesPerRound;
    }

    public void setNumberOfCaloriesPerRound(double numberOfCaloriesPerRound) {
        NumberOfCaloriesPerRound = numberOfCaloriesPerRound;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public Exercise(String name, double numberOfCaloriesPerRound, int numberOfRounds) {
        this.name = name;
        NumberOfCaloriesPerRound = numberOfCaloriesPerRound;
        this.numberOfRounds = numberOfRounds;
    }

}
