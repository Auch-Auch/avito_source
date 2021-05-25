package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzbpk<AdT> implements zzelo<zzbph<AdT>> {
    private final zzelx<Map<String, zzcre<AdT>>> zzfpz;

    private zzbpk(zzelx<Map<String, zzcre<AdT>>> zzelx) {
        this.zzfpz = zzelx;
    }

    public static <AdT> zzbpk<AdT> zzd(zzelx<Map<String, zzcre<AdT>>> zzelx) {
        return new zzbpk<>(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbph(this.zzfpz.get());
    }
}
