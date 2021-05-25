package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
public final class zzabb {
    public static boolean zza(@Nullable zzabk zzabk, @Nullable zzabi zzabi, String... strArr) {
        if (zzabk == null || zzabi == null || !zzabk.zzcys) {
            return false;
        }
        return zzabk.zza(zzabi, zzp.zzkw().elapsedRealtime(), strArr);
    }

    @Nullable
    public static zzabi zzb(@Nullable zzabk zzabk) {
        if (zzabk == null) {
            return null;
        }
        return zzabk.zzex(zzp.zzkw().elapsedRealtime());
    }
}
