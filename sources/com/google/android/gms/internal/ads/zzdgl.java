package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
public final class zzdgl implements zzelo<zzdgj> {
    private final zzelx<zzamh> zzesv;
    private final zzelx<ScheduledExecutorService> zzflu;
    private final zzelx<ApplicationInfo> zzghj;
    private final zzelx<Boolean> zzgwq;

    public zzdgl(zzelx<zzamh> zzelx, zzelx<ScheduledExecutorService> zzelx2, zzelx<Boolean> zzelx3, zzelx<ApplicationInfo> zzelx4) {
        this.zzesv = zzelx;
        this.zzflu = zzelx2;
        this.zzgwq = zzelx3;
        this.zzghj = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdgj(this.zzesv.get(), this.zzflu.get(), this.zzgwq.get().booleanValue(), this.zzghj.get());
    }
}
