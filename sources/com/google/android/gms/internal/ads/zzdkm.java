package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdkm implements zzelo<zzdkl> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdli> zzfjf;
    private final zzelx<String> zzgxn;
    private final zzelx<zzdkd> zzgxo;
    private final zzelx<zzdje> zzgxp;

    public zzdkm(zzelx<String> zzelx, zzelx<zzdkd> zzelx2, zzelx<Context> zzelx3, zzelx<zzdje> zzelx4, zzelx<zzdli> zzelx5) {
        this.zzgxn = zzelx;
        this.zzgxo = zzelx2;
        this.zzert = zzelx3;
        this.zzgxp = zzelx4;
        this.zzfjf = zzelx5;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdkl(this.zzgxn.get(), this.zzgxo.get(), this.zzert.get(), this.zzgxp.get(), this.zzfjf.get());
    }
}
