package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzctu implements zzelo<zzctp> {
    private final zzelx<Context> zzert;
    private final zzelx<zzcbn> zzglj;

    public zzctu(zzelx<Context> zzelx, zzelx<zzcbn> zzelx2) {
        this.zzert = zzelx;
        this.zzglj = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzctp(this.zzert.get(), this.zzglj.get());
    }
}
