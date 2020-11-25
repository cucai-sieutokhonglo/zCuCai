package com.example.zcucai.service_day7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.zcucai.R;

public class Day7ServiceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day7_service_main);
    }
    public void musicExampleService(View view) {
        startActivity(new Intent(this, ServiceExampleActivity.class));
    }
}