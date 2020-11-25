package com.example.zcucai.database_day9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zcucai.R;

public class Day9MainActivityDataBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day9_main_data_base);
    }

    public void day9SharedPreference(View view) {
        startActivity(new Intent(getApplicationContext(), Day9SharedPreferenceExampleActivity.class));
    }

    public void day9SQLiteDataBase(View view) {
        startActivity(new Intent(getApplicationContext(), Day9SQLiteDatabase.class));

    }
}