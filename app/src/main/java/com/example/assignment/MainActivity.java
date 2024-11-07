package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

//The first interface that appears in the program, through which we enter the necessary information before logging in.
public class MainActivity extends AppCompatActivity {
    private Button btnGo;
    private EditText edtHeight, edtWeight, edtAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtAge = findViewById(R.id.edtAge);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(e -> {
            Intent FirstIntent = new Intent(MainActivity.this, FirstPage.class);
            double[] arr = {Double.valueOf(edtAge.getText().toString()), Double.valueOf(edtHeight.getText().toString()), Double.valueOf(edtWeight.getText().toString())};
//Conditions to which entries must adhere
            if (arr[0] > 0 && arr[0] <= 130 && arr[1] > 0 && arr[2] > 0 && arr[1] <= 3 && arr[2] < 300) {
                FirstIntent.putExtra("arr", arr);
                startActivity(FirstIntent);
            } else {
                Toast.makeText(MainActivity.this, "wrong input!", Toast.LENGTH_SHORT).show();
            }
        });
        //To ensure that you do not enter before filling in the information
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                checkFields();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        // Set TextWatchers on each EditText

        edtAge.addTextChangedListener(textWatcher);
        edtHeight.addTextChangedListener(textWatcher);
        edtWeight.addTextChangedListener(textWatcher);
    }

    // Method to check if all EditTexts are filled
    private void checkFields() {
        if (
                !edtAge.getText().toString().isEmpty() &&
                        !edtHeight.getText().toString().isEmpty() &&
                        !edtWeight.getText().toString().isEmpty()) {

            btnGo.setAlpha(1f);
            btnGo.setClickable(true);
        } else {
            btnGo.setAlpha(0.5f);
            btnGo.setClickable(false);
        }
    }
}