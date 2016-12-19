package com.gaoyang.codebase.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gaoyang.codebase.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoyang on 16/12/19.
 */

public class MaterialDesignActivity extends AppCompatActivity {

    @BindView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design_activity);

        ButterKnife.bind(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "I am snackbar", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
    }
}
