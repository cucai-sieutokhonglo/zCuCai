package com.example.zcucai.database_day9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SongSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String SONG_TABLE = "song";
    public static final String ID = "id";
    public static final String IMG_COVER = "IMG_COVER";
    public static final String SONG_NAME = "SONG_NAME";
    public static final String ARTIST = "ARTIST";
    private static final String DATABASE_NAME = "song_database";
    public static final String TAG = "zCUCAI SVMC: SQLite";
    private static int DATABASE_VERSION = 1;

    //Create Database name and version
    public SongSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create database table
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create song(id integer primary key autoincrement,
        //IMG_Cover TEXT, SONG_NAME TEXT, ARTIST TEXT);
        String create_SQL = String.format("Create %s (%s integer primary key autoincrement- " +
                "%s TEXT, " +
                "%s TEXT," +
                "%s TEXT);", SONG_TABLE, ID, IMG_COVER, SONG_NAME, ARTIST);
        Log.d(TAG, "create_SQL = " + create_SQL);
        db.execSQL(create_SQL);
    }
    //update database when database version is upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = String.format("drop table if exist %s", SONG_TABLE);
        Log.d(TAG, "deleteTable = " + deleteTable);
        db.execSQL(deleteTable);
        onCreate(db);
    }
}
