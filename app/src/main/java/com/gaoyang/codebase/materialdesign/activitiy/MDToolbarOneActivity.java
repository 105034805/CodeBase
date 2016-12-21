package com.gaoyang.codebase.materialdesign.activitiy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gaoyang.codebase.R;
import com.gaoyang.codebase.materialdesign.adapter.MDAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoyang on 16/12/19.
 * Toolbar: scroll|enterAlways
 */

public class MDToolbarOneActivity extends MDToolbarActivity {
    private static final String TAG = "MDToolbarOneActivity";

    @BindView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;
    private MDAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.md_toolbar_one_activity);

        ButterKnife.bind(this);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();

        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(coordinatorLayout, "I am snackbar", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.setActionTextColor(getResources().getColor(android.R.color.holo_purple));
                snackbar.show();
            }
        });
    }

    private void init() {
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        List<String> dataList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            dataList.add("DIY-ITEM:" + i);
        }
        adapter = new MDAdapter(dataList, MDToolbarOneActivity.this);
        recyclerView.setAdapter(adapter);
    }


}
