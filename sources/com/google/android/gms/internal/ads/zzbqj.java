package com.google.android.gms.internal.ads;
public final class zzbqj implements zzelo<zzbys<zzbsu>> {
    private final zzbqh zzfra;
    private final zzelx<zzbqq> zzfrb;

    private zzbqj(zzbqh zzbqh, zzelx<zzbqq> zzelx) {
        this.zzfra = zzbqh;
        this.zzfrb = zzelx;
    }

    public static zzbqj zza(zzbqh zzbqh, zzelx<zzbqq> zzelx) {
        return new zzbqj(zzbqh, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfrb.get(), zzbbi.zzedz), "Cannot return null from a non-@Nullable @Provides method");
    }
}
