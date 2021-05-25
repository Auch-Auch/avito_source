package com.google.android.gms.internal.ads;
public final class zzcjb implements zzelo<zzbys<zzbtp>> {
    private final zzelx<zzcja> zzfnr;
    private final zzcjc zzgds;

    private zzcjb(zzcjc zzcjc, zzelx<zzcja> zzelx) {
        this.zzgds = zzcjc;
        this.zzfnr = zzelx;
    }

    public static zzcjb zza(zzcjc zzcjc, zzelx<zzcja> zzelx) {
        return new zzcjb(zzcjc, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), zzbbi.zzedy), "Cannot return null from a non-@Nullable @Provides method");
    }
}
