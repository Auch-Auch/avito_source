package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzry {
    public final long value;
    public final int zzbtv;
    public final String zzbuf;

    public zzry(long j, String str, int i) {
        this.value = j;
        this.zzbuf = str;
        this.zzbtv = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzry)) {
            zzry zzry = (zzry) obj;
            if (zzry.value == this.value && zzry.zzbtv == this.zzbtv) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
