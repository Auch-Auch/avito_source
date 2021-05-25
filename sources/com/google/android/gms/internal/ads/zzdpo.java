package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
public final class zzdpo implements zzelo<zzdpf> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<zzdpi> zzezl;
    private final zzelx<ScheduledExecutorService> zzfnz;

    private zzdpo(zzelx<zzdvw> zzelx, zzelx<ScheduledExecutorService> zzelx2, zzelx<zzdpi> zzelx3) {
        this.zzerr = zzelx;
        this.zzfnz = zzelx2;
        this.zzezl = zzelx3;
    }

    public static zzdpo zzv(zzelx<zzdvw> zzelx, zzelx<ScheduledExecutorService> zzelx2, zzelx<zzdpi> zzelx3) {
        return new zzdpo(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdpf(this.zzerr.get(), this.zzfnz.get(), this.zzezl.get());
    }
}
