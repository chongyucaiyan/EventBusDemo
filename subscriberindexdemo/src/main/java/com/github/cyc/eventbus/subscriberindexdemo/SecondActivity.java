package com.github.cyc.eventbus.subscriberindexdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static void start(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initContentView();
    }

    private void initContentView() {
        findViewById(R.id.btn_second_post_event).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_second_post_event) {
            // 发布事件
            EventBus.getDefault().post(new MessageEvent("Hello EventBus!"));
        }
    }
}
