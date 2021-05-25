package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzcgl implements zzelo<zzcga> {
    private final zzelx<Executor> zzfol;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzcih> zzgac;

    public zzcgl(zzelx<zzdln> zzelx, zzelx<Executor> zzelx2, zzelx<zzcih> zzelx3) {
        this.zzfos = zzelx;
        this.zzfol = zzelx2;
        this.zzgac = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcga(this.zzfos.get(), this.zzfol.get(), this.zzgac.get());
    }
}
