package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzckv implements zzelo<zzckw> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdlt> zzetm;
    private final zzelx<zzcli> zzetn;
    private final zzelx<zzdkx> zzflw;
    private final zzelx<zzdlj> zzgew;

    private zzckv(zzelx<Context> zzelx, zzelx<zzdlt> zzelx2, zzelx<zzcli> zzelx3, zzelx<zzdlj> zzelx4, zzelx<zzdkx> zzelx5) {
        this.zzert = zzelx;
        this.zzetm = zzelx2;
        this.zzetn = zzelx3;
        this.zzgew = zzelx4;
        this.zzflw = zzelx5;
    }

    public static zzckv zzf(zzelx<Context> zzelx, zzelx<zzdlt> zzelx2, zzelx<zzcli> zzelx3, zzelx<zzdlj> zzelx4, zzelx<zzdkx> zzelx5) {
        return new zzckv(zzelx, zzelx2, zzelx3, zzelx4, zzelx5);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzckw(this.zzert.get(), this.zzetm.get(), this.zzetn.get(), this.zzgew.get(), this.zzflw.get());
    }
}
