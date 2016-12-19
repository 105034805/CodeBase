package com.gaoyang.codebase.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import com.gaoyang.codebase.R;

/**
 * Created by gaoyang on 16/12/19.
 */

public class MaterialDesignActivity extends AppCompatActivity {

    @
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design_activity);
    }
}
