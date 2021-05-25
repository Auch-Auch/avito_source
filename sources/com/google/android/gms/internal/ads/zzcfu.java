package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
public final class zzcfu implements zzelo<zzcfj> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzcfe> zzfci;
    private final zzelx<zzcga> zzfcl;
    private final zzelx<zzbbg> zzfkr;
    private final zzelx<ScheduledExecutorService> zzflu;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzeg> zzfwp;
    private final zzelx<zzb> zzgbu;
    private final zzelx<zzto> zzgbv;

    public zzcfu(zzelx<Context> zzelx, zzelx<zzcfe> zzelx2, zzelx<zzeg> zzelx3, zzelx<zzbbg> zzelx4, zzelx<zzb> zzelx5, zzelx<zzto> zzelx6, zzelx<Executor> zzelx7, zzelx<zzdln> zzelx8, zzelx<zzcga> zzelx9, zzelx<ScheduledExecutorService> zzelx10) {
        this.zzert = zzelx;
        this.zzfci = zzelx2;
        this.zzfwp = zzelx3;
        this.zzfkr = zzelx4;
        this.zzgbu = zzelx5;
        this.zzgbv = zzelx6;
        this.zzerr = zzelx7;
        this.zzfos = zzelx8;
        this.zzfcl = zzelx9;
        this.zzflu = zzelx10;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcfj(this.zzert.get(), this.zzfci.get(), this.zzfwp.get(), this.zzfkr.get(), this.zzgbu.get(), this.zzgbv.get(), this.zzerr.get(), this.zzfos.get(), this.zzfcl.get(), this.zzflu.get());
    }
}
