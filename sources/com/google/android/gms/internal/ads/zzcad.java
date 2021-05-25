package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
public final class zzcad implements zzelo<zzbys<zzo>> {
    private final zzelx<zzcbb> zzfnr;
    private final zzbzw zzfva;

    private zzcad(zzbzw zzbzw, zzelx<zzcbb> zzelx) {
        this.zzfva = zzbzw;
        this.zzfnr = zzelx;
    }

    public static zzcad zzc(zzbzw zzbzw, zzelx<zzcbb> zzelx) {
        return new zzcad(zzbzw, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), zzbbi.zzedy), "Cannot return null from a non-@Nullable @Provides method");
    }
}
