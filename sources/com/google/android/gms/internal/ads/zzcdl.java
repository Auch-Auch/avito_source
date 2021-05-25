package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcdl implements zzelo<zzavy> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdln> zzfos;
    private final zzcdh zzfyt;

    private zzcdl(zzcdh zzcdh, zzelx<Context> zzelx, zzelx<zzdln> zzelx2) {
        this.zzfyt = zzcdh;
        this.zzert = zzelx;
        this.zzfos = zzelx2;
    }

    public static zzcdl zza(zzcdh zzcdh, zzelx<Context> zzelx, zzelx<zzdln> zzelx2) {
        return new zzcdl(zzcdh, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzavy) zzelu.zza(new zzavy(this.zzert.get(), this.zzfos.get().zzhbv), "Cannot return null from a non-@Nullable @Provides method");
    }
}
