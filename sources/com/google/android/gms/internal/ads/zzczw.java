package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzczw implements zzelo<zzczu> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdbj<zzdeq>> zzete;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzaxk> zzgsp;

    private zzczw(zzelx<zzdbj<zzdeq>> zzelx, zzelx<zzdln> zzelx2, zzelx<Context> zzelx3, zzelx<zzaxk> zzelx4) {
        this.zzete = zzelx;
        this.zzfos = zzelx2;
        this.zzert = zzelx3;
        this.zzgsp = zzelx4;
    }

    public static zzczw zzg(zzelx<zzdbj<zzdeq>> zzelx, zzelx<zzdln> zzelx2, zzelx<Context> zzelx3, zzelx<zzaxk> zzelx4) {
        return new zzczw(zzelx, zzelx2, zzelx3, zzelx4);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzczu(this.zzete.get(), this.zzfos.get(), this.zzert.get(), this.zzgsp.get());
    }
}
