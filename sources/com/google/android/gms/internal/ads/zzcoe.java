package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
public final class zzcoe implements zzelo<zzcoa> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<zzcqq> zzeyy;
    private final zzelx<zzcmw> zzfcx;
    private final zzelx<ScheduledExecutorService> zzflu;
    private final zzelx<zzdln> zzfos;

    private zzcoe(zzelx<zzdln> zzelx, zzelx<zzcmw> zzelx2, zzelx<zzdvw> zzelx3, zzelx<ScheduledExecutorService> zzelx4, zzelx<zzcqq> zzelx5) {
        this.zzfos = zzelx;
        this.zzfcx = zzelx2;
        this.zzerr = zzelx3;
        this.zzflu = zzelx4;
        this.zzeyy = zzelx5;
    }

    public static zzcoe zzg(zzelx<zzdln> zzelx, zzelx<zzcmw> zzelx2, zzelx<zzdvw> zzelx3, zzelx<ScheduledExecutorService> zzelx4, zzelx<zzcqq> zzelx5) {
        return new zzcoe(zzelx, zzelx2, zzelx3, zzelx4, zzelx5);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcoa(this.zzfos.get(), this.zzfcx.get(), this.zzerr.get(), this.zzflu.get(), this.zzeyy.get());
    }
}
