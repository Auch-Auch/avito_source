package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
@ShowFirstParty
@KeepForSdk
public interface Clock {
    @RecentlyNonNull
    @KeepForSdk
    long currentThreadTimeMillis();

    @RecentlyNonNull
    @KeepForSdk
    long currentTimeMillis();

    @RecentlyNonNull
    @KeepForSdk
    long elapsedRealtime();

    @RecentlyNonNull
    @KeepForSdk
    long nanoTime();
}
