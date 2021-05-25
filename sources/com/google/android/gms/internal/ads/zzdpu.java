package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
public final class zzdpu implements zzelo<zzdps> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzbbh> zzesm;
    private final zzelx<zzdli> zzfjf;
    private final zzelx<zzeg> zzfly;
    private final zzelx<Clock> zzfms;
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<String> zzgsv;
    private final zzelx<String> zzgtf;
    private final zzelx<zzcud> zzhig;

    private zzdpu(zzelx<Executor> zzelx, zzelx<zzbbh> zzelx2, zzelx<zzcud> zzelx3, zzelx<zzbbg> zzelx4, zzelx<String> zzelx5, zzelx<String> zzelx6, zzelx<Context> zzelx7, zzelx<zzdli> zzelx8, zzelx<Clock> zzelx9, zzelx<zzeg> zzelx10) {
        this.zzerr = zzelx;
        this.zzesm = zzelx2;
        this.zzhig = zzelx3;
        this.zzfnd = zzelx4;
        this.zzgsv = zzelx5;
        this.zzgtf = zzelx6;
        this.zzert = zzelx7;
        this.zzfjf = zzelx8;
        this.zzfms = zzelx9;
        this.zzfly = zzelx10;
    }

    public static zzdpu zzd(zzelx<Executor> zzelx, zzelx<zzbbh> zzelx2, zzelx<zzcud> zzelx3, zzelx<zzbbg> zzelx4, zzelx<String> zzelx5, zzelx<String> zzelx6, zzelx<Context> zzelx7, zzelx<zzdli> zzelx8, zzelx<Clock> zzelx9, zzelx<zzeg> zzelx10) {
        return new zzdpu(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6, zzelx7, zzelx8, zzelx9, zzelx10);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdps(this.zzerr.get(), this.zzesm.get(), this.zzhig.get(), this.zzfnd.get(), this.zzgsv.get(), this.zzgtf.get(), this.zzert.get(), this.zzfjf.get(), this.zzfms.get(), this.zzfly.get());
    }
}
