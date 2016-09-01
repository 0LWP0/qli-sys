package com.q.app;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by qli on 16/8/5.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "900046697", true);
        // 初始化NoHttp
        NoHttp.initialize(this);
        // 开启调试模式
        Logger.setDebug(true);
        Logger.setTag("NoHttpSample");
//        EventBus;
    }
}
