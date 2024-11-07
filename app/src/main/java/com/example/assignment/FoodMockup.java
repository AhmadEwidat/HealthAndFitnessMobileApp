package com.example.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//temp class because we do not have ready data base
public class FoodMockup {
    private ArrayList<Food> foodList = new ArrayList<>();

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public FoodMockup() {
        foodList.add(new Food("Banana", 0.89));
        foodList.add(new Food("Apple", 0.52));
        foodList.add(new Food("Orange", 0.47));
        foodList.add(new Food("Strawberry", 0.32));
        foodList.add(new Food("Grapes", 0.69));
        foodList.add(new Food("Avocado", 1.6));
        foodList.add(new Food("Broccoli", 0.34));
        foodList.add(new Food("Carrot", 0.41));
        foodList.add(new Food("Chicken Breast", 1.65));
        foodList.add(new Food("Salmon", 2.08));
        // Sorting the foodList by name
        Collections.sort(foodList, Comparator.comparing(Food::getName));
    }
}
