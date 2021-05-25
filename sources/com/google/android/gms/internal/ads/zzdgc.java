package com.google.android.gms.internal.ads;
public final class zzdgc implements zzelo<zzdga> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<zzaxc> zzesv;
    private final zzelx<String> zzfsc;

    public zzdgc(zzelx<zzaxc> zzelx, zzelx<zzdvw> zzelx2, zzelx<String> zzelx3) {
        this.zzesv = zzelx;
        this.zzerr = zzelx2;
        this.zzfsc = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdga(this.zzesv.get(), this.zzerr.get(), this.zzfsc.get());
    }
}
