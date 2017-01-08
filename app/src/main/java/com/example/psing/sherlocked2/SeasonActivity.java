package com.example.psing.sherlocked2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeasonActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static TaskDbHelper mHelper;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;
    public static int Item;
    public static int pos;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season1);
        mHelper=new TaskDbHelper(this);
        mHelper.deletedata();
        mHelper.addseason1();
        mHelper.addseason2();
        mHelper.addseason3();
        mHelper.addseason4();
        mHelper.adds1e1();
        mHelper.adds1e2();
        mHelper.adds1e3();
        mHelper.adds2e1();
        mHelper.adds2e2();
        mHelper.adds2e3();
        mHelper.adds3e1();
        mHelper.adds3e2();
        mHelper.adds3e3();
        mHelper.adds4e1();
        mHelper.adds4e2();
        mHelper.adds4e3();
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Item=groupPosition;
                pos=childPosition;
                Intent registerIntent=new Intent(SeasonActivity.this,DetailsActivity.class);
                SeasonActivity.this.startActivity(registerIntent);
                return true;
            }
        });

        }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        Cursor res=mHelper.getalldata(TaskContract.TaskEntry.TABLE);
        while(res.moveToNext()) {
            listDataHeader.add(res.getString(1));
            }
        res=mHelper.getalldata(TaskContract.TaskEntry.TABLE1);
        List<String> season1 = new ArrayList<String>();
        while(res.moveToNext()) {
            season1.add(res.getString(1));
        }
        res=mHelper.getalldata(TaskContract.TaskEntry.TABLE2);
        List<String> season2 = new ArrayList<String>();
        while(res.moveToNext()) {
            season2.add(res.getString(1));
         }
        res=mHelper.getalldata(TaskContract.TaskEntry.TABLE3);
        List<String> season3 = new ArrayList<String>();
        while(res.moveToNext()) {
            season3.add(res.getString(1));
         }
        res=mHelper.getalldata(TaskContract.TaskEntry.TABLE4);
        List<String> season4 = new ArrayList<String>();
        while(res.moveToNext()) {
            season4.add(res.getString(1));
        }
        listDataChild.put(listDataHeader.get(0), season1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), season2);
        listDataChild.put(listDataHeader.get(2), season3);
        listDataChild.put(listDataHeader.get(3), season4);
    }

}
