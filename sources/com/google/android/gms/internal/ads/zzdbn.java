package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
public final class zzdbn implements zzelo<zzdkv> {
    private final zzelx<Clock> zzfms;

    public zzdbn(zzelx<Clock> zzelx) {
        this.zzfms = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzdkv) zzelu.zza(new zzdkv(this.zzfms.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
