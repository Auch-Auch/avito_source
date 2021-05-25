package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
public final class zzcns implements zzelo<zzcnq> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<ScheduledExecutorService> zzflu;
    private final zzelx<zzcol> zzghe;
    private final zzelx<zzcpj> zzghf;

    public zzcns(zzelx<ScheduledExecutorService> zzelx, zzelx<zzdvw> zzelx2, zzelx<zzcol> zzelx3, zzelx<zzcpj> zzelx4) {
        this.zzflu = zzelx;
        this.zzerr = zzelx2;
        this.zzghe = zzelx3;
        this.zzghf = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcnq(this.zzflu.get(), this.zzerr.get(), this.zzghe.get(), zzell.zzat(this.zzghf));
    }
}
