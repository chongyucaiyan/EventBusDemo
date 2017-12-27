package com.github.cyc.eventbus.subscriberindexdemo;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by cyc on 17/12/28.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 配置EventBus
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }
}
