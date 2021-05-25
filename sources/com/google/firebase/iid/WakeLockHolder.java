package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public final class WakeLockHolder {
    public static final long a = TimeUnit.MINUTES.toMillis(1);
    public static final Object b = new Object();
    @GuardedBy("WakeLockHolder.syncObject")
    public static WakeLock c;

    @KeepForSdk
    public static void acquireWakeLock(Intent intent, long j) {
        synchronized (b) {
            if (c != null) {
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                c.acquire(j);
            }
        }
    }

    @KeepForSdk
    public static void completeWakefulIntent(@NonNull Intent intent) {
        synchronized (b) {
            if (c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                c.release();
            }
        }
    }

    @KeepForSdk
    public static void initWakeLock(Context context) {
        synchronized (b) {
            if (c == null) {
                WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                c = wakeLock;
                wakeLock.setReferenceCounted(true);
            }
        }
    }

    @KeepForSdk
    public static void reset() {
        synchronized (b) {
            c = null;
        }
    }

    public static ComponentName startWakefulService(@NonNull Context context, @NonNull Intent intent) {
        synchronized (b) {
            if (c == null) {
                WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                c = wakeLock;
                wakeLock.setReferenceCounted(true);
            }
            boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
            intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!booleanExtra) {
                c.acquire(a);
            }
            return startService;
        }
    }
}
