package com.github.cyc.eventbus.threadmodedemo;

/**
 * Created by cyc on 2017/12/27.
 */

public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
