package com.q.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by qli on 16/8/9.
 */
public class MyBroadCast extends BroadcastReceiver {
    public MyBroadCast() {
        Log.v("BROADCAST_TAG", "myBroadCast");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.v("BROADCAST_TAG", "onReceive");
    }
}
