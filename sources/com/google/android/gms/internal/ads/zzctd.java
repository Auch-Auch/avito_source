package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzctd implements zzelo<zzctc> {
    private final zzelx<Context> zzert;
    private final zzelx<zzcar> zzglj;

    public zzctd(zzelx<Context> zzelx, zzelx<zzcar> zzelx2) {
        this.zzert = zzelx;
        this.zzglj = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzctc(this.zzert.get(), this.zzglj.get());
    }
}
