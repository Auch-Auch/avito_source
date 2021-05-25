package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
@KeepForSdk
public class HashAccumulator {
    @VisibleForTesting
    private static int zaa = 31;
    private int zab = 1;

    @RecentlyNonNull
    @KeepForSdk
    public HashAccumulator addObject(@Nullable Object obj) {
        this.zab = (zaa * this.zab) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @RecentlyNonNull
    @KeepForSdk
    public int hash() {
        return this.zab;
    }

    @RecentlyNonNull
    public final HashAccumulator zaa(@RecentlyNonNull boolean z) {
        this.zab = (zaa * this.zab) + (z ? 1 : 0);
        return this;
    }
}
