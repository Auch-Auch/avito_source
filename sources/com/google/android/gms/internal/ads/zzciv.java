package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
public final class zzciv implements zzelo<zzcih> {
    private final zzelx<Context> zzert;
    private final zzelx<zzabt> zzfcj;
    private final zzelx<zzbbg> zzfkr;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzbvb> zzfot;
    private final zzelx<zzeg> zzfwp;
    private final zzelx<zzto> zzgbv;
    private final zzelx<zzbfy> zzgcy;
    private final zzelx<zzb> zzgdn;
    private final zzelx<zzbzq> zzgdo;

    private zzciv(zzelx<zzbfy> zzelx, zzelx<Context> zzelx2, zzelx<zzdln> zzelx3, zzelx<zzeg> zzelx4, zzelx<zzabt> zzelx5, zzelx<zzbbg> zzelx6, zzelx<zzb> zzelx7, zzelx<zzto> zzelx8, zzelx<zzbvb> zzelx9, zzelx<zzbzq> zzelx10) {
        this.zzgcy = zzelx;
        this.zzert = zzelx2;
        this.zzfos = zzelx3;
        this.zzfwp = zzelx4;
        this.zzfcj = zzelx5;
        this.zzfkr = zzelx6;
        this.zzgdn = zzelx7;
        this.zzgbv = zzelx8;
        this.zzfot = zzelx9;
        this.zzgdo = zzelx10;
    }

    public static zzciv zzc(zzelx<zzbfy> zzelx, zzelx<Context> zzelx2, zzelx<zzdln> zzelx3, zzelx<zzeg> zzelx4, zzelx<zzabt> zzelx5, zzelx<zzbbg> zzelx6, zzelx<zzb> zzelx7, zzelx<zzto> zzelx8, zzelx<zzbvb> zzelx9, zzelx<zzbzq> zzelx10) {
        return new zzciv(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6, zzelx7, zzelx8, zzelx9, zzelx10);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcih(this.zzgcy.get(), this.zzert.get(), this.zzfos.get(), this.zzfwp.get(), this.zzfcj.get(), this.zzfkr.get(), this.zzgdn.get(), this.zzgbv.get(), this.zzfot.get(), this.zzgdo.get());
    }
}
