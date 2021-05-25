package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcun implements zzelo<zzcul> {
    private final zzelx<Context> zzert;
    private final zzelx<Executor> zzfol;
    private final zzelx<zzchx> zzglj;

    public zzcun(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<zzchx> zzelx3) {
        this.zzert = zzelx;
        this.zzfol = zzelx2;
        this.zzglj = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcul(this.zzert.get(), this.zzfol.get(), this.zzglj.get());
    }
}
