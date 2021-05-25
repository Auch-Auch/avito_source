package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
public final class zzbye implements zzelo<zzcud> {
    private final zzelx<zzcuf> zzezo;
    private final zzelx<Clock> zzfms;
    private final zzbxj zzfug;

    private zzbye(zzbxj zzbxj, zzelx<Clock> zzelx, zzelx<zzcuf> zzelx2) {
        this.zzfug = zzbxj;
        this.zzfms = zzelx;
        this.zzezo = zzelx2;
    }

    public static zzbye zza(zzbxj zzbxj, zzelx<Clock> zzelx, zzelx<zzcuf> zzelx2) {
        return new zzbye(zzbxj, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzcud) zzelu.zza(this.zzfug.zza(this.zzfms.get(), this.zzezo.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
