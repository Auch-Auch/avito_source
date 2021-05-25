package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
public final class zzdax implements zzelo<zzdat> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<ScheduledExecutorService> zzflu;

    private zzdax(zzelx<Context> zzelx, zzelx<ScheduledExecutorService> zzelx2, zzelx<Executor> zzelx3) {
        this.zzert = zzelx;
        this.zzflu = zzelx2;
        this.zzerr = zzelx3;
    }

    public static zzdax zzr(zzelx<Context> zzelx, zzelx<ScheduledExecutorService> zzelx2, zzelx<Executor> zzelx3) {
        return new zzdax(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdat(this.zzert.get(), this.zzflu.get(), this.zzerr.get());
    }
}
