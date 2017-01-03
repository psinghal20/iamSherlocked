package com.example.psing.sherlocked2;

import android.provider.BaseColumns;

/**
 * Created by psing on 20-12-2016.
 */

public class TaskContract {
    public static final String DB_NAME = "com.aziflaj.todolist.db";
    public static final int DB_VERSION = 1;

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "tasks";
        public static final String TABLE1 = "season1";
        public static final String TABLE2 = "season2";
        public static final String TABLE3 = "season3";

        public static final String COL_TASK_TITLE = "title";
        public static final String COL_TASK_Duration = "duration";
        public static final String COL_Rating = "rating";
        public static final String COL_TASK_Summary = "summary";

    }
}
