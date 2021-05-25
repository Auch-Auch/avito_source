package com.google.android.gms.internal.ads;
public final class zzcvn extends zzcuu {
    private final zzbwp zzgof;

    public zzcvn(zzbst zzbst, zzbtl zzbtl, zzbtu zzbtu, zzbue zzbue, zzbtb zzbtb, zzbws zzbws, zzbzh zzbzh, zzbur zzbur, zzbzc zzbzc, zzbwp zzbwp) {
        super(zzbst, zzbtl, zzbtu, zzbue, zzbtb, zzbws, zzbzh, zzbur, zzbzc, zzbwp);
        this.zzgof = zzbwp;
    }

    @Override // com.google.android.gms.internal.ads.zzcvw, com.google.android.gms.internal.ads.zzana
    public final void onAdImpression() {
        this.zzgof.zzaiy();
    }
}
