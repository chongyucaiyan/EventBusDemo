package com.github.cyc.eventbus.stickyeventdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContentView();
    }

    private void initContentView() {
        findViewById(R.id.btn_main_post_event).setOnClickListener(this);
        findViewById(R.id.btn_main_start_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_post_event:
                // 发布粘性事件
                EventBus.getDefault().postSticky(new MessageEvent("Hello EventBus!"));
                break;

            case R.id.btn_main_start_activity:
                SecondActivity.start(this);
                break;

            default:
                break;
        }
    }
}
