package com.example.zcucai.database_day9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zcucai.adapter_view_day6.MySong;

import java.util.ArrayList;

/**
 * Quản lý truy cập cho database
 * Insert / Update / Query/ Delete
 */
public class MyAppDataBase {
    SQLiteDatabase mySQLiteDatabase;

    public MyAppDataBase(Context context) {
        SQLiteOpenHelper songSQLiteOpenHelper = new SongSQLiteOpenHelper(context,
                null, null, 1);
        mySQLiteDatabase = songSQLiteOpenHelper.getWritableDatabase();

    }

    public ArrayList<MySong> getData() {
        ArrayList<MySong> songRet = new ArrayList<MySong>();
        Cursor cursor = mySQLiteDatabase.query(SongSQLiteOpenHelper.SONG_TABLE, null,
                null, null, null, null, null);

        while (cursor.moveToNext()) {
            int imgCover = cursor.getInt(cursor.getColumnIndex(SongSQLiteOpenHelper.IMG_COVER));
            String songName = cursor.getString(cursor.getColumnIndex(SongSQLiteOpenHelper.SONG_NAME));
            String artist = cursor.getString(cursor.getColumnIndex(SongSQLiteOpenHelper.ARTIST));
            songRet.add(new MySong(imgCover, songName, artist));
        }
        return songRet;

    }

    public void insert(MySong song) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SongSQLiteOpenHelper.IMG_COVER, song.getResourceID());
        contentValues.put(SongSQLiteOpenHelper.SONG_NAME, song.getName());
        contentValues.put(SongSQLiteOpenHelper.ARTIST, song.getAuthor());
        mySQLiteDatabase.insert(SongSQLiteOpenHelper.SONG_TABLE, null, contentValues);

    }
}
