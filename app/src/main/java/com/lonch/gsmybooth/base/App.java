package com.lonch.gsmybooth.base;

import android.app.Application;

/**
 * app初始化
 *
 * Created by ldx on 2018/4/26.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppInfo.init(getApplicationContext());
    }
}
