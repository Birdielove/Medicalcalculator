package com.Love.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StoreWeigth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_weigth);

        TextView PateintWeigght = findViewById(R.id.textView2);
        PateintWeigght.setText(getIntent().getStringExtra("Result"));

    }
}
