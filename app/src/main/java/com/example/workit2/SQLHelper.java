package com.example.workit2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by panda_000 on 6/15/2017.
 */

public class SQLHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLReader.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SQLContract.SQLEntry.TABLE_NAME + " (" +
                    SQLContract.SQLEntry._ID + " INTEGER PRIMARY KEY, " +
                    SQLContract.SQLEntry.COLUMN_1 + " TEXT, " +              //type
                    SQLContract.SQLEntry.COLUMN_2 + " INTEGER, " +           //value
                    SQLContract.SQLEntry.COLUMN_3 + " TEXT, " +              //unit
                    SQLContract.SQLEntry.COLUMN_4 + " TEXT, " +              //name
                    SQLContract.SQLEntry.COLUMN_5 + " INTEGER, " +           //count
                    SQLContract.SQLEntry.COLUMN_6 + " DOUBLE PRECISION, " +  //difficulty
                    SQLContract.SQLEntry.COLUMN_7 + " BOOLEAN, " +           //favorite
                    SQLContract.SQLEntry.COLUMN_8 + " INTEGER, " +           //steps
                    SQLContract.SQLEntry.COLUMN_9 + " INTEGER, " +           //heartrate
                    SQLContract.SQLEntry.COLUMN_10 + " TEXT" +")";         //datetime

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SQLContract.SQLEntry.TABLE_NAME;

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public void dropTables(SQLiteDatabase db){
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
    }
}
