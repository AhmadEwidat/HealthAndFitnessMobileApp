package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Interface to display calorie statistics and give advice for the next step
public class CaloriesPage extends AppCompatActivity {
    private Button btnReturn;
    private TextView txtCalories, txtCalWant, txtState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calories_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtState = findViewById(R.id.txtState);
        txtCalories = findViewById(R.id.txtCalories);
        txtCalWant = findViewById(R.id.txtCaloriesWeWant);
        btnReturn = findViewById(R.id.btnReturn);
        txtCalories.setText("Calories: " + FirstPage.calories);
        txtCalWant.setText("Calories: " + FirstPage.weWant);
        //to give device by use mathematical equation
        if (FirstPage.calories < FirstPage.weWant) {
            Toast.makeText(CaloriesPage.this, "Calories: " + (FirstPage.calories - FirstPage.weWant) + "(You must eat)", Toast.LENGTH_SHORT).show();

        } else if (FirstPage.calories > FirstPage.weWant) {
            Toast.makeText(CaloriesPage.this, "Calories: " + (FirstPage.calories - FirstPage.weWant) + "(You must do some exercises)", Toast.LENGTH_SHORT).show();
        }
        //back button
        btnReturn.setOnClickListener(e -> {
            finish();
        });


    }
}
