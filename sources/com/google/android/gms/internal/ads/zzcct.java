package com.google.android.gms.internal.ads;
public final class zzcct implements zzelo<zzccu> {
    private final zzelx<zzccm> zzfxq;

    private zzcct(zzelx<zzccm> zzelx) {
        this.zzfxq = zzelx;
    }

    public static zzcct zzz(zzelx<zzccm> zzelx) {
        return new zzcct(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzccu(this.zzfxq.get());
    }
}
