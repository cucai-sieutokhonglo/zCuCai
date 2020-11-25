package com.example.zcucai.database_day9;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.zcucai.R;
import com.example.zcucai.databinding.ActivityDay9SharedPreferenceExampleBinding;

public class Day9SharedPreferenceExampleActivity extends AppCompatActivity {
    final String IS_FIRST_KEY_RUN = "is_first_run_2";
    ActivityDay9SharedPreferenceExampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_day9_shared_preference_example);
        /**1. Read data from sharePreference
         * 1.1 Read applicaton
         * a. getDefault
         * b. getShredPreference (PREFERENCE_NAME, MODE)
         * */
        //1a. Mode default - su dung default shared Preference
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        boolean isFirstRun = sharedPreferences.getBoolean(IS_FIRST_KEY_RUN, false);
//        binding.tvMessage.setText("Is first run value = " + isFirstRun);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean(IS_FIRST_KEY_RUN , true);
//        editor.commit();

        //1b. mode application - Su dung shared Preference with preference Name
        SharedPreferences sharedPreferences = getSharedPreferences("my_preference_name", MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean(IS_FIRST_KEY_RUN, false);
        binding.tvMessage.setText("Is first run value = " + isFirstRun);
        //2. Save data
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_FIRST_KEY_RUN, true);
        editor.commit();

    }


}