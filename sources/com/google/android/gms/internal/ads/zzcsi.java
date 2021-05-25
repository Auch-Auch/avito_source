package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcsi implements zzelo<zzcsd> {
    private final zzelx<Context> zzert;
    private final zzelx<Executor> zzfol;
    private final zzelx<zzcar> zzglj;
    private final zzelx<zzdkv> zzglx;

    public zzcsi(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<zzcar> zzelx3, zzelx<zzdkv> zzelx4) {
        this.zzert = zzelx;
        this.zzfol = zzelx2;
        this.zzglj = zzelx3;
        this.zzglx = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcsd(this.zzert.get(), this.zzfol.get(), this.zzglj.get(), this.zzglx.get());
    }
}
