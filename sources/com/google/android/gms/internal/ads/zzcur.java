package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcur implements zzelo<zzcuq> {
    private final zzelx<Context> zzert;
    private final zzelx<zzchx> zzglj;

    public zzcur(zzelx<Context> zzelx, zzelx<zzchx> zzelx2) {
        this.zzert = zzelx;
        this.zzglj = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcuq(this.zzert.get(), this.zzglj.get());
    }
}
