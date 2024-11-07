package com.example.assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//This page suggests appropriate activities based on the amount of food you have eaten and the amount of food your body needs.
public class ExercisesPage extends AppCompatActivity {
    private ExercisesMockup exercisesMockup;
    private LinearLayout checkboxContainer;
    private int numberOfExersice = 0;
    private double remainingCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_page);

        checkboxContainer = findViewById(R.id.checkboxContainer);
        Button btnConfirm = findViewById(R.id.btnConfirm);
        remainingCalories = FirstPage.calories;
        exercisesMockup = new ExercisesMockup();

        // Loop through exercises while calories remain and exercises are available
        while (remainingCalories > FirstPage.weWant && numberOfExersice < exercisesMockup.getExerciseList().size()) {
            Exercise exercise = exercisesMockup.getExerciseList().get(numberOfExersice);
            CheckBox newCheckbox = new CheckBox(this);
            newCheckbox.setText(
                    exercise.getName() + " ,Minutes: " + exercise.getNumberOfRounds() +
                            " Calories Burned per minute: " + exercise.getNumberOfCaloriesPerRound()
            );
            remainingCalories -= exercise.getNumberOfRounds() * exercise.getNumberOfCaloriesPerRound();
            //   To deduct the value of calories burned and arrange the cheackboxes
            newCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                double caloriesBurned = exercise.getNumberOfRounds() * exercise.getNumberOfCaloriesPerRound();

                if (isChecked) {
                    Toast.makeText(
                            ExercisesPage.this,
                            newCheckbox.getText() + " checked",
                            Toast.LENGTH_SHORT
                    ).show();


                    FirstPage.calories -= caloriesBurned;
                } else {
                    Toast.makeText(
                            ExercisesPage.this,
                            newCheckbox.getText() + " unchecked",
                            Toast.LENGTH_SHORT
                    ).show();


                    FirstPage.calories += caloriesBurned;
                }


            });

            newCheckbox.setPadding(0, 10, 0, 0);
            newCheckbox.setTextSize(20);
            checkboxContainer.addView(newCheckbox);

            numberOfExersice++;
        }

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
