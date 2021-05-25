package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;
public final class zzbph<AdT> implements zzbpi<AdT> {
    private final Map<String, zzcre<AdT>> zzfpx;

    public zzbph(Map<String, zzcre<AdT>> map) {
        this.zzfpx = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbpi
    @Nullable
    public final zzcre<AdT> zze(int i, String str) {
        return this.zzfpx.get(str);
    }
}
