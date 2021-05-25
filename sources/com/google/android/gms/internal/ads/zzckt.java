package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzckt implements zzelo<zzcks> {
    private final zzelx<zzto> zzgek;
    private final zzelx<Map<zzdpg, zzcku>> zzges;

    private zzckt(zzelx<zzto> zzelx, zzelx<Map<zzdpg, zzcku>> zzelx2) {
        this.zzgek = zzelx;
        this.zzges = zzelx2;
    }

    public static zzckt zzah(zzelx<zzto> zzelx, zzelx<Map<zzdpg, zzcku>> zzelx2) {
        return new zzckt(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcks(this.zzgek.get(), this.zzges.get());
    }
}
