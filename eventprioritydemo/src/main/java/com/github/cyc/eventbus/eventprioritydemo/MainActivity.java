package com.github.cyc.eventbus.eventprioritydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContentView();
        // 注册订阅者
        EventBus.getDefault().register(this);
    }

    private void initContentView() {
        findViewById(R.id.btn_main_start_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_main_start_activity) {
            SecondActivity.start(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.POSTING, priority = 1)
    public void onMessageEvent1(MessageEvent event) {
        Log.i(TAG, "onMessageEvent1(), message is " + event.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.POSTING, priority = 2)
    public void onMessageEvent2(MessageEvent event) {
        Log.i(TAG, "onMessageEvent2(), message is " + event.getMessage());
        // 取消事件
        EventBus.getDefault().cancelEventDelivery(event);
    }

    @Subscribe(threadMode = ThreadMode.POSTING, priority = 3)
    public void onMessageEvent3(MessageEvent event) {
        Log.i(TAG, "onMessageEvent3(), message is " + event.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.POSTING, priority = 4)
    public void onMessageEvent4(MessageEvent event) {
        Log.i(TAG, "onMessageEvent4(), message is " + event.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.POSTING, priority = 5)
    public void onMessageEvent5(MessageEvent event) {
        Log.i(TAG, "onMessageEvent5(), message is " + event.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 注销订阅者
        EventBus.getDefault().unregister(this);
    }
}
