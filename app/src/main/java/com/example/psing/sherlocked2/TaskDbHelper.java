package com.example.psing.sherlocked2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDbHelper extends SQLiteOpenHelper {

    public TaskDbHelper(Context context) {
        super(context, TaskContract.DB_NAME, null, TaskContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TaskContract.TaskEntry.TABLE + " ( " +
                TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
        createTable = "CREATE TABLE " + TaskContract.TaskEntry.TABLE1 + " ( " +
                TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL,duration TEXT NOT NULL,rating TEXT NOT NULL,summary TEXT NOT NULL);";
        db.execSQL(createTable);

        createTable = "CREATE TABLE " + TaskContract.TaskEntry.TABLE2 + " ( " +
                TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL,duration TEXT NOT NULL,rating TEXT NOT NULL,summary TEXT NOT NULL);";
        db.execSQL(createTable);
        createTable = "CREATE TABLE " + TaskContract.TaskEntry.TABLE3 + " ( " +
                TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL,duration TEXT NOT NULL,rating TEXT NOT NULL,summary TEXT NOT NULL);";
        db.execSQL(createTable);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE1);
        db.execSQL("DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE2);
        db.execSQL("DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE3);
        onCreate(db);
    }
    public Cursor getalldata(String tablename){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+tablename,null);
        return res;
    }
}
