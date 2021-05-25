package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcgy implements zzelo<zzcgw> {
    private final zzelx<zzcdr> zzexm;
    private final zzelx<Context> zzfrj;
    private final zzelx<zzccv> zzfwo;
    private final zzelx<zzcco> zzgcf;

    private zzcgy(zzelx<Context> zzelx, zzelx<zzccv> zzelx2, zzelx<zzcdr> zzelx3, zzelx<zzcco> zzelx4) {
        this.zzfrj = zzelx;
        this.zzfwo = zzelx2;
        this.zzexm = zzelx3;
        this.zzgcf = zzelx4;
    }

    public static zzcgy zzc(zzelx<Context> zzelx, zzelx<zzccv> zzelx2, zzelx<zzcdr> zzelx3, zzelx<zzcco> zzelx4) {
        return new zzcgy(zzelx, zzelx2, zzelx3, zzelx4);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcgw(this.zzfrj.get(), this.zzfwo.get(), this.zzexm.get(), this.zzgcf.get());
    }
}
