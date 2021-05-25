package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzcrw implements zzelo<zzcrn> {
    private final zzelx<Context> zzert;
    private final zzelx<Executor> zzfol;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzcih> zzgac;
    private final zzelx<zzboe> zzglj;
    private final zzelx<zzdsl<zzdkx, zzayy>> zzglm;

    public zzcrw(zzelx<zzboe> zzelx, zzelx<Context> zzelx2, zzelx<Executor> zzelx3, zzelx<zzcih> zzelx4, zzelx<zzdln> zzelx5, zzelx<zzdsl<zzdkx, zzayy>> zzelx6) {
        this.zzglj = zzelx;
        this.zzert = zzelx2;
        this.zzfol = zzelx3;
        this.zzgac = zzelx4;
        this.zzfos = zzelx5;
        this.zzglm = zzelx6;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcrn(this.zzglj.get(), this.zzert.get(), this.zzfol.get(), this.zzgac.get(), this.zzfos.get(), this.zzglm.get());
    }
}
