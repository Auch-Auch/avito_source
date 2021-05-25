package com.google.android.gms.internal.ads;
public final class zzccg implements zzelo<zzcdd> {
    private final zzccc zzfwr;
    private final zzelx<zzcbv> zzfwt;

    public zzccg(zzccc zzccc, zzelx<zzcbv> zzelx) {
        this.zzfwr = zzccc;
        this.zzfwt = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzcdd) zzelu.zza(this.zzfwt.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
