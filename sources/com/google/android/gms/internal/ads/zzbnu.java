package com.google.android.gms.internal.ads;
public final class zzbnu implements zzelo<zzbni> {
    private final zzelx<zzbnk> zzfgw;
    private final zzbnl zzfoq;

    public zzbnu(zzbnl zzbnl, zzelx<zzbnk> zzelx) {
        this.zzfoq = zzbnl;
        this.zzfgw = zzelx;
    }

    public static zzbni zza(zzbnl zzbnl, Object obj) {
        return (zzbni) zzelu.zza((zzbnk) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfoq, this.zzfgw.get());
    }
}
