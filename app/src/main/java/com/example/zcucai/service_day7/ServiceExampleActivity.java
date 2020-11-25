package com.example.zcucai.service_day7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zcucai.R;

public class ServiceExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);
    }


    public void createService(View view) {
        Intent intent = new Intent(this, MusicPlayerService.class);
        startService(intent);
    }

    public void onBindService(View view) {
    }
}