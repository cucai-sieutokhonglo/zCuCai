package com.example.zcucai.broadcast_receiver_notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.zcucai.MainActivity;
import com.example.zcucai.R;

public class Day5BroadcastReceiverMainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver1 = new MyBroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("zCuCai", "BroadcastReceiver1: " + intent.getAction());
//            abortBroadcast();
//            Bundle bundle = new Bundle();
//            bundle.putString("Test", "Hello Broadcast 2");
//            setResultExtras(bundle);
        }
    };
    BroadcastReceiver broadcastReceiver2 = new MyBroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("zCuCai", "BroadcastReceiver2: " + intent.getAction());
            Bundle bundle = getResultExtras(false);
            String sBundle = bundle.getString("Test", "NULL");
            Toast.makeText(context, sBundle, Toast.LENGTH_SHORT).show();
//            super.onReceive(context, intent);
        }
    };


    public void init() {
        IntentFilter filter1, filter2;
        filter1 = new IntentFilter();
        filter1.addAction("com.zcucai.tool.TEST_ACTION2");
//        filter1.setPriority(2);
//        registerReceiver(broadcastReceiver1, filter1);
//--------------------------------------------------
        filter2 = new IntentFilter();
        filter2.addAction("com.zcucai.tool.TEST_ACTION2");
//        filter2.setPriority(1);
        registerReceiver(broadcastReceiver2, filter2);

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver1, filter1);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5_broadcast_receiver);

        init();

    }

    @Override
    protected void onDestroy() {
//        unregisterReceiver(broadcastReceiver1);
//        unregisterReceiver(broadcastReceiver2);
//
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver1);
        super.onDestroy();
    }

    public void sendSampleBroadcast(View view) {
        Intent intent = new Intent("com.zcucai.tool.TEST_ACTION2");
//        sendOrderedBroadcast(intent, null);

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }



    private void initNotification() {

        //SETUP channel
        String channelID = "zCuCai_notification_chanel_ID";
        String channelName = "zCuCai_notification_channel_Name";
        int notificationID = 69;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channelID,
                    channelName, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setShowBadge(true);
            notificationChannel.setDescription("This notification display to keep application running on background");
            notificationChannel.setLockscreenVisibility(-1);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        //setup notification builder

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(Day5BroadcastReceiverMainActivity.this, channelID);
        notificationBuilder.setContentTitle("Content Title");
        notificationBuilder.setSmallIcon(R.drawable.ic_baseline_fingerprint_24);
        notificationBuilder.setContentText("Content Text");
        notificationBuilder.setTicker("Notification Ticker");
        notificationBuilder.setPriority(NotificationCompat.PRIORITY_MAX);
        notificationBuilder.setColor(Color.RED);



        //setup pending Intent
        Intent intent = new Intent(Day5BroadcastReceiverMainActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("bundle_key", "bundle_values_data");
        intent.putExtras(bundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(Day5BroadcastReceiverMainActivity.this,0 , intent, 0);
        notificationBuilder.setContentIntent(pendingIntent);

//        NotificationCompat.Action action = new NotificationCompat.Action(0, "Click here", pendingIntent);
//        notificationBuilder.addAction(action);

        //setup notice
        Notification notification = notificationBuilder.build();
        notificationManager.notify(notificationID, notification);
        
        notificationBuilder.setAutoCancel(true);

    }

    public void showNotification(View view) {
        initNotification();
    }
}