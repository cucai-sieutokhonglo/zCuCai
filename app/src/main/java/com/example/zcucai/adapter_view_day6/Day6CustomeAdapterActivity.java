package com.example.zcucai.adapter_view_day6;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zcucai.R;
import com.example.zcucai.database_day9.MyAppDataBase;

import java.util.ArrayList;

public class Day6CustomeAdapterActivity extends AppCompatActivity {

    ArrayList<MySong> mySongs;
    CustomAdapter customAdapter;
    ListView listView;
    MyAppDataBase myAppDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6_custome_adapter);
        prepareData();
        listView = findViewById(R.id.listView);
        customAdapter = new CustomAdapter(this, R.layout.mysong_item, mySongs);
        listView.setAdapter(customAdapter);
        myAppDataBase = new MyAppDataBase(getApplicationContext());
    }

    private void prepareData() {
        mySongs = new ArrayList<MySong>();
//        MySong mySong = new MySong(R.drawable.singer, "Someone Like You", "Adele");
//
//        MySong mySong1 = new MySong(R.drawable.singer1, "Space Bound", "Mr Hell");
//        MySong mySong2 = new MySong(R.drawable.singer2, "Stranger from Hell", "Maria Clone");
//        MySong mySong3 = new MySong(R.drawable.singer3, "Love the way you lie", "Rhiana");
//        MySong mySong4 = new MySong(R.drawable.singer4, "Khwaja Mere Khwaija", "Kumar");
//        MySong mySong5 = new MySong(R.drawable.singer2, "Stranger from Hell", "Maria Clone");
//        MySong mySong6 = new MySong(R.drawable.singer3, "Love the way you lie", "Rhiana");
//        MySong mySong7 = new MySong(R.drawable.singer4, "Khwaja Mere Khwaija", "Kumar");
//        MySong mySong8 = new MySong(R.drawable.singer2, "Stranger from Hell", "Maria Clone");
//        MySong mySong9 = new MySong(R.drawable.singer3, "Love the way you lie", "Rhiana");
//        MySong mySong10 = new MySong(R.drawable.singer4, "Khwaja Mere Khwaija", "Kumar");
//        mySongs.add(mySong);
//        mySongs.add(mySong1);
//        mySongs.add(mySong2);
//        mySongs.add(mySong3);
//        mySongs.add(mySong4);
//        mySongs.add(mySong5);
//        mySongs.add(mySong6);
//        mySongs.add(mySong7);
//        mySongs.add(mySong8);
//        mySongs.add(mySong9);
//        mySongs.add(mySong10);


        mySongs.addAll(myAppDataBase.getData());


    }
}