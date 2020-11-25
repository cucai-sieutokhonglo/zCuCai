package com.example.zcucai.fragment_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zcucai.MainActivity;
import com.example.zcucai.R;

public class Day3IntentLayoutActivity extends AppCompatActivity {

    TextView textViewDay3;
    ImageView imgView;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_intent_layout);

        textViewDay3 = findViewById(R.id.tv_day3);
        textViewDay3.setSelected(true);

        imgView = findViewById(R.id.img_day3_bt);
//        int i = 1;
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    imgView.setImageResource(R.drawable.ic_baseline_flight_24);
                    i = 2;
                } else {
                    imgView.setImageResource(R.drawable.ic_baseline_bluetooth_searching_24);
                    i = 1;
                }
            }
        });

    }

    public void startMainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void learnLayout(View view) {
        startActivity(new Intent(this, LearnLayoutDay3Activity.class));
    }
}