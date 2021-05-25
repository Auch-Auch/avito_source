package com.google.android.gms.internal.ads;
public final class zzdce implements zzelo<zzdcc> {
    private final zzelx<zzdvw> zzerr;

    private zzdce(zzelx<zzdvw> zzelx) {
        this.zzerr = zzelx;
    }

    public static zzdce zzan(zzelx<zzdvw> zzelx) {
        return new zzdce(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdcc(this.zzerr.get());
    }
}
