package com.example.workit2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Date;

/**
 * Created by panda_000 on 6/14/2017.
 */

public class SQLActivity extends AppCompatActivity {
    SQLHelper mDbHelper = new SQLHelper(this);

    protected void getData(String s1){
        Log.d("getData",s1);

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = null;
//        {
//                SQLContract.SQLEntry._ID,
//                SQLContract.SQLEntry.COLUMN_1,
//                SQLContract.SQLEntry.COLUMN_2
//        };

        // Filter results WHERE "title" = 'My Title'
        String selection = null; //SQLContract.SQLEntry.COLUMN_1 + " = ?";
        String[] selectionArgs = null; //{ "weight" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = SQLContract.SQLEntry.COLUMN_1 + " DESC";

        Cursor cursor = db.query(
                SQLContract.SQLEntry.TABLE_NAME,          // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        String[] cols = cursor.getColumnNames();
        while(cursor.moveToNext()) {
            String string = "";
            for(String col:cols) {
                string += cursor.getString(
                        cursor.getColumnIndexOrThrow(col))+" ";
            }
            Log.d("get",string);
        }
        cursor.close();
    }

    protected void putData(String s1, String[] s2){
        Log.d("putData",s1);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        /*
        TABLE_NAME = "userdata";
        COLUMN_1 = "type";
        COLUMN_2 = "value";
        COLUMN_3 = "unit";
        COLUMN_4 = "name";
        COLUMN_5 = "count";
        COLUMN_6 = "difficulty";
        COLUMN_7 = "favorite";
        COLUMN_8 = "steps";
        COLUMN_9 = "heartrate";
        COLUMN_10 = "datetime";

        activities
        weight
        steps
        heartbeat
        */

        ContentValues values = new ContentValues();
        values.put(SQLContract.SQLEntry.COLUMN_1, s1);
        switch(s1){
            case "activities":
                values.put(SQLContract.SQLEntry.COLUMN_4, s2[0]);
                values.put(SQLContract.SQLEntry.COLUMN_5, Integer.parseInt(s2[1]));
                values.put(SQLContract.SQLEntry.COLUMN_6, Double.parseDouble(s2[2]));
                values.put(SQLContract.SQLEntry.COLUMN_7, Boolean.parseBoolean(s2[3]));
                break;
            case "weight":
                values.put(SQLContract.SQLEntry.COLUMN_2, Integer.parseInt(s2[0]));
                values.put(SQLContract.SQLEntry.COLUMN_3, s2[1]);
                break;
            case "steps":
                values.put(SQLContract.SQLEntry.COLUMN_8, Integer.parseInt(s2[0]));;
                break;
            case "heartrate":
                Log.d("heartrate parse",s2[0]);
                values.put(SQLContract.SQLEntry.COLUMN_9, Integer.parseInt(s2[0]));
                break;
        }
        values.put(SQLContract.SQLEntry.COLUMN_10,new Date().toString());
        Log.d("put date",new Date().toString());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(SQLContract.SQLEntry.TABLE_NAME, null, values);
        Log.d("putData ID",newRowId+"");
    }

    protected void setErrorMessage(String s1){
        Log.d("setErrorMessage",s1);
    }
}
