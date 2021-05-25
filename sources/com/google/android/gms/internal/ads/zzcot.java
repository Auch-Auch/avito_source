package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcot implements zzelo<zzcou> {
    private final zzelx<Context> zzert;
    private final zzelx<zzawb> zzfku;

    private zzcot(zzelx<Context> zzelx, zzelx<zzawb> zzelx2) {
        this.zzert = zzelx;
        this.zzfku = zzelx2;
    }

    public static zzcot zzar(zzelx<Context> zzelx, zzelx<zzawb> zzelx2) {
        return new zzcot(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcou(this.zzert.get(), this.zzfku.get());
    }
}
