package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
public final class zzcmu implements zzelo<zzcmi> {
    private final zzelx<zzcji> zzero;
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcls> zzeso;
    private final zzelx<ScheduledExecutorService> zzflu;
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<Executor> zzfol;
    private final zzelx<Context> zzggw;
    private final zzelx<WeakReference<Context>> zzggx;

    public zzcmu(zzelx<Executor> zzelx, zzelx<Context> zzelx2, zzelx<WeakReference<Context>> zzelx3, zzelx<Executor> zzelx4, zzelx<zzcji> zzelx5, zzelx<ScheduledExecutorService> zzelx6, zzelx<zzcls> zzelx7, zzelx<zzbbg> zzelx8) {
        this.zzfol = zzelx;
        this.zzggw = zzelx2;
        this.zzggx = zzelx3;
        this.zzerr = zzelx4;
        this.zzero = zzelx5;
        this.zzflu = zzelx6;
        this.zzeso = zzelx7;
        this.zzfnd = zzelx8;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcmi(this.zzfol.get(), this.zzggw.get(), this.zzggx.get(), this.zzerr.get(), this.zzero.get(), this.zzflu.get(), this.zzeso.get(), this.zzfnd.get());
    }
}
