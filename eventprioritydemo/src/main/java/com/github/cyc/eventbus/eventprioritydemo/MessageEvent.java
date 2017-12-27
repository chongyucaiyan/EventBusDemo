package com.github.cyc.eventbus.eventprioritydemo;

/**
 * Created by cyc on 17/12/28.
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
