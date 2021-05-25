package com.google.android.gms.internal.ads;
public final class zzciz implements zzelo<zzcja> {
    private final zzelx<zzbfq> zzfoi;

    private zzciz(zzelx<zzbfq> zzelx) {
        this.zzfoi = zzelx;
    }

    public static zzciz zzaa(zzelx<zzbfq> zzelx) {
        return new zzciz(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcja(this.zzfoi.get());
    }
}
