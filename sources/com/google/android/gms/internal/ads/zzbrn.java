package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzbrn implements zzelo<zzbro> {
    private final zzelx<zzcmi> zzesp;
    private final zzelx<zzaya> zzeyo;
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<zzdln> zzfos;
    private final zzelx<Context> zzfrj;

    private zzbrn(zzelx<Context> zzelx, zzelx<zzdln> zzelx2, zzelx<zzbbg> zzelx3, zzelx<zzaya> zzelx4, zzelx<zzcmi> zzelx5) {
        this.zzfrj = zzelx;
        this.zzfos = zzelx2;
        this.zzfnd = zzelx3;
        this.zzeyo = zzelx4;
        this.zzesp = zzelx5;
    }

    public static zzbrn zzb(zzelx<Context> zzelx, zzelx<zzdln> zzelx2, zzelx<zzbbg> zzelx3, zzelx<zzaya> zzelx4, zzelx<zzcmi> zzelx5) {
        return new zzbrn(zzelx, zzelx2, zzelx3, zzelx4, zzelx5);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbro(this.zzfrj.get(), this.zzfos.get(), this.zzfnd.get(), this.zzeyo.get(), this.zzesp.get());
    }
}
