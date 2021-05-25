package com.google.android.gms.internal.ads;
public final class zzdcm implements zzelo<zzdck> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<zzdkv> zzglx;

    private zzdcm(zzelx<zzdvw> zzelx, zzelx<zzdkv> zzelx2) {
        this.zzerr = zzelx;
        this.zzglx = zzelx2;
    }

    public static zzdcm zzbc(zzelx<zzdvw> zzelx, zzelx<zzdkv> zzelx2) {
        return new zzdcm(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdck(this.zzerr.get(), this.zzglx.get());
    }
}
