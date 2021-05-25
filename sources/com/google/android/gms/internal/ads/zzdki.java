package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzdki implements zzelo<zzdkd> {
    private final zzelx<zzbii> zzerp;
    private final zzelx<zzdli> zzfjf;
    private final zzelx<Executor> zzfol;
    private final zzelx<Context> zzgxc;
    private final zzelx<zzdiz<zzchx, zzchu>> zzgxd;
    private final zzelx<zzdje> zzgxe;
    private final zzelx<zzdlp> zzgxf;

    public zzdki(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<zzbii> zzelx3, zzelx<zzdiz<zzchx, zzchu>> zzelx4, zzelx<zzdje> zzelx5, zzelx<zzdlp> zzelx6, zzelx<zzdli> zzelx7) {
        this.zzgxc = zzelx;
        this.zzfol = zzelx2;
        this.zzerp = zzelx3;
        this.zzgxd = zzelx4;
        this.zzgxe = zzelx5;
        this.zzgxf = zzelx6;
        this.zzfjf = zzelx7;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdkd(this.zzgxc.get(), this.zzfol.get(), this.zzerp.get(), this.zzgxd.get(), this.zzgxe.get(), this.zzgxf.get(), this.zzfjf.get());
    }
}
