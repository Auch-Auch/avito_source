package com.google.android.gms.internal.ads;
public final class zzddi implements zzelo<zzddj> {
    private final zzelx<String> zzgeo;

    private zzddi(zzelx<String> zzelx) {
        this.zzgeo = zzelx;
    }

    public static zzddi zzap(zzelx<String> zzelx) {
        return new zzddi(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzddj(this.zzgeo.get());
    }
}
