package com.my.target;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
public class ew extends fb {
    @Override // com.my.target.fb
    @WorkerThread
    public synchronized void collectData(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            removeAll();
            return;
        }
        int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        int intExtra3 = registerReceiver.getIntExtra("status", 1);
        if (intExtra >= 0 && intExtra2 > 0) {
            addParam(AuthSource.OPEN_BLACKLIST, String.valueOf((intExtra * 100) / intExtra2));
        }
        addParam("bs", String.valueOf(intExtra3));
    }
}
