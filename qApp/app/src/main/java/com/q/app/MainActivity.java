package com.q.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.q.app.adapters.LayoutAnimationAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mListView;

    private ArrayList<String> list;

    //LayoutAnimationController
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initData();

        initViews();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
    }

    private void initViews() {
        mListView = (ListView) findViewById(R.id.listView);
        LayoutAnimationAdapter layoutAnimationAdapter = new LayoutAnimationAdapter(MainActivity.this, list);
        mListView.setAdapter(layoutAnimationAdapter);
    }
}
