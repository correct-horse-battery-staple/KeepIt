package com.example.workit2;

import android.provider.BaseColumns;

/**
 * Created by panda_000 on 6/15/2017.
 */

public class SQLContract {
    private SQLContract(){}

    public static class SQLEntry implements BaseColumns {
        public static final String TABLE_NAME = "userdata";
        public static final String COLUMN_1 = "type";
        public static final String COLUMN_2 = "value";
        public static final String COLUMN_3 = "unit";
        public static final String COLUMN_4 = "name";
        public static final String COLUMN_5 = "count";
        public static final String COLUMN_6 = "difficulty";
        public static final String COLUMN_7 = "favorite";
        public static final String COLUMN_8 = "steps";
        public static final String COLUMN_9 = "heartrate";
        public static final String COLUMN_10 = "datetime";


    }
}
