package com.example.psing.sherlocked2;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    ImageButton imageButton;
    RelativeLayout mrelativelayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t2 = (TextView) findViewById(R.id.textView10);
        t3 = (TextView) findViewById(R.id.textView11);
        t4 = (TextView) findViewById(R.id.textView12);
        t1 = (TextView) findViewById(R.id.textView9);
        t2.setPaintFlags(t2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        imageButton=(ImageButton)findViewById(R.id.imageButton);
        mrelativelayout=(RelativeLayout)findViewById(R.id.activity_details);
        Cursor res = null;
        switch (SeasonActivity.Item) {
            case 0: {
                res = SeasonActivity.mHelper.getalldata(TaskContract.TaskEntry.TABLE1);

                break;
            }
            case 1: {
                res = SeasonActivity.mHelper.getalldata(TaskContract.TaskEntry.TABLE2);
                break;
            }
            case 2: {
                res = SeasonActivity.mHelper.getalldata(TaskContract.TaskEntry.TABLE3);
                break;
            }
            case 3:{
                res = SeasonActivity.mHelper.getalldata(TaskContract.TaskEntry.TABLE4);
                break;
            }
        }
        switch (SeasonActivity.Item){
            case 0:{
                    switch (SeasonActivity.pos){
                        case 0:{
                            mrelativelayout.setBackgroundResource(R.drawable.s1e1);
                            break;
                        }
                        case 1:{
                            mrelativelayout.setBackgroundResource(R.drawable.s1e2);
                            break;
                        }
                        case 2:{
                            mrelativelayout.setBackgroundResource(R.drawable.s1e3);
                            break;
                        }
                    }
                break;
            }
            case 1:{
                switch (SeasonActivity.pos){
                    case 0:{
                        mrelativelayout.setBackgroundResource(R.drawable.s2e1);

                        break;
                    }
                    case 1:{
                        mrelativelayout.setBackgroundResource(R.drawable.s2e2);

                        break;
                    }
                    case 2:{
                        mrelativelayout.setBackgroundResource(R.drawable.s2e3);

                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (SeasonActivity.pos) {
                    case 0: {
                        mrelativelayout.setBackgroundResource(R.drawable.s3e1);
                        break;
                    }
                    case 1: {
                        mrelativelayout.setBackgroundResource(R.drawable.s3e2);
                        break;
                    }
                    case 2: {
                        mrelativelayout.setBackgroundResource(R.drawable.s3e3);
                        break;
                    }
                }
                break;
            }
            case 3:{
                switch (SeasonActivity.pos){
                    case 0: {
                        mrelativelayout.setBackgroundResource(R.drawable.s4e1);
                        break;
                    }
                    case 1: {
                        mrelativelayout.setBackgroundResource(R.drawable.s4e2);
                        break;
                    }
                    case 2: {
                        mrelativelayout.setBackgroundResource(R.drawable.s4e3);
                        break;
                    }
                }
            }
        }
        if (res != null) {
            res.moveToPosition(SeasonActivity.pos);
            t2.setText(res.getString(1));
            t3.setText(res.getString(2));
            t4.setText(res.getString(3));
            t1.setText(res.getString(4));
        }
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(DetailsActivity.this,VideoActivity.class);
                DetailsActivity.this.startActivity(registerIntent);
            }
        });
    }
}
