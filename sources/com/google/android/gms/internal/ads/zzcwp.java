package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcwp implements zzelo<zzcwl> {
    private final zzelx<Context> zzert;
    private final zzelx<zzcar> zzglj;

    public zzcwp(zzelx<Context> zzelx, zzelx<zzcar> zzelx2) {
        this.zzert = zzelx;
        this.zzglj = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcwl(this.zzert.get(), this.zzglj.get());
    }
}
