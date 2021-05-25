package com.google.android.gms.internal.ads;
public final class zzdmh implements zzelo<zzbys<zzbsz>> {
    private final zzelx<zzdmk> zzfrb;
    private final zzdmi zzhdc;

    private zzdmh(zzdmi zzdmi, zzelx<zzdmk> zzelx) {
        this.zzhdc = zzdmi;
        this.zzfrb = zzelx;
    }

    public static zzdmh zza(zzdmi zzdmi, zzelx<zzdmk> zzelx) {
        return new zzdmh(zzdmi, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfrb.get(), zzbbi.zzedz), "Cannot return null from a non-@Nullable @Provides method");
    }
}
