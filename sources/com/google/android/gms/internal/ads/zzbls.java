package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
public final class zzbls implements zzelo<zzbln> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzdps> zzfbu;
    private final zzelx<zzabt> zzfcj;
    private final zzelx<ScheduledExecutorService> zzflu;
    private final zzelx<zzdlj> zzflv;
    private final zzelx<zzdkx> zzflw;
    private final zzelx<View> zzflx;
    private final zzelx<zzeg> zzfly;
    private final zzelx<zzaby> zzflz;

    private zzbls(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<ScheduledExecutorService> zzelx3, zzelx<zzdlj> zzelx4, zzelx<zzdkx> zzelx5, zzelx<zzdps> zzelx6, zzelx<View> zzelx7, zzelx<zzeg> zzelx8, zzelx<zzabt> zzelx9, zzelx<zzaby> zzelx10) {
        this.zzert = zzelx;
        this.zzerr = zzelx2;
        this.zzflu = zzelx3;
        this.zzflv = zzelx4;
        this.zzflw = zzelx5;
        this.zzfbu = zzelx6;
        this.zzflx = zzelx7;
        this.zzfly = zzelx8;
        this.zzfcj = zzelx9;
        this.zzflz = zzelx10;
    }

    public static zzbls zza(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<ScheduledExecutorService> zzelx3, zzelx<zzdlj> zzelx4, zzelx<zzdkx> zzelx5, zzelx<zzdps> zzelx6, zzelx<View> zzelx7, zzelx<zzeg> zzelx8, zzelx<zzabt> zzelx9, zzelx<zzaby> zzelx10) {
        return new zzbls(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6, zzelx7, zzelx8, zzelx9, zzelx10);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbln(this.zzert.get(), this.zzerr.get(), this.zzflu.get(), this.zzflv.get(), this.zzflw.get(), this.zzfbu.get(), this.zzflx.get(), this.zzfly.get(), this.zzfcj.get(), this.zzflz.get());
    }
}
