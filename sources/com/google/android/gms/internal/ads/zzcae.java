package com.google.android.gms.internal.ads;
public final class zzcae implements zzelo<zzbys<zzbuj>> {
    private final zzelx<zzcbb> zzfnr;
    private final zzbzw zzfva;

    private zzcae(zzbzw zzbzw, zzelx<zzcbb> zzelx) {
        this.zzfva = zzbzw;
        this.zzfnr = zzelx;
    }

    public static zzcae zzd(zzbzw zzbzw, zzelx<zzcbb> zzelx) {
        return new zzcae(zzbzw, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), zzbbi.zzedy), "Cannot return null from a non-@Nullable @Provides method");
    }
}
