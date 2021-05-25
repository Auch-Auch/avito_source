package com.google.android.gms.internal.ads;
public final class zzdci implements zzelo<zzdcg> {
    private final zzelx<zzdvw> zzerr;

    private zzdci(zzelx<zzdvw> zzelx) {
        this.zzerr = zzelx;
    }

    public static zzdci zzao(zzelx<zzdvw> zzelx) {
        return new zzdci(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdcg(this.zzerr.get());
    }
}
