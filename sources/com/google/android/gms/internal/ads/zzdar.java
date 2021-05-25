package com.google.android.gms.internal.ads;
public final class zzdar implements zzelo<zzdap> {
    private final zzelx<zzbqq> zzeyg;
    private final zzelx<zzdmk> zzezq;
    private final zzelx<zzdln> zzfos;
    private final zzelx<String> zzgsv;
    private final zzelx<String> zzgtf;

    private zzdar(zzelx<String> zzelx, zzelx<String> zzelx2, zzelx<zzbqq> zzelx3, zzelx<zzdmk> zzelx4, zzelx<zzdln> zzelx5) {
        this.zzgsv = zzelx;
        this.zzgtf = zzelx2;
        this.zzeyg = zzelx3;
        this.zzezq = zzelx4;
        this.zzfos = zzelx5;
    }

    public static zzdar zzh(zzelx<String> zzelx, zzelx<String> zzelx2, zzelx<zzbqq> zzelx3, zzelx<zzdmk> zzelx4, zzelx<zzdln> zzelx5) {
        return new zzdar(zzelx, zzelx2, zzelx3, zzelx4, zzelx5);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdap(this.zzgsv.get(), this.zzgtf.get(), this.zzeyg.get(), this.zzezq.get(), this.zzfos.get());
    }
}
