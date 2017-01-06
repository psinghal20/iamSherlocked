package com.example.psing.sherlocked2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t2 = (TextView) findViewById(R.id.textView10);
        t3 = (TextView) findViewById(R.id.textView11);
        t4 = (TextView) findViewById(R.id.textView12);
        t1 = (TextView) findViewById(R.id.textView9);
        imageView=(ImageView)findViewById(R.id.imageView2);
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
        }
        switch (SeasonActivity.Item){
            case 0:{
                    switch (EpisodeActivity.pos){
                        case 0:{
                            imageView.setImageResource(R.drawable.s1e1n);
                            break;
                        }
                        case 1:{
                            imageView.setImageResource(R.drawable.s1e2);
                            break;
                        }
                        case 2:{
                            imageView.setImageResource(R.drawable.s1e3);
                            break;
                        }
                    }
                break;
            }
            case 1:{
                switch (EpisodeActivity.pos){
                    case 0:{
                        imageView.setImageResource(R.drawable.s2e1);
                        break;
                    }
                    case 1:{
                        imageView.setImageResource(R.drawable.s2e2);
                        break;
                    }
                    case 2:{
                        imageView.setImageResource(R.drawable.s2e3);
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (EpisodeActivity.pos) {
                    case 0: {
                        imageView.setImageResource(R.drawable.s3e1);
                        break;
                    }
                    case 1: {
                        imageView.setImageResource(R.drawable.s3e2);
                        break;
                    }
                    case 2: {
                        imageView.setImageResource(R.drawable.s3e3);
                        break;
                    }
                }
                break;
            }
        }
        if (res != null) {
            res.moveToPosition(EpisodeActivity.pos);
            t2.setText(res.getString(1));
            t3.setText(res.getString(2));
            t4.setText(res.getString(3));
            t1.setText(res.getString(4));
        }
    }
}
