package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzdam implements zzelo<zzdal> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzaxk> zzgsp;

    private zzdam(zzelx<Executor> zzelx, zzelx<zzaxk> zzelx2) {
        this.zzerr = zzelx;
        this.zzgsp = zzelx2;
    }

    public static zzdal zza(Executor executor, zzaxk zzaxk) {
        return new zzdal(executor, zzaxk);
    }

    public static zzdam zzay(zzelx<Executor> zzelx, zzelx<zzaxk> zzelx2) {
        return new zzdam(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzerr.get(), this.zzgsp.get());
    }
}
