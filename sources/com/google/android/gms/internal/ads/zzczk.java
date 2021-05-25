package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
public final class zzczk implements zzelo<zzczi> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdln> zzfos;
    private final zzelx<ViewGroup> zzgnb;
    private final zzelx<zzdvw> zzgsh;

    public zzczk(zzelx<zzdvw> zzelx, zzelx<Context> zzelx2, zzelx<zzdln> zzelx3, zzelx<ViewGroup> zzelx4) {
        this.zzgsh = zzelx;
        this.zzert = zzelx2;
        this.zzfos = zzelx3;
        this.zzgnb = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzczi(this.zzgsh.get(), this.zzert.get(), this.zzfos.get(), this.zzgnb.get());
    }
}
