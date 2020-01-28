package com.Love.medicalcalculator;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StoreWeigth extends AppCompatActivity {
    String bundledata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_weigth);

        TextView PateintWeigght = findViewById(R.id.textView2);
        PateintWeigght.setTextSize(Dimension.SP, 24);
        Bundle myBundle = (getIntent().getExtras());
        bundledata = String.format("Output Weight = %.2f \n", myBundle.getDouble("OutputWeight"));
        //PateintWeigght.setText();
    }
}
