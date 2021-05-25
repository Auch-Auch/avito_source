package com.google.android.gms.common.util;

import android.os.SystemClock;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
public /* synthetic */ class Clock$$CC {
    @RecentlyNonNull
    @KeepForSdk
    public static long currentThreadTimeMillis$$dflt$$(@RecentlyNonNull Clock clock) {
        return SystemClock.currentThreadTimeMillis();
    }
}
