package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzbsa implements zzelo<zzbrx> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdkx> zzfpe;
    private final zzelx<zzaqs> zzfsa;

    private zzbsa(zzelx<Context> zzelx, zzelx<zzdkx> zzelx2, zzelx<zzaqs> zzelx3) {
        this.zzert = zzelx;
        this.zzfpe = zzelx2;
        this.zzfsa = zzelx3;
    }

    public static zzbsa zzh(zzelx<Context> zzelx, zzelx<zzdkx> zzelx2, zzelx<zzaqs> zzelx3) {
        return new zzbsa(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbrx(this.zzert.get(), this.zzfpe.get(), this.zzfsa.get());
    }
}
