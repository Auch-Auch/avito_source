package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
@KeepForSdk
@Deprecated
public class WakeLockTracker {
    private static WakeLockTracker zza = new WakeLockTracker();
    @VisibleForTesting
    private static boolean zzb = false;

    @RecentlyNonNull
    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zza;
    }

    @KeepForSdk
    public void registerAcquireEvent(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull int i, @RecentlyNonNull String str4) {
    }

    @KeepForSdk
    public void registerDeadlineEvent(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull int i, @RecentlyNonNull List<String> list, @RecentlyNonNull boolean z, @RecentlyNonNull long j) {
    }

    @KeepForSdk
    public void registerEvent(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull String str4, @RecentlyNonNull int i2, @RecentlyNonNull List<String> list) {
    }

    @KeepForSdk
    public void registerEvent(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull String str2, @RecentlyNonNull String str3, @RecentlyNonNull String str4, @RecentlyNonNull int i2, @RecentlyNonNull List<String> list, @RecentlyNonNull long j) {
    }

    @KeepForSdk
    public void registerReleaseEvent(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent) {
    }
}
