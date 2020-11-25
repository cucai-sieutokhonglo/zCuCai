package com.example.zcucai.fragment_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zcucai.R;

public class SecondActivity extends AppCompatActivity {

    TextView tvWelcome;
    Button btnOK, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String sName = intent.getStringExtra("username");
        tvWelcome = findViewById(R.id.tv_wellcome);
        tvWelcome.setText(sName);

        btnOK = findViewById(R.id.btn_OK);
        btnCancel = findViewById(R.id.btn_cancel);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultMessage  = "You are welcome";
                Intent resultIntentOK =  new Intent();
                resultIntentOK.putExtra("result_message", resultMessage);
                setResult(Activity.RESULT_OK, resultIntentOK);
                finish();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultMessage  = "You are false";
                Intent resultIntentOK =  new Intent();
                resultIntentOK.putExtra("result_message", resultMessage);
                setResult(Activity.RESULT_CANCELED, resultIntentOK);
                finish();
            }
        });
    }
}