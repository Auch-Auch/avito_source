package com.google.android.gms.internal.ads;
public final class zzcas implements zzelo<zzcap> {
    private final zzelx<zzbur> zzewj;
    private final zzelx<zzbyo> zzfja;

    private zzcas(zzelx<zzbur> zzelx, zzelx<zzbyo> zzelx2) {
        this.zzewj = zzelx;
        this.zzfja = zzelx2;
    }

    public static zzcas zzw(zzelx<zzbur> zzelx, zzelx<zzbyo> zzelx2) {
        return new zzcas(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcap(this.zzewj.get(), this.zzfja.get());
    }
}
