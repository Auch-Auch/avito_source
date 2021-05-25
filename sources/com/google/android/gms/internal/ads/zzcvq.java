package com.google.android.gms.internal.ads;
public final class zzcvq extends zzcvw {
    private final zzbwp zzgof;

    public zzcvq(zzbst zzbst, zzbtl zzbtl, zzbtu zzbtu, zzbue zzbue, zzbws zzbws, zzbur zzbur, zzbzh zzbzh, zzbwp zzbwp, zzbtb zzbtb) {
        super(zzbst, zzbtl, zzbtu, zzbue, zzbws, zzbur, zzbzh, zzbwp, zzbtb);
        this.zzgof = zzbwp;
    }

    @Override // com.google.android.gms.internal.ads.zzcvw, com.google.android.gms.internal.ads.zzana
    public final void onAdImpression() {
        this.zzgof.zzaiy();
    }
}
