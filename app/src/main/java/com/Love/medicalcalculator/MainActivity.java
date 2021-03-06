package com.Love.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    double value;
    double result;
    String inputUnit;
    String outputUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.medical);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final Button calculate = findViewById(R.id.button);
        final EditText userValue = findViewById(R.id.editText);
        final RadioButton toKilo = findViewById(R.id.radioButton4);
        final RadioButton toPound = findViewById(R.id.radioButton3);
        final ImageView img = findViewById(R.id.imageView);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userValue.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter the weight first!", Toast.LENGTH_SHORT).show();
                } else {
                    if (toPound.isChecked()) {
                        value = Double.parseDouble(String.valueOf(userValue.getText()));
                        if (value > 500) {
                            Toast.makeText(MainActivity.this, "Weight limit exceeded", Toast.LENGTH_SHORT).show();
                            Picasso.get().load("https://i.pinimg.com/236x/28/ac/25/28ac2516b5a09c734f6dc49e77bfe826.jpg").into(img);
                            Picasso.get().setLoggingEnabled(true);
                        } else {
                            result = value * 2.20462;
                            Toast.makeText(MainActivity.this, String.valueOf(String.format("Weight = %.2f Kgs", result)), Toast.LENGTH_SHORT).show();
                            inputUnit = "Lbs";
                            outputUnit = "Kgs";
                            Intent passingWeight = new Intent(MainActivity.this, StoreWeigth.class);
                            Bundle myBundle = new Bundle();
                            myBundle.putDouble( "InputWeight" ,value);
                            myBundle.putDouble( "OutputWeight" ,result);
                            passingWeight.putExtras(myBundle);
                            startActivity(passingWeight);
                        }
                    } else if (toKilo.isChecked()) {
                        if (value > 1000) {
                            Toast.makeText(MainActivity.this, "Weight limit exceeded", Toast.LENGTH_SHORT).show();
                            Picasso.get().load("https://i.pinimg.com/236x/28/ac/25/28ac2516b5a09c734f6dc49e77bfe826.jpg").into(img);
                            Picasso.get().setLoggingEnabled(true);
                        } else {
                            value = Double.parseDouble(String.valueOf(userValue.getText()));
                            result = value * 0.4535918;
                            Toast.makeText(MainActivity.this, String.valueOf(String.format("Weight = %.2f Kgs", result)), Toast.LENGTH_SHORT).show();
                        }
                    } else if (!(toKilo.isChecked() && toPound.isChecked())) {
                        Toast.makeText(MainActivity.this, "Please check the type first!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
