package com.example.psing.sherlocked2;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EpisodeActivity extends AppCompatActivity {
    private ListView mTaskListViewEp;
    private ArrayAdapter<String> mAdapterEp;
    public static int pos;
    EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode);
        SeasonActivity.mHelper=new TaskDbHelper(this);
        mTaskListViewEp=(ListView)findViewById(R.id.list_todo);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        adds1e1();
        adds1e2();
        adds1e3();
        adds2e1();
        adds2e2();
        adds2e3();
        adds3e1();
        adds3e2();
        adds3e3();
        updateUI();
        mTaskListViewEp.setOnItemClickListener((AdapterView.OnItemClickListener) new ListClickHandler1());


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                final EditText taskEditText = new EditText(this);

                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add a new task")
                        .setMessage("What do you want to do next?")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());
                                SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
                                values.put(TaskContract.TaskEntry.COL_TASK_Duration, et1.getText().toString());
                                values.put(TaskContract.TaskEntry.COL_Rating, et2.getText().toString());
                                values.put(TaskContract.TaskEntry.COL_TASK_Summary, et3.getText().toString());

                                if(SeasonActivity.Item==0){
                                    db.insertWithOnConflict(TaskContract.TaskEntry.TABLE1,
                                            null,
                                            values,
                                            SQLiteDatabase.CONFLICT_REPLACE);
                                }
                                else{
                                    if(SeasonActivity.Item==1){
                                        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE2,
                                                null,
                                                values,
                                                SQLiteDatabase.CONFLICT_REPLACE);
                                    }
                                    else{
                                        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE3,
                                                null,
                                                values,
                                                SQLiteDatabase.CONFLICT_REPLACE);
                                    }
                                }
                                db.close();
                                updateUI();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = SeasonActivity.mHelper.getReadableDatabase();
        Cursor cursor;
        if(SeasonActivity.Item==0){
                    cursor = db.query(TaskContract.TaskEntry.TABLE1,
                    new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE},
                    null, null, null, null, null);
        }
        else{
            if(SeasonActivity.Item==1)
            {
                    cursor = db.query(TaskContract.TaskEntry.TABLE2,
                    new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE},
                    null, null, null, null, null);
            }
            else{
                        cursor = db.query(TaskContract.TaskEntry.TABLE3,
                        new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE},
                        null, null, null, null, null);
            }

        }
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
            taskList.add(cursor.getString(idx));
        }

        if (mAdapterEp == null) {
            mAdapterEp = new ArrayAdapter<>(this,
                    R.layout.item_todo,
                    R.id.task_title,
                    taskList);
            mTaskListViewEp.setAdapter(mAdapterEp);
        } else {
            mAdapterEp.clear();
            mAdapterEp.addAll(taskList);
            mAdapterEp.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }
    public class ListClickHandler1 implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            TextView listText = (TextView) view.findViewById(R.id.task_title);
            pos=position;
            Intent registerIntent=new Intent(EpisodeActivity.this,DetailsActivity.class);
            EpisodeActivity.this.startActivity(registerIntent);
        }

    }
    public void adds1e1(){
        String task ="E1. A Study In Pink";
        String duration="1hr 28min";
        String rating="9.1/10";
        String Summary="War vet Dr. John Watson returns to London in need of a place to stay. He meets Sherlock Holmes, a consulting detective, and the two soon find themselves digging into a string of serial \"suicides.\"";
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
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
    public void adds2e1(){
        String task ="E1. A Scandal in Belgravia";
        String duration="1hr 29min";
        String rating="9.5/10";
        String Summary="Sherlock must confiscate something of importance from a mysterious woman named Irene Adler.";
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
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
    public void adds3e1(){
        String task ="E1. The Empty Hearse";
        String duration="1hr 28min";
        String rating="9.1/10";
        String Summary="Mycroft calls Sherlock back to London to investigate an underground terrorist organization.";
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE3,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }
    public void adds3e2(){
        String task ="E2. The Sign Of Three";
        String duration="1hr 26min";
        String rating="9.0/10";
        String Summary="Sherlock tries to give the perfect best man speech at John's wedding when he suddenly realizes a murder is about to take place.";
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        values.put(TaskContract.TaskEntry.COL_TASK_Duration, duration);
        values.put(TaskContract.TaskEntry.COL_Rating, rating);
        values.put(TaskContract.TaskEntry.COL_TASK_Summary, Summary);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE3,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }public void adds3e3(){
        String task ="E3. His Last Vow";
        String duration="1hr 29min";
        String rating="9.4/10";
        String Summary="Sherlock goes up against the notorious blackmailer Charles Augustus Magnussen.";
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
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
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
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
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
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
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
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
        SQLiteDatabase db = SeasonActivity.mHelper.getWritableDatabase();
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

}
