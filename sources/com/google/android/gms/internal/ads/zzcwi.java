package com.google.android.gms.internal.ads;
public final class zzcwi<AdT> implements zzelo<zzcwe<AdT>> {
    private final zzelx<zzdvw> zzfol;
    private final zzelx<zzdpf> zzfow;
    private final zzelx<zzabq> zzgow;
    private final zzelx<zzcwf<AdT>> zzgpd;

    public zzcwi(zzelx<zzdpf> zzelx, zzelx<zzdvw> zzelx2, zzelx<zzabq> zzelx3, zzelx<zzcwf<AdT>> zzelx4) {
        this.zzfow = zzelx;
        this.zzfol = zzelx2;
        this.zzgow = zzelx3;
        this.zzgpd = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcwe(this.zzfow.get(), this.zzfol.get(), this.zzgow.get(), this.zzgpd.get());
    }
}
