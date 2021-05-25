package com.google.android.gms.internal.ads;
public final class zzcqu implements zzelo<zzcqr> {
    private final zzelx<zzcqq> zzgko;

    private zzcqu(zzelx<zzcqq> zzelx) {
        this.zzgko = zzelx;
    }

    public static zzcqu zzah(zzelx<zzcqq> zzelx) {
        return new zzcqu(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcqr(this.zzgko.get());
    }
}
