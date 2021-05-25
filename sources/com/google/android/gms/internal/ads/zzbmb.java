package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
public final class zzbmb implements zzelo<zzbma> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzalz> zzfmp;
    private final zzelx<zzbly> zzfmq;
    private final zzelx<zzblr> zzfmr;
    private final zzelx<Clock> zzfms;

    private zzbmb(zzelx<zzalz> zzelx, zzelx<zzbly> zzelx2, zzelx<Executor> zzelx3, zzelx<zzblr> zzelx4, zzelx<Clock> zzelx5) {
        this.zzfmp = zzelx;
        this.zzfmq = zzelx2;
        this.zzerr = zzelx3;
        this.zzfmr = zzelx4;
        this.zzfms = zzelx5;
    }

    public static zzbmb zza(zzelx<zzalz> zzelx, zzelx<zzbly> zzelx2, zzelx<Executor> zzelx3, zzelx<zzblr> zzelx4, zzelx<Clock> zzelx5) {
        return new zzbmb(zzelx, zzelx2, zzelx3, zzelx4, zzelx5);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbma(this.zzfmp.get(), this.zzfmq.get(), this.zzerr.get(), this.zzfmr.get(), this.zzfms.get());
    }
}
