package com.example.workit2;

import android.provider.BaseColumns;

/**
 * Created by panda_000 on 6/15/2017.
 */

public class SQLContract {
    private SQLContract(){}

    public static class SQLEntry implements BaseColumns {
        public static final String TABLE_NAME = "userdata";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
