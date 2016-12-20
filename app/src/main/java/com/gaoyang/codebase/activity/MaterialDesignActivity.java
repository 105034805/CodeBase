package com.gaoyang.codebase.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaoyang.codebase.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoyang on 16/12/19.
 */

public class MaterialDesignActivity extends AppCompatActivity {
    private static final String TAG = "MaterialDesignActivity";

    @BindView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design_activity);

        ButterKnife.bind(this);

        init();

        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(coordinatorLayout, "I am snackbar", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Touch me", new View.OnClickListener() {
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
        adapter = new RecyclerAdapter(dataList, MaterialDesignActivity.this);
        recyclerView.setAdapter(adapter);
    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        private List<String> mList;
        Context mContext;
        RecyclerAdapter(List list, Context context) {
            mList = list;
            mContext = context;
        }

        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.material_design_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String str = String.valueOf(mList.get(position));
            holder.setData(str);
        }

        @Override
        public int getItemCount() {
            return mList == null ? 0 : mList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.textview)
            TextView textview;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);

            }

            void setData(String str) {
                textview.setText(""+str);
            }
        }
    }
}
