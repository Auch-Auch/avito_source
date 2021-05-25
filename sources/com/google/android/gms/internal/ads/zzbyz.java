package com.google.android.gms.internal.ads;
public final class zzbyz implements zzelo<zzbza> {
    private final zzelx<zzdps> zzfbu;
    private final zzelx<zzdkx> zzflw;

    private zzbyz(zzelx<zzdkx> zzelx, zzelx<zzdps> zzelx2) {
        this.zzflw = zzelx;
        this.zzfbu = zzelx2;
    }

    public static zzbyz zzv(zzelx<zzdkx> zzelx, zzelx<zzdps> zzelx2) {
        return new zzbyz(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbza(this.zzflw.get(), this.zzfbu.get());
    }
}
