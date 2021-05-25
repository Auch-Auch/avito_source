package com.yandex.runtime.sensors.internal.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.yandex.runtime.Runtime;
import java.util.ArrayList;
import java.util.List;
public class WifiSubscription extends BroadcastReceiver {
    private final String TAG = getClass().getCanonicalName();
    private boolean isRegistered = false;
    private long nativePromise;
    private WifiManager wifiManager = ((WifiManager) Runtime.getApplicationContext().getSystemService("wifi"));

    public static native void deleteNativePromise(long j);

    public static native void scanResultsAvailable(long j, List<WifiPointInfo> list);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startScanImpl(long j) {
        this.nativePromise = j;
        Context applicationContext = Runtime.getApplicationContext();
        applicationContext.registerReceiver(this, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        this.isRegistered = true;
        if (!this.wifiManager.isWifiEnabled() || !this.wifiManager.startScan()) {
            unregister(applicationContext);
            scanResultsAvailable(this.nativePromise, new ArrayList());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void unregister(Context context) {
        if (this.isRegistered) {
            context.unregisterReceiver(this);
            this.isRegistered = false;
        }
    }

    public void cancel() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.wifi.WifiSubscription.1
            @Override // java.lang.Runnable
            public void run() {
                WifiSubscription.this.unregister(Runtime.getApplicationContext());
            }
        });
    }

    @Override // java.lang.Object
    public void finalize() {
        deleteNativePromise(this.nativePromise);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        unregister(context);
        try {
            List<ScanResult> scanResults = this.wifiManager.getScanResults();
            if (scanResults != null) {
                ArrayList arrayList = new ArrayList(scanResults.size());
                for (ScanResult scanResult : scanResults) {
                    arrayList.add(new WifiPointInfo(scanResult));
                }
                scanResultsAvailable(this.nativePromise, arrayList);
            }
        } catch (SecurityException e) {
            e.toString();
        }
    }

    public void startScan(long j) {
        new Handler(Looper.getMainLooper()).post(new Runnable(j) { // from class: com.yandex.runtime.sensors.internal.wifi.WifiSubscription.1StartTask
            public long promise;

            {
                this.promise = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                WifiSubscription.this.startScanImpl(this.promise);
            }
        });
    }
}
