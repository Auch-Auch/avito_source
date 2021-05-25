package com.yandex.runtime.connectivity.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.Runtime;
import com.yandex.runtime.connectivity.ConnectivityStatus;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
public class ConnectivitySubscription extends BroadcastReceiver {
    public static final String ACTION_CONNECTIVITY_CHANGED = "com.yandex.runtime.internal.CONNECTIVITY_CHANGED";
    private static final String ACTION_LIGHT_DEVICE_IDLE_MODE_CHANGED = "android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED";
    private static final String TAG = ConnectivitySubscription.class.getCanonicalName();
    private ConnectivityManager connectivityManager = ((ConnectivityManager) Runtime.getApplicationContext().getSystemService("connectivity"));
    private boolean isRegistered = false;
    private Object jobScheduler = Runtime.getApplicationContext().getSystemService("jobscheduler");
    private NativeObject nativePromise;

    public static native void submit(NativeObject nativeObject, ConnectivityStatus connectivityStatus);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void update(ConnectivityStatus connectivityStatus) {
        try {
            submit(this.nativePromise, connectivityStatus);
        } catch (UnsatisfiedLinkError e) {
            e.getMessage();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        ConnectivityStatus status = status();
        update(status);
        if ((action == ACTION_LIGHT_DEVICE_IDLE_MODE_CHANGED || action == "android.os.action.DEVICE_IDLE_MODE_CHANGED") && status == ConnectivityStatus.NONE) {
            ((JobScheduler) this.jobScheduler).schedule(new JobInfo.Builder(4105, new ComponentName(Runtime.getApplicationContext(), ConnectivityService.class)).setRequiredNetworkType(1).build());
        }
    }

    public ConnectivityStatus status() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return ConnectivityStatus.NONE;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0 || type == 4 || type == 7) {
            return ConnectivityStatus.CELLULAR;
        }
        return ConnectivityStatus.BROADBAND;
    }

    public void subscribe(NativeObject nativeObject) {
        this.nativePromise = nativeObject;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.connectivity.internal.ConnectivitySubscription.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NetworkChangeReceiver.CONNECTIVITY_ACTION);
                intentFilter.addAction(ConnectivitySubscription.ACTION_CONNECTIVITY_CHANGED);
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
                intentFilter.addAction(ConnectivitySubscription.ACTION_LIGHT_DEVICE_IDLE_MODE_CHANGED);
                try {
                    Runtime.getApplicationContext().registerReceiver(ConnectivitySubscription.this, intentFilter);
                    ConnectivitySubscription.this.isRegistered = true;
                    ConnectivitySubscription connectivitySubscription = ConnectivitySubscription.this;
                    connectivitySubscription.update(connectivitySubscription.status());
                } catch (SecurityException unused) {
                    String unused2 = ConnectivitySubscription.TAG;
                }
            }
        });
    }

    public void unsubscribe() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.connectivity.internal.ConnectivitySubscription.2
            @Override // java.lang.Runnable
            public void run() {
                if (ConnectivitySubscription.this.isRegistered) {
                    Runtime.getApplicationContext().unregisterReceiver(ConnectivitySubscription.this);
                }
                ConnectivitySubscription.this.isRegistered = false;
            }
        });
    }
}
