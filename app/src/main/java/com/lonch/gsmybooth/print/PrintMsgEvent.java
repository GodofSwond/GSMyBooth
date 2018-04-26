package com.lonch.gsmybooth.print;

/**
 * Created by ldx on 2018/4/26.
 * print message event
 */
public class PrintMsgEvent {
    public int type;
    public String msg;

    public PrintMsgEvent(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
