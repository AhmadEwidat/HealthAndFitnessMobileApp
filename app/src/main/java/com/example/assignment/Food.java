package com.example.assignment;

import androidx.annotation.NonNull;

//food class to build data of food
public class Food {
    private Double caloriesInGram;
    private String name;

    public Double getCaloriesInGram() {
        return caloriesInGram;
    }

    public void setCaloriesInGram(Double caloriesInGram) {
        this.caloriesInGram = caloriesInGram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food(String name, Double caloriesInGram) {
        this.caloriesInGram = caloriesInGram;
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
