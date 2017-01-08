package com.example.psing.sherlocked2;

import android.content.ContentValues;
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
        createTable = "CREATE TABLE " + TaskContract.TaskEntry.TABLE4 + " ( " +
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
    public void addseason1(){
        String task="Season 1(2010)";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
    public void addseason2(){
        String task="Season 2(2012)";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
    public void addseason3(){
        String task="Season 3(2014)";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
    public void addseason4(){
        String task="Season 4(2017)";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void adds1e1(){
        String task ="E1. A Study In Pink";
        String duration="1hr 28min";
        String rating="9.1/10";
        String Summary="War vet Dr. John Watson returns to London in need of a place to stay. He meets Sherlock Holmes, a consulting detective, and the two soon find themselves digging into a string of serial \"suicides.\"";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insert(TaskContract.TaskEntry.TABLE1,null,values);
    }
    public void adds2e1(){
        String task ="E1. A Scandal in Belgravia";
        String duration="1hr 29min";
        String rating="9.5/10";
        String Summary="Sherlock must confiscate something of importance from a mysterious woman named Irene Adler.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insert(TaskContract.TaskEntry.TABLE2,null,values);
    }
    public void adds3e1(){
        String task ="E1. The Empty Hearse";
        String duration="1hr 28min";
        String rating="9.1/10";
        String Summary="Mycroft calls Sherlock back to London to investigate an underground terrorist organization.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insert(TaskContract.TaskEntry.TABLE3,null,values);
    }
    public void adds3e2(){
        String task ="E2. The Sign Of Three";
        String duration="1hr 26min";
        String rating="9.0/10";
        String Summary="Sherlock tries to give the perfect best man speech at John's wedding when he suddenly realizes a murder is about to take place.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insert(TaskContract.TaskEntry.TABLE3,null,values);
    }
    public void adds3e3(){
        String task ="E3. His Last Vow";
        String duration="1hr 29min";
        String rating="9.4/10";
        String Summary="Sherlock goes up against the notorious blackmailer Charles Augustus Magnussen.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE3,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }public void adds1e2(){
        String task ="E2. The Blind Banker";
        String duration="1hr 29min";
        String rating="8.1/10";
        String Summary="Mysterious symbols and murders are showing up all over London, leading Sherlock and John to a secret Chinese crime syndicate called Black Lotus.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE1,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }public void adds1e3(){
        String task ="E3. The Great Game";
        String duration="1hr 29min";
        String rating="9.1/10";
        String Summary="Mycroft needs Sherlock's help, but a remorseless criminal mastermind puts Sherlock on a distracting crime-solving spree via a series of hostage human bombs through which he speaks.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE1,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }
    public void adds2e2(){
        String task ="E2. The Hound Of Baskerville";
        String duration="1hr 28min";
        String rating="8.5/10";
        String Summary="Sherlock and John investigate the ghosts of a young man who has been seeing monstrous hounds out in the woods where his father died.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE2,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }
    public void adds2e3(){
        String task ="E3. The Reichenbach Fall";
        String duration="1hr 28min";
        String rating="9.7/10";
        String Summary="Jim Moriarty hatches a mad scheme to turn the whole city against Sherlock.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE2,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }
    public void adds4e1(){
        String task ="E1. The Six Thatchers";
        String duration="1hr 28min";
        String rating="8.0/10";
        String Summary="As Sherlock waits to see Moriarty's next move, he takes on the case of finding someone who is going around and smashing six unique head statues of Margaret Thatcher.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE4,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }
    public void adds4e2(){
        String task ="E2. The Lying Detective";
        String duration="1hr 28min";
        String rating="9.5/10";
        String Summary="Sherlock faces one of the most chilling enemies of his long career: the powerful and seemingly unassailable Culverton Smith - a man with a very dark secret indeed.";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE4,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }
    public void adds4e3(){
        String task ="E3. The Final Problem";
        String duration="1hr 28min";
        String rating="9.5/10";
        String Summary="Sherlock travels to Europe to escape Moriarty's vengeance.\n";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE4,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }

    public void deletedata(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TaskContract.TaskEntry.TABLE);
        db.execSQL("delete from "+ TaskContract.TaskEntry.TABLE1);
        db.execSQL("delete from "+ TaskContract.TaskEntry.TABLE2);
        db.execSQL("delete from "+ TaskContract.TaskEntry.TABLE3);
        db.execSQL("delete from "+ TaskContract.TaskEntry.TABLE4);

    }
}
