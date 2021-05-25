package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcse implements zzelo<zzcsa> {
    private final zzelx<Context> zzert;
    private final zzelx<zzboe> zzglj;

    public zzcse(zzelx<Context> zzelx, zzelx<zzboe> zzelx2) {
        this.zzert = zzelx;
        this.zzglj = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcsa(this.zzert.get(), this.zzglj.get());
    }
}
