package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//An interface to navigate between the interfaces that the user uses.
public class FirstPage extends AppCompatActivity {
    private Button btnCalculating, btnAdd, btnExercises;
    static double calories = 0;
    static double weWant = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        double[] arr = getIntent().getDoubleArrayExtra("arr");

        // Ensure the array is not null before using it and use it in calculation
        if (arr != null && arr.length == 3) {
            Profile profile = new Profile((int) arr[0], arr[1], arr[2]);
            weWant = (10 * profile.getWeightInKg()) + (625 * profile.getHeightInmeter()) - (5 * profile.getAge()) + 5;
            Log.d("FirstPage", "Calculated weWant: " + weWant);
            // Now you can use the profile object or calculated values
        }


        btnCalculating = findViewById(R.id.btnCalculating);
        btnAdd = findViewById(R.id.btnAdd);
        btnExercises = findViewById(R.id.btnExercises);

        btnCalculating.setOnClickListener(e -> {
            Intent caloriesIntent = new Intent(FirstPage.this, CaloriesPage.class);
            startActivity(caloriesIntent);
        });

        btnAdd.setOnClickListener(e -> {
            Intent addPageIntent = new Intent(FirstPage.this, AddPage.class);
            startActivity(addPageIntent);
        });

        btnExercises.setOnClickListener(e -> {
            Intent exercisesIntent = new Intent(FirstPage.this, ExercisesPage.class);
            startActivity(exercisesIntent);
        });
    }
}