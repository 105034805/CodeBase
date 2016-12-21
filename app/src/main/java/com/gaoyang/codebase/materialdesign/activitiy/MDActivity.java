package com.gaoyang.codebase.materialdesign.activitiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gaoyang.codebase.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaoyang on 16/12/21.
 */

public class MDActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.button1)
    Button button1;

    @BindView(R.id.button2)
    Button button2;

    @BindView(R.id.button3)
    Button button3;

    @BindView(R.id.button4)
    Button button4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.md_toolbar_activity);
        ButterKnife.bind(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(initIntent(MDToolbarOneActivity.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(initIntent(MDToolbarTwoActivity.class));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(initIntent(MDToolbarThreeActivity.class));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(initIntent(MDToolbarFourActivity.class));
            }
        });
    }

    private Intent initIntent(java.lang.Class activity) {
        Intent intent = new Intent();
        intent.setClass(MDActivity.this, activity);
        return intent;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            startActivity(initIntent(MDToolbarOneActivity.class));
        } else if (view.getId() == R.id.button2) {
            startActivity(initIntent(MDToolbarTwoActivity.class));
        } else if (view.getId() == R.id.button3) {
            startActivity(initIntent(MDToolbarThreeActivity.class));
        } else if (view.getId() == R.id.button4) {
            startActivity(initIntent(MDToolbarFourActivity.class));
        }
    }
}
