package com.example.workit2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
        String selection = null;
        String[] selectionArgs = null;

        // How you want the results sorted in the resulting Cursor
        String sortOrder = null;
//                SQLContract.SQLEntry.COLUMN_2 + " DESC";

        Cursor cursor = db.query(
                SQLContract.SQLEntry.TABLE_NAME,          // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        while(cursor.moveToNext()) {
            String string = cursor.getString(
                    cursor.getColumnIndexOrThrow(SQLContract.SQLEntry.COLUMN_2));
            Log.d("get",string);
        }
        cursor.close();
    }

    protected void putData(String s1, String[] s2){
        Log.d("putData",s1+" "+s2.toString());

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
        */

        ContentValues values = new ContentValues();
        values.put(SQLContract.SQLEntry.COLUMN_1, s1);
        values.put(SQLContract.SQLEntry.COLUMN_2, s2);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(SQLContract.SQLEntry.TABLE_NAME, null, values);
        Log.d("putData ID",newRowId+"");
    }

    protected void setErrorMessage(String s1){
        Log.d("setErrorMessage",s1);
    }
}
