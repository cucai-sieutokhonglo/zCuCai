package com.example.zcucai.broadcast_receiver_notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String sReceive = intent.getAction().toString();
        Log.d("zCuCai tt", sReceive + " MyBroadcastReceiver");
        Toast.makeText(context, sReceive, Toast.LENGTH_SHORT).show();
    }
}
