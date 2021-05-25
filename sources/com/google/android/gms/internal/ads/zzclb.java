package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzclb implements zzelo<zzbys<zzdpl>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzclm> zzfmx;

    private zzclb(zzelx<zzclm> zzelx, zzelx<Executor> zzelx2) {
        this.zzfmx = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzclb zzal(zzelx<zzclm> zzelx, zzelx<Executor> zzelx2) {
        return new zzclb(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfmx.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
