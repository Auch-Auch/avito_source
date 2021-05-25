package com.google.android.gms.internal.ads;
public final class zzcwr implements zzelo<zzcws> {
    private final zzelx<zzcji> zzgog;

    private zzcwr(zzelx<zzcji> zzelx) {
        this.zzgog = zzelx;
    }

    public static zzcwr zzaj(zzelx<zzcji> zzelx) {
        return new zzcwr(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcws(this.zzgog.get());
    }
}
