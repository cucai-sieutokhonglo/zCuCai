package com.example.zcucai.adapter_view_day6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zcucai.MainActivity;
import com.example.zcucai.R;
import com.example.zcucai.broadcast_receiver_notification.Day5BroadcastReceiverMainActivity;
import com.example.zcucai.fragment_activity.Day3IntentLayoutActivity;
import com.example.zcucai.fragment_activity.FragmentExampleActivity;
import com.example.zcucai.fragment_activity.SecondActivity;

public class Day6MainActivity extends AppCompatActivity {
    Button btnAddItem, btnAddItem2;
    EditText edtNewItem;
    ListView lvLesson;

    String[] stringData = {
            "Activity - Fragent",
            "BroadcastReceiver -  Notification",
            "Adapter",
            "Service"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6_main);
        init();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, stringData);
        lvLesson.setAdapter(stringArrayAdapter);

        lvLesson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0: //activity fragment
                        intent = new Intent(Day6MainActivity.this, Day3IntentLayoutActivity.class);
                        break;
                    case 1: //broadcast - notification
                        intent = new Intent(Day6MainActivity.this, Day5BroadcastReceiverMainActivity.class);
                        break;
                    case 2: //adapter
                        intent =  new Intent(Day6MainActivity.this, SecondActivity.class);
                        break;
                    case 3: //service
                        break;
                    default:
                        //throw new IllegalStateException("Unexpected value: " + position);
                }
                if(intent != null)
                    startActivity(intent);
            }
        });
    }

    private void init() {
        btnAddItem = findViewById(R.id.btn_new_item);
        btnAddItem2 = findViewById(R.id.btn_new_item2);
        edtNewItem = findViewById(R.id.edt_new_item);
        lvLesson = findViewById(R.id.lv_lesson);
    }


    public void addNewItem(View view) {
        startActivity(new Intent(this, Day6AdapterExampleActivity.class));
    }

    public void addNewItem2(View view) {
        startActivity(new Intent(this, Day6CustomeAdapterActivity.class));
    }
}