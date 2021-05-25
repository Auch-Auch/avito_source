package com.google.android.gms.internal.ads;
public final class zzbny implements zzelo<zzbys<zzbuj>> {
    private final zzelx<zzbow> zzfnr;
    private final zzbnl zzfoq;

    public zzbny(zzbnl zzbnl, zzelx<zzbow> zzelx) {
        this.zzfoq = zzbnl;
        this.zzfnr = zzelx;
    }

    public static zzbys<zzbuj> zza(zzbnl zzbnl, zzbow zzbow) {
        return (zzbys) zzelu.zza(new zzbys(zzbow, zzbbi.zzedy), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfoq, this.zzfnr.get());
    }
}
