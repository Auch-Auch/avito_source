package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;
public final class zzchn implements zzelo<zzchm> {
    private final zzelx<Context> zzert;
    private final zzelx<Executor> zzfol;
    private final zzelx<zzbbg> zzfsr;
    private final zzelx<zzeg> zzfwp;
    private final zzelx<zzb> zzgbu;
    private final zzelx<zzbfy> zzgcy;

    public zzchn(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<zzeg> zzelx3, zzelx<zzbbg> zzelx4, zzelx<zzb> zzelx5, zzelx<zzbfy> zzelx6) {
        this.zzert = zzelx;
        this.zzfol = zzelx2;
        this.zzfwp = zzelx3;
        this.zzfsr = zzelx4;
        this.zzgbu = zzelx5;
        this.zzgcy = zzelx6;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzchm(this.zzert.get(), this.zzfol.get(), this.zzfwp.get(), this.zzfsr.get(), this.zzgbu.get(), this.zzgcy.get());
    }
}
