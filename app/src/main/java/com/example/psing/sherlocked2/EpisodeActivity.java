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
    public static String a;
    EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode);
        SeasonActivity.mHelper=new TaskDbHelper(this);
        mTaskListViewEp=(ListView)findViewById(R.id.list_todo);
        updateUI();
        mTaskListViewEp.setOnItemClickListener((AdapterView.OnItemClickListener) new ListClickHandler());


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
    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            TextView listText = (TextView) view.findViewById(R.id.task_title);
            pos=position;
            a=listText.getText().toString();
            Intent registerIntent=new Intent(EpisodeActivity.this,DetailsActivity.class);
            EpisodeActivity.this.startActivity(registerIntent);
        }

    }


}
