package com.bluestacks.myapplication;

import android.app.Application;

import com.gamepop.tournament.sdk.android.TSDK;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TSDK.init(this);
    }
}
