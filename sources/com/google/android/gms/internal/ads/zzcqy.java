package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcqy implements zzelo<zzcqt> {
    private final zzelx<Context> zzert;
    private final zzelx<zzcqq> zzeyy;
    private final zzelx<zzcqk> zzfbn;
    private final zzelx<zzbrz> zzgkv;

    private zzcqy(zzelx<Context> zzelx, zzelx<zzbrz> zzelx2, zzelx<zzcqq> zzelx3, zzelx<zzcqk> zzelx4) {
        this.zzert = zzelx;
        this.zzgkv = zzelx2;
        this.zzeyy = zzelx3;
        this.zzfbn = zzelx4;
    }

    public static zzcqy zze(zzelx<Context> zzelx, zzelx<zzbrz> zzelx2, zzelx<zzcqq> zzelx3, zzelx<zzcqk> zzelx4) {
        return new zzcqy(zzelx, zzelx2, zzelx3, zzelx4);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcqt(this.zzert.get(), this.zzgkv.get(), this.zzeyy.get(), this.zzfbn.get());
    }
}
