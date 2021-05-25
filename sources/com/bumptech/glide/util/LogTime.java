package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;
public final class LogTime {
    public static final double a = (1.0d / Math.pow(10.0d, 6.0d));

    public static double getElapsedMillis(long j) {
        return ((double) (getLogTime() - j)) * a;
    }

    @TargetApi(17)
    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
