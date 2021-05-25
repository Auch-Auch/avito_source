package com.google.android.gms.internal.ads;
public final class zzcql implements zzelo<zzcqk> {
    private final zzelx<zzcqi> zzfbm;
    private final zzelx<zzdvw> zzgjv;

    private zzcql(zzelx<zzcqi> zzelx, zzelx<zzdvw> zzelx2) {
        this.zzfbm = zzelx;
        this.zzgjv = zzelx2;
    }

    public static zzcql zzav(zzelx<zzcqi> zzelx, zzelx<zzdvw> zzelx2) {
        return new zzcql(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcqk(this.zzfbm.get(), this.zzgjv.get());
    }
}
