package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdmn implements zzelo<zzdmm> {
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<Context> zzfrj;
    private final zzelx<zzaxk> zzgsp;

    public zzdmn(zzelx<Context> zzelx, zzelx<zzbbg> zzelx2, zzelx<zzaxk> zzelx3) {
        this.zzfrj = zzelx;
        this.zzfnd = zzelx2;
        this.zzgsp = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdmm(this.zzfrj.get(), this.zzfnd.get(), this.zzgsp.get());
    }
}
