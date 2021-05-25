package com.google.android.gms.internal.ads;
public final class zzdae implements zzelo<zzdac> {
    private final zzelx<zzcji> zzero;
    private final zzelx<zzdvw> zzgsh;
    private final zzelx<String> zzgsv;

    private zzdae(zzelx<String> zzelx, zzelx<zzdvw> zzelx2, zzelx<zzcji> zzelx3) {
        this.zzgsv = zzelx;
        this.zzgsh = zzelx2;
        this.zzero = zzelx3;
    }

    public static zzdae zzq(zzelx<String> zzelx, zzelx<zzdvw> zzelx2, zzelx<zzcji> zzelx3) {
        return new zzdae(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdac(this.zzgsv.get(), this.zzgsh.get(), this.zzero.get());
    }
}
