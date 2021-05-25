package com.evernote.android.job.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.net.ConnectivityManagerCompat;
import com.evernote.android.job.JobRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class Device {
    @TargetApi(17)
    public static BatteryStatus getBatteryStatus(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return BatteryStatus.DEFAULT;
        }
        float intExtra = ((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        boolean z = false;
        int intExtra2 = registerReceiver.getIntExtra("plugged", 0);
        if (intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4) {
            z = true;
        }
        return new BatteryStatus(z, intExtra);
    }

    @NonNull
    public static JobRequest.NetworkType getNetworkType(@NonNull Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return JobRequest.NetworkType.ANY;
            }
            if (!ConnectivityManagerCompat.isActiveNetworkMetered(connectivityManager)) {
                return JobRequest.NetworkType.UNMETERED;
            }
            if (Build.VERSION.SDK_INT < 28) {
                z = activeNetworkInfo.isRoaming();
            } else {
                try {
                    z = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(18);
                } catch (Exception unused) {
                    z = activeNetworkInfo.isRoaming();
                }
            }
            if (z) {
                return JobRequest.NetworkType.CONNECTED;
            }
            return JobRequest.NetworkType.NOT_ROAMING;
        } catch (Throwable unused2) {
            return JobRequest.NetworkType.ANY;
        }
    }

    public static boolean isIdle(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (Build.VERSION.SDK_INT < 23) {
            return !powerManager.isInteractive();
        }
        if (powerManager.isDeviceIdleMode() || !powerManager.isInteractive()) {
            return true;
        }
        return false;
    }

    public static boolean isStorageLow() {
        return false;
    }
}
