package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
public final class zzbrv implements zzelo<zzbru> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzbtl> zzfrs;
    private final zzelx<zzdkx> zzfrt;
    private final zzelx<ScheduledExecutorService> zzfru;

    private zzbrv(zzelx<zzbtl> zzelx, zzelx<zzdkx> zzelx2, zzelx<ScheduledExecutorService> zzelx3, zzelx<Executor> zzelx4) {
        this.zzfrs = zzelx;
        this.zzfrt = zzelx2;
        this.zzfru = zzelx3;
        this.zzerr = zzelx4;
    }

    public static zzbrv zzb(zzelx<zzbtl> zzelx, zzelx<zzdkx> zzelx2, zzelx<ScheduledExecutorService> zzelx3, zzelx<Executor> zzelx4) {
        return new zzbrv(zzelx, zzelx2, zzelx3, zzelx4);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbru(this.zzfrs.get(), this.zzfrt.get(), this.zzfru.get(), this.zzerr.get());
    }
}
