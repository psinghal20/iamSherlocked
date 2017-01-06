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
import android.widget.Toast;

import java.util.ArrayList;

public class SeasonActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static TaskDbHelper mHelper;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;
    public static int Item;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season);
        mHelper=new TaskDbHelper(this);
        mTaskListView=(ListView)findViewById(R.id.list_todo);
        mHelper.deletedata();
        mHelper.addseason1();
        mHelper.addseason2();
        mHelper.addseason3();
        mHelper.adds1e1();
        mHelper.adds1e2();
        mHelper.adds1e3();
        mHelper.adds2e1();
        mHelper.adds2e2();
        mHelper.adds2e3();
        mHelper.adds3e1();
        mHelper.adds3e2();
        mHelper.adds3e3();
        updateUI();
        mTaskListView.setOnItemClickListener((AdapterView.OnItemClickListener) new ListClickHandler());
    }

    private void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
            taskList.add(cursor.getString(idx));
        }

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_todo,
                    R.id.task_title,
                    taskList);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }

    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            TextView listText = (TextView) view.findViewById(R.id.task_title);
            listText.getText();
            Item = position;
            Intent registerIntent=new Intent(SeasonActivity.this,EpisodeActivity.class);
            SeasonActivity.this.startActivity(registerIntent);
        }

    }


}
