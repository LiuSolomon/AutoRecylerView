package com.example.modularizationtest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.example.modularizationtest.R;
import com.example.modularizationtest.utils.AutoPollAdapter;
import com.example.modularizationtest.utils.AutoPollRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LunActivity extends AppCompatActivity {

    private AutoPollRecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lun);
        initView();
    }

    private void initView() {
        mRecyclerView = (AutoPollRecyclerView) findViewById(R.id.list_main_promotions);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; ) {
            list.add(" Item: " + ++i);
        }
        AutoPollAdapter adapter = new AutoPollAdapter(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != mRecyclerView){
            mRecyclerView.stop();
        }
    }



}
