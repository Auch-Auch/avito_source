package com.google.android.gms.internal.ads;
public final class zzbrm implements zzelo<zzbys<zzbtp>> {
    private final zzelx<zzbrx> zzfmx;
    private final zzbqz zzfri;

    private zzbrm(zzbqz zzbqz, zzelx<zzbrx> zzelx) {
        this.zzfri = zzbqz;
        this.zzfmx = zzelx;
    }

    public static zzbrm zzc(zzbqz zzbqz, zzelx<zzbrx> zzelx) {
        return new zzbrm(zzbqz, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfmx.get(), zzbbi.zzedz), "Cannot return null from a non-@Nullable @Provides method");
    }
}
