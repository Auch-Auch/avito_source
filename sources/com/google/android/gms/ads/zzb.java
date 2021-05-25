package com.google.android.gms.ads;

import com.google.android.gms.common.util.VisibleForTesting;
@VisibleForTesting
public final class zzb {
    public static AdSize zza(int i, int i2, String str) {
        return new AdSize(i, i2, str);
    }

    public static boolean zzb(AdSize adSize) {
        return adSize.zzdr();
    }

    public static int zzc(AdSize adSize) {
        return adSize.zzds();
    }

    public static AdSize zza(int i, int i2) {
        AdSize adSize = new AdSize(i, 0);
        adSize.zzc(true);
        adSize.zzr(i2);
        return adSize;
    }

    public static boolean zza(AdSize adSize) {
        return adSize.zzdq();
    }
}
