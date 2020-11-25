package com.example.zcucai.service_day7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.zcucai.R;

public class MusicPlayerService extends Service {
    private static final String TAG = "SVMC" + MusicPlayerService.class.getSimpleName();
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.my_song);
        Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
//        return START_NOT_STICKY; //không cần tạo lại service
        mediaPlayer.start();
        Toast.makeText(getApplicationContext(), "onStartCommand", Toast.LENGTH_SHORT).show();
        return START_STICKY; // muốn tạo lại service nhưng có thằng input intent = null

    }

    @Override
    public void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast.makeText(getApplicationContext(), "Service stop", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
