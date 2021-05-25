package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
public final class zzdfc implements zzelo<zzdfb> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzaxg> zzesv;
    private final zzelx<ScheduledExecutorService> zzflu;

    public zzdfc(zzelx<zzaxg> zzelx, zzelx<Context> zzelx2, zzelx<ScheduledExecutorService> zzelx3, zzelx<Executor> zzelx4) {
        this.zzesv = zzelx;
        this.zzert = zzelx2;
        this.zzflu = zzelx3;
        this.zzerr = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdfb(this.zzesv.get(), this.zzert.get(), this.zzflu.get(), this.zzerr.get());
    }
}
