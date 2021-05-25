package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
public final class zzdcv implements zzelo<zzdco> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<zzaya> zzeyo;
    private final zzelx<zzdln> zzfos;
    private final zzelx<PackageInfo> zzfse;

    public zzdcv(zzelx<zzdvw> zzelx, zzelx<zzdln> zzelx2, zzelx<PackageInfo> zzelx3, zzelx<zzaya> zzelx4) {
        this.zzerr = zzelx;
        this.zzfos = zzelx2;
        this.zzfse = zzelx3;
        this.zzeyo = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdco(this.zzerr.get(), this.zzfos.get(), this.zzfse.get(), this.zzeyo.get());
    }
}
