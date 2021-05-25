package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
public final class zzdbl implements zzelo<zzdbj<zzdba>> {
    private final zzelx<Clock> zzfms;
    private final zzelx<zzdbd> zzgtr;

    public zzdbl(zzelx<zzdbd> zzelx, zzelx<Clock> zzelx2) {
        this.zzgtr = zzelx;
        this.zzfms = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzdbj) zzelu.zza(new zzdbj(this.zzgtr.get(), 10000, this.zzfms.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
