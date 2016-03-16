package com.juleengraham.randomapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);

        textView.setText("hskdhkja");
        textView.setTextSize(40);
        textView.setTextColor(Color.parseColor("#060e9f"));

        setContentView(textView);
    }
}
