package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcvg implements zzelo<zzcuv> {
    private final zzelx<Context> zzert;
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<Executor> zzfol;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzcih> zzgac;
    private final zzelx<zzchx> zzglj;

    public zzcvg(zzelx<Context> zzelx, zzelx<zzbbg> zzelx2, zzelx<zzdln> zzelx3, zzelx<Executor> zzelx4, zzelx<zzchx> zzelx5, zzelx<zzcih> zzelx6) {
        this.zzert = zzelx;
        this.zzfnd = zzelx2;
        this.zzfos = zzelx3;
        this.zzfol = zzelx4;
        this.zzglj = zzelx5;
        this.zzgac = zzelx6;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcuv(this.zzert.get(), this.zzfnd.get(), this.zzfos.get(), this.zzfol.get(), this.zzglj.get(), this.zzgac.get());
    }
}
