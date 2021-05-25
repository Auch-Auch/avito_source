package com.google.android.gms.internal.ads;
public final class zzcgp implements zzelo<zzcgo> {
    private final zzelx<zzccv> zzfwo;
    private final zzelx<zzcco> zzgcf;

    private zzcgp(zzelx<zzcco> zzelx, zzelx<zzccv> zzelx2) {
        this.zzgcf = zzelx;
        this.zzfwo = zzelx2;
    }

    public static zzcgp zzy(zzelx<zzcco> zzelx, zzelx<zzccv> zzelx2) {
        return new zzcgp(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcgo(this.zzgcf.get(), this.zzfwo.get());
    }
}
