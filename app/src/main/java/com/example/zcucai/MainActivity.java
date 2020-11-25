package com.example.zcucai;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zcucai.adapter_view_day6.Day6MainActivity;
import com.example.zcucai.broadcast_receiver_notification.Day5BroadcastReceiverMainActivity;
import com.example.zcucai.database_day9.Day9MainActivityDataBase;
import com.example.zcucai.fragment_activity.Day3IntentLayoutActivity;
import com.example.zcucai.fragment_activity.FragmentExampleActivity;
import com.example.zcucai.fragment_activity.SecondActivity;
import com.example.zcucai.service_day7.Day7ServiceMainActivity;
import com.example.zcucai.testSettingsScreen.SettingsActivity;
import com.example.zcucai.thread_handler_asynctask_day8.Day8ThreadHandlerAsyncTaskMainActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtName;
    Button btnActivity, btnActivity2, btnFragment, btnCuCaiTool;
    Button btnDay3IntentLayout;
    Button btnDay5BroadcastReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCom();
        addFunc();
    }
    private void addCom() {
        edtName = findViewById(R.id.edt_name);
        btnActivity = findViewById(R.id.btn_start_other_activity);
        btnActivity2 = findViewById(R.id.btn_start_activity_result);
        btnFragment = findViewById(R.id.btn_start_fragment);
        btnCuCaiTool = findViewById(R.id.btn_cucai_tool);
        btnDay3IntentLayout = findViewById(R.id.btn_day3_intent_layout);
        btnDay5BroadcastReceiver = findViewById(R.id.btn_day5_broadcast_receiver);
    }

    private void addFunc() {
        btnDay5BroadcastReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Day5BroadcastReceiverMainActivity.class));
            }
        });
        btnActivity.setOnClickListener(new View.OnClickListener() {
            Context appContext = getApplicationContext();

            @Override
            public void onClick(View v) {
                String sName = edtName.getText().toString();
                if (sName.isEmpty()) sName = "Phung Duc Vu";
                Intent intent = new Intent(appContext, SecondActivity.class);
                intent.putExtra("username", sName);
                startActivity(intent);
            }
        });

        btnActivity2.setOnClickListener(new View.OnClickListener() {

            Context appContext = getApplicationContext();

            @Override
            public void onClick(View v) {
                String sName = edtName.getText().toString();
                if (sName.isEmpty()) sName = "Phung Duc Vu";
                Intent intent = new Intent(appContext, SecondActivity.class);
                intent.putExtra("username", sName);
                startActivityForResult(intent, 100);
            }
        });

        btnFragment.setOnClickListener(new View.OnClickListener() {
            Context appContext = getApplicationContext();

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext, FragmentExampleActivity.class);
                startActivity(intent);
            }
        });

        btnDay3IntentLayout.setOnClickListener(new View.OnClickListener() {
            Context appContext = getApplicationContext();

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext, Day3IntentLayoutActivity.class);
                startActivity(intent);

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Result message: " + data.getStringExtra("result_message"), Toast.LENGTH_SHORT).show();
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Result Message : " + data.getStringExtra("result_message"), Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void day6AdapterViewActivity(View view) {
        startActivity(new Intent(MainActivity.this, Day6MainActivity.class));
    }

    public void day7ServiceActivityStart(View view) {
        startActivity(new Intent(MainActivity.this, Day7ServiceMainActivity.class));
    }

    public void day8ThreadHandlerAsyncTask(View view) {
        startActivity(new Intent(MainActivity.this, Day8ThreadHandlerAsyncTaskMainActivity.class));
    }

    public void day9DataBase(View view) {
        startActivity(new Intent(MainActivity.this, Day9MainActivityDataBase.class));
    }

    public void settingScreen(View view) {
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));

    }
}