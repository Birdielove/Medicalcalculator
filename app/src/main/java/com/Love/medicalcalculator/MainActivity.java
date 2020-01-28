package com.Love.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double value;
    double result;
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

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toPound.isChecked()) {
                    value = Double.parseDouble(String.valueOf(userValue.getText()));
                    result = value * 2.20462;
                    Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
                    Intent passingWeight = new Intent(MainActivity.this, StoreWeigth.class);
                    passingWeight.putExtra("Result", String.valueOf(result));
                    startActivity(passingWeight);
                }
                else if(toKilo.isChecked()){
                    value = Double.parseDouble(String.valueOf(userValue.getText()));
                    result = value * 0.4535918;
                    Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
                }
                else if(!(toKilo.isChecked() && toPound.isChecked())){
                    Toast.makeText(MainActivity.this, "Please check the type first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
