package com.google.android.gms.internal.ads;
public final class zzdai implements zzelo<zzdag> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<zzdln> zzfos;

    private zzdai(zzelx<zzdvw> zzelx, zzelx<zzdln> zzelx2) {
        this.zzerr = zzelx;
        this.zzfos = zzelx2;
    }

    public static zzdai zzax(zzelx<zzdvw> zzelx, zzelx<zzdln> zzelx2) {
        return new zzdai(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdag(this.zzerr.get(), this.zzfos.get());
    }
}
