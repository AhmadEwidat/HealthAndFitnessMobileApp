package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
//An interface to add the food you have eaten to count it as calories and then build mathematical equations.

public class AddPage extends AppCompatActivity {
    Spinner spnFood;
    EditText edtGrams;
    List<Food> listfood;
    Button btnAddFood, btnRet;
    FoodMockup foodMockup = new FoodMockup();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//fill spinner
        listfood = foodMockup.getFoodList();
        spnFood = findViewById(R.id.spnFood);
        Food[] arrFood = listfood.toArray(new Food[0]); // Use a cleaner way to convert list to array
        ArrayAdapter<Food> stnArrayAdapter = new ArrayAdapter<>(AddPage.this, android.R.layout.simple_list_item_1, arrFood);
        spnFood.setAdapter(stnArrayAdapter);
        edtGrams = findViewById(R.id.edtGrams);

        btnAddFood = findViewById(R.id.btnAddFood);
        btnRet = findViewById(R.id.btnRet);
        // do some calculation to calculate the calories
        btnAddFood.setOnClickListener(e -> {
            String gramsText = edtGrams.getText().toString();
            if (!gramsText.isEmpty()) {
                double grams = Double.parseDouble(gramsText);
                double calculatedCalories = calculatingCalories((Food) spnFood.getSelectedItem(), grams);
                FirstPage.calories += calculatedCalories;
                Toast.makeText(this, "Calories added: " + calculatedCalories + "\nTotal Calories: " + FirstPage.calories, Toast.LENGTH_SHORT).show(); // Optional toast for confirmation
            } else {
                Toast.makeText(this, "Please enter the grams.", Toast.LENGTH_SHORT).show(); // Handle empty input
            }
        });
        //back button
        btnRet = findViewById(R.id.btnRet);
        btnRet.setOnClickListener(e -> {
            finish();
        });
    }

    public double calculatingCalories(Food food, double grams) {
        return food.getCaloriesInGram() * grams; // Ensure this is correct
    }
}
