package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
public final class zzdft implements zzelo<zzdfp> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzaxg> zzesv;
    private final zzelx<ScheduledExecutorService> zzflu;
    private final zzelx<zzaxk> zzgsp;
    private final zzelx<Integer> zzgwf;

    public zzdft(zzelx<zzaxg> zzelx, zzelx<Integer> zzelx2, zzelx<Context> zzelx3, zzelx<zzaxk> zzelx4, zzelx<ScheduledExecutorService> zzelx5, zzelx<Executor> zzelx6) {
        this.zzesv = zzelx;
        this.zzgwf = zzelx2;
        this.zzert = zzelx3;
        this.zzgsp = zzelx4;
        this.zzflu = zzelx5;
        this.zzerr = zzelx6;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdfp(this.zzesv.get(), this.zzgwf.get().intValue(), this.zzert.get(), this.zzgsp.get(), this.zzflu.get(), this.zzerr.get());
    }
}
