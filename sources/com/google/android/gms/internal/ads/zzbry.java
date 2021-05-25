package com.google.android.gms.internal.ads;
public final class zzbry implements zzelo<zzbvb> {
    private final zzelx<zzbvb> zzfrw;

    private zzbry(zzelx<zzbvb> zzelx) {
        this.zzfrw = zzelx;
    }

    public static zzbry zzf(zzelx<zzbvb> zzelx) {
        return new zzbry(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbvb) zzelu.zza(this.zzfrw.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
