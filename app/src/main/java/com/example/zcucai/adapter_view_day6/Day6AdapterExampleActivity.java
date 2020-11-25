package com.example.zcucai.adapter_view_day6;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.zcucai.R;
import com.example.zcucai.databinding.ActivityDay6AdapterExampleBinding;

public class Day6AdapterExampleActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityDay6AdapterExampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_day6_adapter_example);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_day6_adapter_example);
        binding.tvDay6Information.setText("I modifided the text");
        binding.setClickHandler(this);

//check contact permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS,
                    Manifest.permission.WRITE_CONTACTS}, 100);
        } else
            loadContactInfo();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                loadContactInfo();
            }
            else {
                Toast.makeText(this, "Failed to read contacts", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void loadContactInfo() {
        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null, null);

        SimpleCursorAdapter simpleCursorAdapter =
                new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor,
                        new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                                ContactsContract.CommonDataKinds.Phone.NUMBER},
                        new int[]{android.R.id.text1, android.R.id.text2},
                        CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        binding.lvContact.setAdapter(simpleCursorAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_day6_button1:
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_day6_button2:
                Toast.makeText(this, "Button 2 clicked", Toast.LENGTH_SHORT).show();
        }
    }
}